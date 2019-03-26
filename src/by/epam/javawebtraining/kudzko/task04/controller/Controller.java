package by.epam.javawebtraining.kudzko.task04.controller;

import by.epam.javawebtraining.kudzko.task04.inputdatacontroller.TextReader;
import by.epam.javawebtraining.kudzko.task04.model.entity.Text;
import by.epam.javawebtraining.kudzko.task04.model.logic.operation.AmountSentencesWithSameWords;
import by.epam.javawebtraining.kudzko.task04.model.logic.operation.ShowSentencesByLength;
import by.epam.javawebtraining.kudzko.task04.model.logic.parser.ParagraphParser;
import by.epam.javawebtraining.kudzko.task04.model.logic.parser.SentenceParser;
import by.epam.javawebtraining.kudzko.task04.model.logic.parser.TextParser;
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

        SentenceParser sentenceParser = SentenceParser.getSentenceParser();
        ParagraphParser paragraphParser = ParagraphParser.getParagraphParser(sentenceParser);
        TextParser textParser = TextParser.getTexParser(paragraphParser);

        textParser.parse(text, textInstance);

        System.out.println(textInstance.toString());

        System.out.println(ShowSentencesByLength.showSentencesIncreaseLength
                (textInstance));

        System.out.println(ShowSentencesByLength.showSentencesDecreaseLength
                (textInstance));

        System.out.println("AmountSentencesWithSameWords: " +
                AmountSentencesWithSameWords
                .countSentencesWithEqualsWords(textInstance));

        System.out.println("ShowSentencesByLength:\n" +
                ShowSentencesByLength
                .showSentencesIncreaseLength(textInstance));
    }
}
