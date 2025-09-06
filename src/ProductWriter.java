import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter {

    public static void main(String[] args) {

        /*
        000001, Pipeweed, Long Bottom Leaf, 600.0
        000002, Lembas, Elven Wayfare Bread, 200.0
        000003, Wine, Woodland Elf Wine, 400.0
        000004, Mushrooms, Farmer Took’s Finest, 125.0
        000005, Mithril, Enchanted Dwarven Armor, 3000.0

         */

        ArrayList<Product> products = new ArrayList<Product>();
        boolean done = false;
        Scanner in  = new Scanner(System.in);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.csv");

        /*
        a.	ID (a String as before in Person)
        b.	Name (a String)
        c.	Description (a String a short sentence)
        d.	Cost (This is currency so it will be a Java double)
        */

        String ID = "";
        String Name = "";
        String Description = "";
        Double Cost = 0.0;

        do {
            Name = SafeInput.getNonZeroLenString(in, "Enter your product Name. [6 Digits]");
            Description = SafeInput.getNonZeroLenString(in, "Enter your product description");
            ID = SafeInput.getNonZeroLenString(in, "Enter your product ID");
            Cost = SafeInput.getDouble(in, "Enter your Cost");

            Product newProduct = new Product(Name, Description, ID, Cost);
            products.add(newProduct);

            done = SafeInput.getYNConfirm(in, "Are you done?: ");

        } while (!done);

        for(Product p: products) {
            System.out.println(p);
        }

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(Product p : products)
            {
                writer.write(p.toCSV());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
