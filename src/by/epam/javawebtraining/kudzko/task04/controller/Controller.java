package by.epam.javawebtraining.kudzko.task04.controller;

import by.epam.javawebtraining.kudzko.task04.inputdatacontroller.TextReader;
import by.epam.javawebtraining.kudzko.task04.model.entity.Text;
import by.epam.javawebtraining.kudzko.task04.model.logic.ParagraphParser;
import by.epam.javawebtraining.kudzko.task04.model.logic.SentenceParser;
import by.epam.javawebtraining.kudzko.task04.model.logic.TextParser;
import org.apache.log4j.Logger;

public class Controller {

    public static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    public static void main(String[] args) {

        String path = "F:\\git_rep\\task4\\src\\by\\epam\\javawebtraining" +
                "\\kudzko" +
                "\\task04\\inputdatacontroller\\testText.txt";

        TextReader textReader = new TextReader();
        String text = textReader.readTxtFile(path);
        Text textInstance = new Text();

        SentenceParser sentenceParser = new SentenceParser();
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        TextParser textParser = new TextParser(paragraphParser);

        textParser.parse(text, textInstance);


    }
}
