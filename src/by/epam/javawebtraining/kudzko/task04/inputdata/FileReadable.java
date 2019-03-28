package by.epam.javawebtraining.kudzko.task04.inputdata;

import java.io.IOException;

public interface FileReadable {
    public  String readTxtFile(String path) throws IOException;
}
