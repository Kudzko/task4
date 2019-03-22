package by.epam.javawebtraining.kudzko.task04.inputdatacontroller;

import java.io.IOException;

public interface FileReadable {
    public  String readTxtFile(String path) throws IOException;
}
