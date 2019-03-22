package by.epam.javawebtraining.kudzko.task04.inputdatacontroller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextReader implements FileReadable {
    @Override
    public String readTxtFile(String path) {
        StringBuilder outputString = new StringBuilder();
        BufferedReader bufferedReader = null;


        try {
            bufferedReader = new BufferedReader(new FileReader
                    (path));
            int tempString;

            while ((tempString = bufferedReader.read()) != -1){
                outputString.append((char) tempString);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return outputString.toString();
    }
}
