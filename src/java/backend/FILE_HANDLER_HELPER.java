/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author preet
 */
public class FILE_HANDLER_HELPER {

    private static void checkFileExists(String folder) {
        Path path = Paths.get(folder);
        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException ex) {

            }
        }
    }

    public static int readBinaryFile(String folder, String filename) {
        FileInputStream input = null;
        try {
            checkFileExists(folder);
            input = new FileInputStream(filename);
            try {
                int res = input.read();

                input.close();

                return res;

            } catch (IOException ex) {
                Logger.getLogger(FILE_HANDLER_HELPER.class.getName()).log(Level.SEVERE, null, ex);
            }

            return 100;

        } catch (FileNotFoundException ex) {
            return 100;
        }
    }

    public static boolean writeBinaryFile(String folder, String filename, int value) throws FileNotFoundException {
        checkFileExists(folder);
        FileOutputStream output = new FileOutputStream(filename);

        try {
            output.write(value);
            output.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(FILE_HANDLER_HELPER.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
