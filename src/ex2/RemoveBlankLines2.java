package ex2;

import java.io.*;
import java.util.ArrayList;

public class RemoveBlankLines2 {
    public static void main(String[] args) {
        // Specify the file path (change this to the path of your file)
        String filePath = "example.txt";

        // List to store non-blank lines
        ArrayList<String> nonBlankLines = new ArrayList<>();

        // Step 1: Read the file and store non-blank lines
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) { // Check if the line is not blank
                    nonBlankLines.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Step 2: Write the non-blank lines back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String nonBlankLine : nonBlankLines) {
                writer.write(nonBlankLine);
                writer.newLine(); // Write a new line after each non-blank line
            }
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }

        System.out.println("Blank lines removed successfully!");
    }
}
