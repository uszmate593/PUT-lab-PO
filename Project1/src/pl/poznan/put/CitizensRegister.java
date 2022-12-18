package pl.poznan.put;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CitizensRegister
{
    private Map<String,CitizenRecord> records = new HashMap<String,CitizenRecord>();
    private int firstUndecleredId;

    public CitizensRegister(int firstUndecleredId)
    {
        this.firstUndecleredId = firstUndecleredId;
    }

    public CitizensRegister()
    {
        this(1);
    }

    public void PersonalInformation(String citizenId)
    {
        Map<String,String> data;
        if(records.containsKey(citizenId))
            data = records.get(citizenId).Content();
        else
        {
            System.out.println("Person with that id does not exist.");
            return;
        }
        System.out.println("/////////////////////////////////////////////////////////////////////////");
        System.out.println("Name: " + data.get("Name"));
        System.out.println("Id Number: " + data.get("Id"));
        System.out.println("Sex: " + data.get("Sex"));
        System.out.println("Date of birth: " + data.get("DateOfBirth"));
        System.out.println("Mother: " + data.get("MotherId"));
        System.out.println("Father: " + data.get("FatherId"));
        System.out.println("Spouse: " + data.get("CurrentPartnerId"));
        System.out.println("Profession: " + data.get("Job"));
        System.out.println("Children:");
        this.Children(data.get("Id"));
        System.out.println("/////////////////////////////////////////////////////////////////////////");
    }

    public void AddCitizen()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter day of birth (number):");
        int dayOfBirth = in.nextInt();

        System.out.println("Enter month of birth (number):");
        int monthOfBirth = in.nextInt();

        System.out.println("Enter year of birth (4 digits):");
        int yearOfBirth = in.nextInt();
        in.nextLine();

        System.out.println("Enter surname:");
        String surname = in.nextLine();

        System.out.println("Enter names (in one line):");
        String names = in.nextLine();

        System.out.println("Enter sex:");
        String sex = in.nextLine();

        System.out.println("Enter Id Number of mother (0 if unknown):");
        String motherId = in.nextLine();
        if(motherId.equals("0"))
            motherId = "Unknown";
        else if(!records.containsKey(motherId))
        {
            System.out.println("Citizen with Id Number " + motherId +  " does not exist.");
            return;
        }

        System.out.println("Enter Id Number of father (0 if unknown):");
        String fatherId = in.nextLine();
        if(fatherId.equals("0"))
            fatherId = "Unknown";
        else if(!records.containsKey(fatherId))
        {
            System.out.println("Citizen with Id Number " + fatherId +  " does not exist.");
            return;
        }
        Citizen newCitizen = new Citizen(dayOfBirth, monthOfBirth, yearOfBirth, names, surname, Integer.toString(firstUndecleredId), sex , motherId, fatherId);
        ArrayList<String> empty1 = new ArrayList<String>();
        ArrayList<String> empty2 = new ArrayList<String>();
        records.put(Integer.toString(firstUndecleredId), new CitizenRecord(newCitizen, empty1, "Unemployed", empty2));
        if(!motherId.equals("Unknown"))
            records.get(motherId).AssignChild(Integer.toString(firstUndecleredId));
        if(!fatherId.equals("Unknown"))
            records.get(fatherId).AssignChild(Integer.toString(firstUndecleredId));
        firstUndecleredId++;
    }

    public void UpdateRecord(String citizenId)
    {
        if(!records.containsKey(citizenId))
        {
            System.out.println("Citizen with Id Number " + citizenId +  " does not exist.");
            return;
        }
        Scanner in = new Scanner(System.in);
        Map<String,String> arguments = new HashMap<String,String>();

        System.out.println("Change names? (y/any key)");
        switch(in.nextLine())
        {
            case "y":
                System.out.println("Enter names (in one line):");
                String value = in.nextLine();
                arguments.put("names", value);
        }

        System.out.println("Change surname? (y/any key)");
        switch(in.nextLine())
        {
            case "y":
                System.out.println("Enter surname:");
                String value = in.nextLine();
                arguments.put("names", value);
        }

        System.out.println("Change profession? (y/any key)");
        switch(in.nextLine())
        {
            case "y":
                System.out.println("Enter profession name:");
                String value = in.nextLine();
                arguments.put("job", value);
        }

        records.put(citizenId,records.get(citizenId).Update(arguments));
    }

    public void UpdateSpouse(String firstId, String secondId)
    {
        if(!records.containsKey(firstId))
        {
            System.out.println("Citizen with Id Number " + firstId +  " does not exist.");
            return;
        }

        if(!records.containsKey(secondId))
        {
            System.out.println("Citizen with Id Number " + secondId +  " does not exist.");
            return;
        }

        Map<String,String> firstCitizen = records.get(firstId).Content();
        Map<String,String> secondCitizen = records.get(secondId).Content();

        if(!firstCitizen.get("CurrentPartnerId").equals("None"))
        {
            Map<String,String> change = new HashMap<String,String>();
            change.put("partnerId", "None");
            records.put(firstCitizen.get("CurrentPartnerId") ,records.get(firstCitizen.get("CurrentPartnerId")).Update(change));
        }

        if(!secondCitizen.get("CurrentPartnerId").equals("None"))
        {
            Map<String,String> change = new HashMap<String,String>();
            change.put("partnerId", "None");
            records.put(secondCitizen.get("CurrentPartnerId") ,records.get(secondCitizen.get("CurrentPartnerId")).Update(change));
        }

        Map<String,String> change = new HashMap<String,String>();
        change.put("partnerId", secondId);
        records.put(firstId,records.get(firstId).Update(change));

        change.put("partnerId", firstId);
        records.put(secondId,records.get(secondId).Update(change));
    }

    public void SpouseHistory(String citizenId)
    {
        if(!records.containsKey(citizenId))
        {
            System.out.println("Citizen with Id Number " + citizenId +  " does not exist.");
            return;
        }
        System.out.println("/////////////////////////////////////////////////////////////////////////");
        System.out.println("Spouse history for citizen " + citizenId + " from least recent change:");
        for (String element : records.get(citizenId).PartnerId())
            System.out.println(element);
        System.out.println("/////////////////////////////////////////////////////////////////////////");

    }

    public void Children(String citizenId)
    {
        if(!records.containsKey(citizenId))
        {
            System.out.println("Citizen with Id Number " + citizenId +  " does not exist.");
            return;
        }
        System.out.println("/////////////////////////////////////////////////////////////////////////");
        System.out.println("Children of citizen " + citizenId + " from least recently born:");
        for (String element : records.get(citizenId).ChildrenIds())
            System.out.println(element);
        System.out.println("/////////////////////////////////////////////////////////////////////////");

    }
}
