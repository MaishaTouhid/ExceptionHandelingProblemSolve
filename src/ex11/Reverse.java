package ex11;

import java.io.*;
import java.util.ArrayList;

public class Reverse {
    public static void main(String[] args) {
        // Check if a file name is provided
        if (args.length < 1) {
            System.out.println("Usage: java Reverse <filename>");
            return;
        }

        String fileName = args[0];

        try {
            // Read the file and reverse each line
            ArrayList<String> reversedLines = new ArrayList<>();
            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = fileReader.readLine()) != null) {
                    reversedLines.add(new StringBuilder(line).reverse().toString());
                }
            }

            // Write the reversed lines back to the same file
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName))) {
                for (String reversedLine : reversedLines) {
                    fileWriter.write(reversedLine);
                    fileWriter.newLine();
                }
            }

            System.out.println("File content reversed successfully.");

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}
