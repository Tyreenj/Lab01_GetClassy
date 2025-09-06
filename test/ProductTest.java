import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    Product p1;

    @BeforeEach
    void setUp() {
        p1 = new Product("Apple", "This is an apple", "000001", 1.5);
    }

    @Test
    void getName() {
        assertEquals("Apple", p1.getName());
    }

    @Test
    void setName() {
        p1.setName("Banana");
        assertEquals("Banana", p1.getName());
    }

    @Test
    void getDescription() {
        assertEquals("This is an apple", p1.getDescription());
    }

    @Test
    void setDescription() {
        p1.setDescription("This is a banana");
        assertEquals("This is a banana", p1.getDescription());
    }

    @Test
    void getProductID() {
        assertEquals("000001", p1.getProductID());
    }

    @Test
    void setProductID() {
        p1.setProductID("000002");
        assertEquals("000002", p1.getProductID());
    }

    @Test
    void getCost() {
        assertEquals(1.5, p1.getCost(), 0.001);
    }

    @Test
    void setCost() {
        p1.setCost(2.00);
        assertEquals(2.00, p1.getCost(), 0.001);
    }

    @Test
    void toCSV() {
        assertEquals("Apple,This is an apple,000001,1.5", p1.toCSV());
    }

    @Test
    void toJSON() {
        assertEquals("{\"name\":\"Apple\", \"description\":\"This is an apple\", \"productID\":\"000001\", \"cost\":\"1.5\"}", p1.toJSON());
    }

    @Test
    void testToXML() {
        assertEquals("<Product><name>Apple</name><description>This is an apple</description><productID>000001</productID><cost>1.5</cost></Product>", p1.toXML());
    }
}
