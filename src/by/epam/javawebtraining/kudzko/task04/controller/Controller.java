package by.epam.javawebtraining.kudzko.task04.controller;

import by.epam.javawebtraining.kudzko.task04.inputdatacontroller.TextReader;
import by.epam.javawebtraining.kudzko.task04.model.entity.Text;
import by.epam.javawebtraining.kudzko.task04.model.logic.ParagraphParser;
import by.epam.javawebtraining.kudzko.task04.model.logic.SentenceParser;
import by.epam.javawebtraining.kudzko.task04.model.logic.TextParser;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Controller {

    public static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    public static void main(String[] args) {

        Properties properties = new Properties();
        try {
            FileInputStream nameFileToParse = new FileInputStream("TextToParse.properties");
            properties.load(nameFileToParse);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String path = properties.getProperty("nameFileToParse");
        TextReader textReader = new TextReader();
        String text = textReader.readTxtFile(path);
        Text textInstance = new Text();

        SentenceParser sentenceParser = new SentenceParser();
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        TextParser textParser = new TextParser(paragraphParser);

        textParser.parse(text, textInstance);

        System.out.println(textInstance.toString());

    }
}
