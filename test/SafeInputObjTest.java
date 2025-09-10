import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SafeInputObjTest {

    SafeInputObj input = new SafeInputObj();

    @BeforeEach
    void setUp() {
        String simulatedInput = "Hello\n1\nY\nABC123\n4\n";
        Scanner scanner = new Scanner(simulatedInput);
        input = new SafeInputObj(scanner);
    }

    @Test
    void getNonZeroLenString() {

        String result = input.getNonZeroLenString("Enter your string");
        assertEquals("Hello",  result);
        System.out.println(result);
    }

    @Test
    void getInt() {
        int result = input.getInt("Enter any int");
        assertEquals(1, result);
        System.out.println(result);
    }

    @Test
    void getRangedInt() {
        int result = input.getRangedInt("Enter ranged int", 1, 20);
        assertEquals(1, result);
        System.out.println(result);
    }

    @Test
    void getDouble() {
        double result = input.getDouble("Enter any double");
        assertEquals(1, result, 0.001);
        System.out.println(result);
    }

    @Test
    void getYNConfirm() {
        boolean result = input.getYNConfirm("Are you sure?");
        assertTrue(result);
        System.out.println(result);
    }

    @Test
    void getRegExString() {
        Scanner scanner = new Scanner("ABC123\n");
        input = new SafeInputObj(scanner);
        String result = input.getRegExString("Enter code", "[A-Z]{3}\\d{3}");
        assertEquals("ABC123", result);
        System.out.println(result);
    }

    @Test
    void getRangedDouble() {
        Scanner scanner = new Scanner("1.5\n");
        input = new SafeInputObj(scanner);
        double result = input.getRangedDouble("Enter ranged double", 1, 6);
        assertEquals(1.5, result, 0.001);
        System.out.println(result);
    }
}