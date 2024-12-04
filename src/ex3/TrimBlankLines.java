package ex3;

import java.io.*;
import java.util.ArrayList;

public class TrimBlankLines {
    public static void main(String[] args) {
        // Prompt the user for the file name
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the file name: ");

        try {
            String fileName = consoleReader.readLine();

            // Read the file and store non-blank lines in the middle, ignoring blanks at the start and end
            ArrayList<String> trimmedLines = new ArrayList<>();
            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
                String line;
                boolean contentStarted = false; // Track whether non-blank content has started

                // Read all lines into a list, trimming leading blanks
                while ((line = fileReader.readLine()) != null) {
                    if (!line.trim().isEmpty()) {
                        contentStarted = true;
                        trimmedLines.add(line);
                    } else if (contentStarted) {
                        // Add blank lines in the middle but ignore trailing blanks
                        trimmedLines.add(line);
                    }
                }

                // Remove trailing blank lines
                while (!trimmedLines.isEmpty() && trimmedLines.get(trimmedLines.size() - 1).trim().isEmpty()) {
                    trimmedLines.remove(trimmedLines.size() - 1);
                }
            }

            // Write the trimmed lines back to the file
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName))) {
                for (String trimmedLine : trimmedLines) {
                    fileWriter.write(trimmedLine);
                    fileWriter.newLine();
                }
            }

            System.out.println("Blank lines at the beginning and end removed successfully.");

        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}
