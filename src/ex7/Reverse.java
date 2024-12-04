package ex7;

import java.io.*;
import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the file name
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        // Read the file and calculate averages
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int rowNumber = 1;

            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    // Handle blank rows
                    System.out.printf("Row %d: Average = 0.0%n", rowNumber);
                } else {
                    // Split the row into numbers
                    String[] numbers = line.trim().split("\\s+");
                    double sum = 0;

                    for (String num : numbers) {
                        sum += Double.parseDouble(num);
                    }

                    double average = sum / numbers.length;
                    System.out.printf("Row %d: Average = %.2f%n", rowNumber, average);
                }
                rowNumber++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file.");
        } catch (NumberFormatException e) {
            System.err.println("The file contains invalid numbers.");
        }
    }
}
