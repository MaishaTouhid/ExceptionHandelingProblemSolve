package ex9;

import java.io.*;

public class Find {
    public static void main(String[] args) {
        // Check if at least two arguments are provided
        if (args.length < 2) {
            System.out.println("Usage: java Find <word> <file1> <file2> ...");
            return;
        }

        String searchWord = args[0]; // The word to search for

        // Iterate through the file arguments
        for (int i = 1; i < args.length; i++) {
            String fileName = args[i];

            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
                String line;
                int lineNumber = 1;

                // Read each line and search for the word
                while ((line = fileReader.readLine()) != null) {
                    if (line.contains(searchWord)) {
                        System.out.printf("%s (line %d): %s%n", fileName, lineNumber, line);
                    }
                    lineNumber++;
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + fileName);
            } catch (IOException e) {
                System.err.println("Error reading file: " + fileName);
            }
        }
    }
}
