import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        // set the chooser to the project src directory
        chooser.setCurrentDirectory(target.toFile());
        ArrayList<Product> products = new ArrayList<Product>();


        try  // Code that might trigger the exception goes here
        {

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                target = chooser.getSelectedFile().toPath();  // this is a File object not a String filename

                inFile = new Scanner(target);

                out.printf("%-10s %-20s %-10s %s%n", "Name", "Description", "ID", "Cost");
                out.println("====================================================================");

                while (inFile.hasNextLine()) {
                    line = inFile.nextLine();
                    //out.printf(line);
                    String regex = ",|\\r?\\n";
                    String[] myArray = line.split(regex);
                    Product product = new Product(myArray[0], myArray[1], myArray[2], Double.parseDouble(myArray[3]));
                    products.add(product);
                    //out.println(myArray[0] + myArray[1] + myArray[2] + myArray[3]);

                }

                for (Product p : products) {
                    out.printf("%-10s %-20s %-10s %s%n", p.getName(), p.getDescription(), p.getProductID(), p.getCost());

                }

                for (int j = 0; j < products.size()/4; j++) {
                    out.println();
                }

                inFile.close();
            } else   // User did not pick a file, closed the chooser
            {
                System.out.println("Sorry, you must select a file! Termininating!");
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Error");
            e.printStackTrace();
        } catch (IOException e) // code to handle this exception
        {
            System.out.println("IOException Error");
            e.printStackTrace();
        }
    }

}
