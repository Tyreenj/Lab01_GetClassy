import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person p1, p2, p3, p4, p5, p6;

    @BeforeEach
    void setUp() {
        p1 = new Person("00000A", "Bob", "Tester1","Mr.", 1955);
        p2 = new Person("00000B", "Sally", "Tester2","Mrs.", 1975);
        Person.setIDseed(0);
        p3 = new Person("Bob", "Tester3", "Mr.", 1960);
        p4 = new Person("Sally", "Tester4", "Mrs.", 1965);
        p5 = new Person("Fred", "Tester5", "Mr..", 1970);
        p6 = new Person("Cindy", "Tester6", "Mrs.", 1975);
    }

    @Test
    void getIDseed() {
        assertEquals(4, Person.getIDseed());
    }

    @Test
    void setIDseed() {
        p1.setIDseed(5);
        assertEquals(5, p1.getIDseed());
    }

    @Test
    void getIDnum() {
        assertEquals("00000A", p1.getIDseed());
    }

    @Test
    void setIDnum() {
        p1.setIDnum("00000B");
        assertEquals("00000B", p1.getIDseed());
    }

    @Test
    void getFirstName() {
        assertEquals("Bob", p1.getFirstName());
    }

    @Test
    void setFirstName() {
        p1.setFirstName("Noah");
        assertEquals("Noah", p1.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Tester1", p1.getLastName());
    }

    @Test
    void setLastName() {
        p1.setLastName("Tyree");
        assertEquals("Tyree", p1.getLastName());
    }

    @Test
    void getTitle() {
        assertEquals("Mr.", p1.getTitle());
    }

    @Test
    void setTitle() {
        p1.setTitle("Prof.");
        assertEquals("Prof.", p1.getTitle());
    }

    @Test
    void getYOB() {
        assertEquals(1955, p1.getYOB());
    }

    @Test
    void setYOB() {
        p1.setYOB(1899);
        assertEquals(1899, p1.getYOB());
    }

    @Test
    void testToString() {
    }
}