//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Person sally = new Person("00000001", "Sally", "Williams", "Ms.", 2005);
        System.out.println(sally);

        sally.setLastName("Smith");

        System.out.println(sally);
    }
}