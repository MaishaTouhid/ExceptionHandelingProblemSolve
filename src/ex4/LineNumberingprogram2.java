package ex4;



import java.io.*;
import java.util.Scanner;

public class LineNumberingprogram2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the input file name
        System.out.print("Enter the input file name: ");
        String inputFile = scanner.nextLine();

        // Prompt the user for the output file name
        System.out.print("Enter the output file name: ");
        String outputFile = scanner.nextLine();

        // Read the input file and write to the output file
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            int lineNumber = 1;

            // Read each line from the input file
            while ((line = reader.readLine()) != null) {
                // Write the line with line number to the output file
                writer.write("/* " + lineNumber + " */ " + line);
                writer.newLine(); // Add a new line
                lineNumber++;
            }

            System.out.println("Lines numbered and written to " + outputFile);

        } catch (FileNotFoundException e) {
            System.err.println("Input file not found: " + inputFile);
        } catch (IOException e) {
            System.err.println("An error occurred while reading or writing files.");
        }
    }
}

