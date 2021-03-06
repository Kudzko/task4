package by.epam.javawebtraining.kudzko.task04.inputdata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextLineReader implements FileReadable {
    @Override
    public String readTxtFile(String path) {
        StringBuilder outputString = new StringBuilder();
       // BufferedReader bufferedReader = null;


        try (BufferedReader  bufferedReader = new BufferedReader(new FileReader
                (path))){

            String tempString;

            while ((tempString = bufferedReader.readLine()) != null) {
                outputString.append(tempString);
                outputString.append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputString.toString();
    }
}


