import pl.poznan.put.*;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        CitizensRegister mainRegister = new CitizensRegister();
        Scanner in = new Scanner(System.in);
        int choice;
        while (true)
        {
            System.out.println("/////////////////////////////////////////////////////////////////////////");
            System.out.println("Citizen register");
            System.out.println("1. Add citizen");
            System.out.println("2. Display information about specified citizen");
            System.out.println("3. Display spouse history of specified citizen");
            System.out.println("4. Asign specified citizens as spouses");
            System.out.println("5. Update information about specified citizen");
            System.out.println("6. Exit");
            choice = in.nextInt();
            in.nextLine();
            System.out.println("/////////////////////////////////////////////////////////////////////////");
            switch(choice)
            {
                case 1:
                    mainRegister.AddCitizen();
                    break;
                case 2:
                    System.out.println("Insert citizen's Id Number:");
                    mainRegister.PersonalInformation(in.nextLine());
                    break;
                case 3:
                    System.out.println("Insert citizen's Id Number:");
                    mainRegister.SpouseHistory(in.nextLine());
                    break;
                case 4:
                    System.out.println("Insert citizens' Id Numbers (in two separate lines):");
                    mainRegister.UpdateSpouse(in.nextLine(),in.nextLine());
                    break;
                case 5:
                    System.out.println("Insert citizen's Id Number:");
                    mainRegister.UpdateRecord(in.nextLine());
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Incorrect command");
            }
        }
    }
}