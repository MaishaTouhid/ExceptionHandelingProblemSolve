import java.io.*;

public class FileReadWriter {
    public static void main(String[] args) {

        String fileName = "hello.txt";
        String message = "Hello,World";

        // Write the message to the file
        try(FileWriter Writer  = new FileWriter (fileName)){
            Writer.write(message);
            System.out.println("Message Written to the file successfully");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Read the message from the file

            try(BufferedReader reader = new BufferedReader( new FileReader(fileName))){
                String readMessage = reader.readLine();
                System.out.println("Message read from the file :" + readMessage);

            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
}
