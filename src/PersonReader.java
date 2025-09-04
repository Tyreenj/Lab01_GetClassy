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

        try  // Code that might trigger the exception goes here
        {

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                target = chooser.getSelectedFile().toPath();  // this is a File object not a String filename

                inFile = new Scanner(target);

                out.printf("%-10s %-15s %-15s %-10s %13s%n", "ID#", "Firstname", "Lastname", "Title", "YOB");
                out.println("====================================================================");

                while (inFile.hasNextLine()) {
                    line = inFile.nextLine();
                    String regex = "[,\\.\\s]";
                    String[] myArray = line.split(regex);
                    for (int j = 0; j < myArray.length/10; j++) {
                        for (int i = 0; i < myArray.length;) {
                            out.printf("%-6s", myArray[i]);
                            out.printf("%-5s", myArray[i + 1]);
                            out.printf("%-11s", myArray[i + 2]);
                            out.printf("%-5s", myArray[i + 3]);
                            out.printf("%-10s", myArray[i + 4]);

                            i = i + 5;
                        }
                        out.println();
                    }

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
