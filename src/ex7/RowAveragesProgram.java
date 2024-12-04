package ex7;

import java.io.*;
import java.util.Scanner;

public class RowAveragesProgram {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        try {
            // Prompt the user for the file name
            System.out.print("Enter the file name: ");
            String fileName = console.nextLine();

            // Open the file for reading
            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
                String line;
                int rowNumber = 1;

                // Read each row from the file
                while ((line = fileReader.readLine()) != null) {
                    // Calculate the average for the row
                    double average = calculateRowAverage(line);
                    System.out.printf("Row %d average: %.2f%n", rowNumber, average);
                    rowNumber++;
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } finally {
            console.close();
        }
    }

    // Method to calculate the average of numbers in a row
    private static double calculateRowAverage(String row) {
        if (row.trim().isEmpty()) {
            return 0.0; // Return 0 for blank rows
        }

        String[] numbers = row.trim().split("\\s+"); // Split by whitespace
        double sum = 0.0;

        for (String number : numbers) {
            try {
                sum += Double.parseDouble(number);
            } catch (NumberFormatException e) {
                System.err.println("Skipping invalid number: " + number);
            }
        }

        return sum / numbers.length; // Calculate average
    }
}
