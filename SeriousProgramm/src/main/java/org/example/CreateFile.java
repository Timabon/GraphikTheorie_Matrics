package org.example;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import static org.example.Matrix.matrix;

public class CreateFile {
    public static void main() throws IOException {
        createFile();
        writeToFile();
        openFile();

    }
    public static void createFile(){
        try {
            File myObj = new File("C:\\Users\\timab\\Desktop\\Output\\file2.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                System.out.println("Absolute path: " + myObj.getAbsolutePath());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void writeToFile(){
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\timab\\Desktop\\Output\\file2.txt");
            myWriter.write(Arrays.deepToString(matrix));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void openFile() throws IOException {
       File file = new File("C:\\Users\\timab\\Desktop\\Output\\file2.txt");
       Desktop desktop = Desktop.getDesktop();
       desktop.open(file);
    }
}
