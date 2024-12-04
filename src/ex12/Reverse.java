package ex12;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Reverse {
    public static void main(String[] args) {
        // Check if the user provided the correct number of arguments
        if (args.length != 2) {
            System.out.println("Usage: java ReverseFileLines <inputFile> <outputFile>");
            return;
        }

        String inputFile = args[0];  // Input file name
        String outputFile = args[1]; // Output file name

        // List to store the lines from the file
        ArrayList<String> lines = new ArrayList<>();

        // Step 1: Read lines from the input file
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found: " + inputFile);
            return;
        } catch (IOException e) {
            System.err.println("An error occurred while reading the input file.");
            return;
        }

        // Step 2: Reverse the lines
        Collections.reverse(lines);

        // Step 3: Write the reversed lines to the output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine(); // Add a new line after each line
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the output file.");
        }

        System.out.println("Lines reversed and written to " + outputFile);
    }
}
