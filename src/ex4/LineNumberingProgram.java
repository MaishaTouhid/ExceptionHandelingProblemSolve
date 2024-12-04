package ex4;

import java.io.*;
import java.util.Scanner;

public class LineNumberingProgram {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        try {
            // Prompt user for input and output file names
            System.out.print("Enter the input file name: ");
            String inputFileName = console.nextLine();

            System.out.print("Enter the output file name: ");
            String outputFileName = console.nextLine();

            // Open the input file for reading
            try (BufferedReader fileReader = new BufferedReader(new FileReader(inputFileName));
                 BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputFileName))) {

                String line;
                int lineNumber = 1;

                // Read each line from the input file
                while ((line = fileReader.readLine()) != null) {
                    // Write the line to the output file with the line number prefix
                    fileWriter.write("/* " + lineNumber + " */ " + line);
                    fileWriter.newLine();
                    lineNumber++;
                }
            }

            System.out.println("File processed successfully. Line numbers added to " + outputFileName);

        } catch (FileNotFoundException e) {
            System.err.println("Input file not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        } finally {
            console.close();
        }
    }
}
