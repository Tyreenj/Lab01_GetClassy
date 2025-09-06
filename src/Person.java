import java.util.Calendar;
import java.util.Objects;

public class Person {

    private String IDnum;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;
    static private int IDseed = 1;


    /**
     * Returns the person's full name
     * @return the person's full name
     */
    public String fullName() {
        return firstName + " " + lastName;
    }

    /**
     * Returns the person's title and their full name
     * @return the person's title and their full name
     */
    public String formalName() {
        return title + " " + fullName();
    }

    /**
     * @param year the current year inputted to compute age
     * Returns the person's age year
     * @return the person's age given a year
     */
    public String getAge(int year) {
        int age = year - YOB;
        return Integer.toString(age);
    }

    /**
     * Returns the person's age according to current date
     * @return the person's age according to current date
     */
    public String getSpecifiedAge()
    {
        return Integer.toString(Calendar.getInstance().get(Calendar.YEAR) - YOB);
    }

    /**
     * Returns the person's data in CSV format
     * @return the person's data in CSV format
     */
    public String toCSV()
    {
        return IDnum + "," + firstName + "," + lastName + "," + title + "," + YOB;
    }

    /**
     * Returns the person's data in JSON format
     * @return the person's data in JSON format
     */
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

    /**
     * Returns the person's data in XML format
     * @return the person's data in XML format
     */
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YOB == person.YOB && Objects.equals(IDnum, person.IDnum) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(title, person.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IDnum, firstName, lastName, title, YOB);
    }
}
