package ex2;

import java.io.*;
import java.util.ArrayList;

public class RemoveBlankLines {
    public static void main(String[] args) {
        // Prompt the user for the file name
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the file name: ");

        try {
            String fileName = consoleReader.readLine();

            // Read the file and remove blank lines
            ArrayList<String> nonBlankLines = new ArrayList<>();
            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = fileReader.readLine()) != null) {
                    if (!line.trim().isEmpty()) { // Check if the line is non-blank
                        nonBlankLines.add(line);
                    }
                }
            }

            // Write the non-blank lines back to the same file
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName))) {
                for (String nonBlankLine : nonBlankLines) {
                    fileWriter.write(nonBlankLine);
                    fileWriter.newLine();
                }
            }

            System.out.println("Blank lines removed successfully.");

        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}

