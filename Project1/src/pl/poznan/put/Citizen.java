package pl.poznan.put;

import java.time.Instant;

public class Citizen
{
    final private Instant dateOfBirth;
    final private String names;
    final private String surname;
    final private String idNumber;
    final private String[] parentsIdNumbers = new String[2];
    final private String sex;

    public Citizen(int dayOfBirth, int monthOfBirth, int yearOfBirth, String names, String surname, String idNumber, String sex , String motherId, String fatherId)
    {
        String month = Integer.toString(monthOfBirth);
        if(month.length() == 1)
            month = "0" + month;

        String day = Integer.toString(dayOfBirth);
        if(day.length() == 1)
            day = "0" + day;

        this.dateOfBirth = Instant.parse(yearOfBirth + "-" + month + "-" + day + "T00:00:00.01Z");
        this.names = names;
        this.surname = surname;
        this.idNumber = idNumber;
        this.parentsIdNumbers[0] = motherId;
        this.parentsIdNumbers[1] = fatherId;
        this.sex = sex;
    }

    public Citizen(int dayOfBirth, int monthOfBirth, int yearOfBirth, String names, String surname, int idNumber, String sex , String motherId, String fatherId)
    {
        this(dayOfBirth, monthOfBirth, yearOfBirth, names, surname, Integer.toString(idNumber), sex , motherId, fatherId);
    }

    public Citizen(int dayOfBirth, int monthOfBirth, int yearOfBirth, String names, String surname, String idNumber, String sex , int motherId, String fatherId)
    {
        this(dayOfBirth, monthOfBirth, yearOfBirth, names, surname, idNumber, sex , Integer.toString(motherId), fatherId);
    }

    public Citizen(int dayOfBirth, int monthOfBirth, int yearOfBirth, String names, String surname, int idNumber, String sex , int motherId, String fatherId)
    {
        this(dayOfBirth, monthOfBirth, yearOfBirth, names, surname, Integer.toString(idNumber), sex , Integer.toString(motherId), fatherId);
    }

    public Citizen(int dayOfBirth, int monthOfBirth, int yearOfBirth, String names, String surname, String idNumber, String sex , String motherId, int fatherId)
    {
        this(dayOfBirth, monthOfBirth, yearOfBirth, names, surname, idNumber, sex , motherId, Integer.toString(fatherId));
    }

    public Citizen(int dayOfBirth, int monthOfBirth, int yearOfBirth, String names, String surname, int idNumber, String sex , String motherId, int fatherId)
    {
        this(dayOfBirth, monthOfBirth, yearOfBirth, names, surname, Integer.toString(idNumber), sex , motherId, Integer.toString(fatherId));
    }

    public Citizen(int dayOfBirth, int monthOfBirth, int yearOfBirth, String names, String surname, String idNumber, String sex , int motherId, int fatherId)
    {
        this(dayOfBirth, monthOfBirth, yearOfBirth, names, surname, idNumber, sex , Integer.toString(motherId), Integer.toString(fatherId));
    }

    public Citizen(int dayOfBirth, int monthOfBirth, int yearOfBirth, String names, String surname, int idNumber, String sex , int motherId, int fatherId)
    {
        this(dayOfBirth, monthOfBirth, yearOfBirth, names, surname, Integer.toString(idNumber), sex , Integer.toString(motherId), Integer.toString(fatherId));
    }

    public Citizen(Instant dateOfBirth, String names, String surname, String idNumber, String sex , String motherId, String fatherId)
    {
        this.dateOfBirth = dateOfBirth;
        this.names = names;
        this.surname = surname;
        this.idNumber = idNumber;
        this.parentsIdNumbers[0] = motherId;
        this.parentsIdNumbers[1] = fatherId;
        this.sex = sex;
    }

    public Citizen(Instant dateOfBirth, String names, String surname, int idNumber, String sex , String motherId, String fatherId)
    {
        this(dateOfBirth, names, surname, Integer.toString(idNumber), sex , motherId, fatherId);
    }

    public Citizen(Instant dateOfBirth, String names, String surname, String idNumber, String sex , int motherId, String fatherId)
    {
        this(dateOfBirth, names, surname, idNumber, sex , Integer.toString(motherId), fatherId);
    }

    public Citizen(Instant dateOfBirth, String names, String surname, int idNumber, String sex , int motherId, String fatherId)
    {
        this(dateOfBirth, names, surname, Integer.toString(idNumber), sex , Integer.toString(motherId), fatherId);
    }

    public Citizen(Instant dateOfBirth, String names, String surname, String idNumber, String sex , String motherId, int fatherId)
    {
        this(dateOfBirth, names, surname, idNumber, sex , motherId, Integer.toString(fatherId));
    }

    public Citizen(Instant dateOfBirth, String names, String surname, int idNumber, String sex , String motherId, int fatherId)
    {
        this(dateOfBirth, names, surname, Integer.toString(idNumber), sex , motherId, Integer.toString(fatherId));
    }

    public Citizen(Instant dateOfBirth, String names, String surname, String idNumber, String sex , int motherId, int fatherId)
    {
        this(dateOfBirth, names, surname, idNumber, sex , Integer.toString(motherId), Integer.toString(fatherId));
    }

    public Citizen(Instant dateOfBirth, String names, String surname, int idNumber, String sex , int motherId, int fatherId)
    {
        this(dateOfBirth, names, surname, Integer.toString(idNumber), sex , Integer.toString(motherId), Integer.toString(fatherId));
    }

    public Instant DateOfBirth()
    {
        return dateOfBirth;
    }

    public String Name()
    {
        return names + " " + surname;
    }

    public String Names()
    {
        return names;
    }

    public String Surname()
    {
        return surname;
    }

    public String IdNumber()
    {
        return idNumber;
    }

    public String MotherIdNumber()
    {
        return parentsIdNumbers[0];
    }

    public String FatherIdNumber()
    {
        return parentsIdNumbers[1];
    }

    public String Sex()
    {
        return sex;
    }

    public Citizen ChangeNames(String names)
    {
        return new Citizen(this.dateOfBirth, names, this.surname, this.idNumber, this.sex, this.parentsIdNumbers[0], this.parentsIdNumbers[1]);
    }

    public Citizen ChangeSurname(String surname)
    {
        return new Citizen(this.dateOfBirth, this.names, surname, this.idNumber, this.sex, this.parentsIdNumbers[0], this.parentsIdNumbers[1]);
    }

    public Citizen ChangeNamesAndSurname(String names, String surname)
    {
        return new Citizen(this.dateOfBirth, names, surname, this.idNumber, this.sex, this.parentsIdNumbers[0], this.parentsIdNumbers[1]);
    }
}
