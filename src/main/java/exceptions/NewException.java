package exceptions;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewException {

    public static void main(String[] args) throws SQLException, IOException {
        try (
                @SuppressWarnings("unchecked") 
                BufferedReader fr = Files.newBufferedReader(Paths.get("in.txt"));
                PrintWriter fw = new PrintWriter(new FileWriter("out.txt"));) {
            String line;
            while ((line = fr.readLine()) != null) {
                fw.println(line);
            }
            if (Math.random() > 0.99) {
                throw new SQLException("Broken table!");
            }
        // catch (Exception ioe) // catches both IOException and Array....
        
        } catch (IOException | ArrayIndexOutOfBoundsException ioe) {
            System.out.println("Something broke " + ioe.getMessage());
            throw ioe;
        }
    }
}
