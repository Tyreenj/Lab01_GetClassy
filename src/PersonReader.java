import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import static java.lang.System.out;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import javax.swing.JFileChooser;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonReader {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        // set the chooser to the project src directory
        chooser.setCurrentDirectory(target.toFile());
        ArrayList<Person> people = new ArrayList<>();

        try  // Code that might trigger the exception goes here
        {

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                target = chooser.getSelectedFile().toPath();  // this is a File object not a String filename

                inFile = new Scanner(target);

                out.printf("%-10s %-15s %-15s %-10s %9s%n", "ID#", "Firstname", "Lastname", "Title", "YOB");
                out.println("====================================================================");

                while (inFile.hasNextLine()) {
                    line = inFile.nextLine();
                    String regex = ",|\\r?\\n";
                    String[] myArray = line.split(regex);
                    Person person = new Person(myArray[0], myArray[1], myArray[2], myArray[3], Integer.parseInt(myArray[4]));
                    people.add(person);
//"%-10s %-15s %-15s %-16s %s%n"

                }

                for (Person p : people) {
                    out.printf("%-10s %-15s %-15s %-16s %s%n", p.getIDnum(), p.getFirstName(), p.getLastName(), p.getTitle(), p.getYOB());

                }

                for (int j = 0; j < people.size()/5; j++) {
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
