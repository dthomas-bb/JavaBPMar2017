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

public class ExceptionStuff {

    public static void main(String[] args) throws SQLException {
        BufferedReader fr = null;
        PrintWriter fw = null;
        try {
            fr = Files.newBufferedReader(Paths.get("in.txt"));
            fw = new PrintWriter(new FileWriter("out.txt"));
            String line;
            while ((line = fr.readLine()) != null) {
                fw.println(line);
            }
            if (Math.random() > 0.99) {
                throw new SQLException("Broken table!");
            }
        } catch (IOException ioe) {
            System.out.println("Something broke " + ioe.getMessage());
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ex) {
                    // This exceptino can "kill" the real one (SQLException)
                    Logger.getLogger(ExceptionStuff.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (fw != null) {
                fw.close();
            }
        }
    }
}
