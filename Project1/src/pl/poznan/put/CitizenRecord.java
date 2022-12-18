package pl.poznan.put;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CitizenRecord  implements Record
{
    private ArrayList<Citizen> personalInformation = new ArrayList<Citizen>();
    private ArrayList<String> partnerId = new ArrayList<String>();
    private ArrayList<String> childrenIds = new ArrayList<String>();
    private String job;

    public CitizenRecord(Citizen personalInformation, String[] childrenIds , String job, String partnerId)
    {
        this.personalInformation.add(personalInformation);
        this.job = job;
        this.partnerId.add(partnerId);
        for(String element : childrenIds)
            this.childrenIds.add(element);
    }

    public CitizenRecord(Citizen personalInformation, String[] childrenIds , String job)
    {
        this(personalInformation, childrenIds, job, "None");
    }

    public CitizenRecord(Citizen personalInformation, String[] childrenIds)
    {
        this(personalInformation, childrenIds, "Unemployed", "None");
    }

    public CitizenRecord(Citizen personalInformation, ArrayList <String> childrenIds , String job, String partnerId)
    {
        this.personalInformation.add(personalInformation);
        this.job = job;
        this.partnerId.add(partnerId);
        this.childrenIds = childrenIds;
    }

    public CitizenRecord(Citizen personalInformation, ArrayList <String> childrenIds , String job)
    {
        this(personalInformation, childrenIds, job, "None");
    }

    public CitizenRecord(Citizen personalInformation, ArrayList <String> childrenIds)
    {
        this(personalInformation, childrenIds, "Unemployed", "None");
    }

    public CitizenRecord(Citizen personalInformation, ArrayList <String> childrenIds , String job, ArrayList <String> partnerId)
    {
        this.personalInformation.add(personalInformation);
        this.job = job;
        this.partnerId = partnerId;
        this.childrenIds = childrenIds;
    }

    public CitizenRecord(ArrayList<Citizen> personalInformation, ArrayList <String> childrenIds , String job, ArrayList <String> partnerId)
    {

        this.personalInformation = personalInformation;
        this.job = job;
        this.partnerId = partnerId;
        this.childrenIds = childrenIds;
    }

    public CitizenRecord Update(Map <String,String> changes)
    {
        String names, surname, job;
        ArrayList<String> updatedPartners = partnerId;
        ArrayList<Citizen> updatedInformation = personalInformation;

        if(changes.containsKey("names"))
            names = changes.get("names");
        else
            names = personalInformation.get(personalInformation.size() - 1).Name();

        if(changes.containsKey("surname"))
            surname = changes.get("surname");
        else
            surname = personalInformation.get(personalInformation.size() - 1).Surname();

        if(!(changes.containsKey("names") && changes.containsKey("surname")))
            updatedInformation.add(updatedInformation.get(updatedInformation.size() - 1).ChangeNamesAndSurname(names, surname));

        if(changes.containsKey("job"))
            job = changes.get("job");
        else
            job = this.job;

        if(changes.containsKey("partnerId"))
            updatedPartners.add(changes.get("partnerId"));

        return new CitizenRecord(updatedInformation, childrenIds, job, partnerId);
    }

    public CitizenRecord AssignChild(String childId)
    {
        ArrayList<String> updatedChildren = childrenIds;
        updatedChildren.add(childId);
        return new CitizenRecord(personalInformation, updatedChildren, job, partnerId);
    }

    public ArrayList<String> PartnerId()
    {
        return partnerId;
    }

    public ArrayList<String> ChildrenIds()
    {
        return childrenIds;
    }

    @Override
    public Map<String,String> Content()
    {
        Map<String,String> result = new HashMap<>();
        result.put("Name", personalInformation.get(personalInformation.size() - 1).Name());
        result.put("IdNumber", personalInformation.get(personalInformation.size() - 1).IdNumber());
        result.put("Sex", personalInformation.get(personalInformation.size() - 1).Sex());
        result.put("DateOfBirth", personalInformation.get(personalInformation.size() - 1).DateOfBirth().toString());
        result.put("FatherId", personalInformation.get(personalInformation.size() - 1).FatherIdNumber());
        result.put("MotherId", personalInformation.get(personalInformation.size() - 1).MotherIdNumber());
        if(partnerId.size() != 0)
            result.put("CurrentPartnerId", partnerId.get(partnerId.size() - 1));
        else
            result.put("CurrentPartnerId", "None");
        result.put("Job",job);
        int i = 0;
        for (String element : childrenIds)
        {
            result.put("child" + i, element);
            i++;
        }
        return result;
    }
}
