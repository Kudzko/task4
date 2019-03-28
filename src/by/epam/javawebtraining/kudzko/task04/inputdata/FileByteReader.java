package by.epam.javawebtraining.kudzko.task04.inputdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileByteReader implements FileReadable {
    @Override
    public String readTxtFile(String path) {
        FileInputStream fileIN = null;
        StringBuilder stringOut = new StringBuilder();
        try {
            fileIN = new FileInputStream(path);
            int a;
            while ((a = fileIN.read()) != -1) {
                stringOut.append((char)a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileIN.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringOut.toString();
    }
}
