import java.util.Calendar;

public class Person {

    private String IDnum;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;
    static private int IDseed = 1;


    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + lastName;
    }

    public String getAge() {
        int age = 2025 - YOB;
        return Integer.toString(age);
    }

    public String getAge(int year)
    {
        Calendar calendar = Calendar.getInstance();
        year =  calendar.get(Calendar.YEAR);
        int age = year - YOB;
        return Integer.toString(age);
    }

    public String toCSV()
    {
        return IDnum + "," + firstName + "," + lastName + "," + title + "," + YOB;
    }

    public String toJSON()
    {
        String retString = "";
        final char DQ = '\u0022';
        retString = "{" + DQ + "IDNum" + DQ + ":" + DQ + this.IDnum + DQ + ",";
        retString += " " + DQ + "firstName" + DQ + ":" + DQ + this.firstName + DQ + ",";
        retString += " " + DQ + "lastName" + DQ + ":" + DQ + this.lastName + DQ + ",";
        retString += " " + DQ + "title" + DQ + ":" + DQ + this.title + DQ + ",";
        retString += " " + DQ + "YOB" + DQ + ":" + DQ + this.YOB + DQ + "}";
        return retString;
    }

    public String toXML()
    {
        String retString = "";
        retString = "<Person>";
        retString += "<IDNum>" + IDnum + "</IDNum>";
        retString += "<firstName>" + firstName + "</firstName>";
        retString += "<lastName>" + lastName + "</lastName>";
        retString += "<title>" + title + "</title>";
        retString += "<YOB>" + YOB + "</YOB>";
        retString += "</Person>";
        return retString;
    }

    public static int getIDseed() {
        return IDseed;
    }

    public static void setIDseed(int IDseed) {
        Person.IDseed = IDseed;
    }

    public Person(String IDnum, String firstName, String lastName, String title, int YOB) {
        this.IDnum = IDnum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public Person(String firstName, String lastName, String title, int YOB) {
        this.IDnum = this.genIDNum();
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public String getIDnum() {
        return IDnum;
    }

    private String genIDNum() {
        String newID = "" + IDseed;
        while(newID.length() < 8) {
            newID = "0" + newID;
        }

        IDseed++;

        return newID;
    }

    public void setIDnum(String IDnum) {
        this.IDnum = IDnum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    @Override
    public String toString() {
        return "Person{" +
                "IDnum='" + IDnum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }
}
