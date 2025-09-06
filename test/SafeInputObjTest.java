import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SafeInputObjTest {

    SafeInputObj input = new SafeInputObj();

    @BeforeEach
    void setUp() {
        String simulatedInput = "Hello\n5\nY\nABC123\n";
        Scanner scanner = new Scanner(simulatedInput);
        input = new SafeInputObj(scanner);
    }

    @Test
    void getNonZeroLenString() {

        String result = input.getNonZeroLenString("Enter your string");
        assertEquals("Hello",  result);
    }

    @Test
    void getRangedInt() {
        int result = input.getInt("Enter any int");
        assertEquals(5, result);
    }

    @Test
    void getInt() {
        int result = input.getRangedInt("Enter ranged int", 1, 20);
        assertEquals(5, result);
    }

    @Test
    void getRangedDouble() {
        double result = input.getDouble("Enter any double");
        assertEquals(5, result, 0.001);
    }

    @Test
    void getDouble() {
        boolean result = input.getYNConfirm("Are you sure?");
        assertTrue(result);
    }

    @Test
    void getYNConfirm() {
        String result = input.getRegExString("Enter code", "[A-Z]{3}\\d{3}");
        assertEquals("ABC123", result);
    }

    @Test
    void getRegExString() {
        Scanner scanner = new Scanner("1.5\n");
        input = new SafeInputObj(scanner);
        double result = input.getRangedDouble("Enter ranged double", 1, 2);
        assertEquals(1.5, result, 0.001);
    }
}