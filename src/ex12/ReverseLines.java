package ex12;

import java.io.*;
import java.util.ArrayList;

public class ReverseLines {
    public static void main(String[] args) {
        // Check if the correct number of arguments is provided
        if (args.length != 2) {
            System.out.println("Usage: java ReverseLines <input file> <output file>");
            return;
        }

        String inputFileName = args[0];
        String outputFileName = args[1];

        try {
            // Read all lines from the input file
            ArrayList<String> lines = new ArrayList<>();
            try (BufferedReader fileReader = new BufferedReader(new FileReader(inputFileName))) {
                String line;
                while ((line = fileReader.readLine()) != null) {
                    lines.add(line);
                }
            }

            // Write the lines in reverse order to the output file
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputFileName))) {
                for (int i = lines.size() - 1; i >= 0; i--) {
                    fileWriter.write(lines.get(i));
                    fileWriter.newLine();
                }
            }

            System.out.println("File lines reversed successfully. Output written to " + outputFileName);

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + inputFileName);
        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}
