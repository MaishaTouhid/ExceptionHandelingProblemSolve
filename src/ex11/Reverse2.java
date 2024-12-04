package ex11;

import java.io.*;
import java.util.ArrayList;

public class Reverse2 {
    public static void main(String[] args) {
        // Check if the filename is provided as an argument
        if (args.length != 1) {
            System.out.println("Usage: java Reverse <filename>");
            return;
        }

        String fileName = args[0];

        // List to store reversed lines
        ArrayList<String> reversedLines = new ArrayList<>();

        // Step 1: Read the file and reverse each line
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                reversedLines.add(new StringBuilder(line).reverse().toString());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Step 2: Write the reversed lines back to the same file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String reversedLine : reversedLines) {
                writer.write(reversedLine);
                writer.newLine(); // Write a newline after each line
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file.");
        }

        System.out.println("Lines reversed successfully in " + fileName);
    }
}
