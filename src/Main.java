import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<Person>();
        Person sally = new Person("Sally", "Williams", "Ms.", 2005);
        persons.add(sally);
        System.out.println(sally);

        sally.setLastName("Smith");

        System.out.println(sally);

        Person fred = new Person("Fred", "Williams", "Mr.", 2010);
        persons.add(fred);
        System.out.println(fred);

        Person homer = new Person("Homer", "Simpson", "Mr.", 1975);
        persons.add(homer);
        System.out.println(homer);

        for(Person p : persons) {
            System.out.println(p);
        }
    }
}