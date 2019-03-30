package by.epam.javawebtraining.kudzko.task04.model.logic.parser;

import by.epam.javawebtraining.kudzko.task04.model.entity.*;
import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements ParseAble {

    private static ParagraphParser paragraphParser;

    public static final String SENTENCE_TAG =  RegexConst.SENTENCE_TAG;

    private ParseAble toParser;

    private ParagraphParser(ParseAble toParser) {
        this.toParser = toParser;
    }

    public static ParagraphParser getParagraphParser(ParseAble toParser){
        if (paragraphParser == null) {
            paragraphParser = new ParagraphParser(toParser);
        }
        return paragraphParser;
    }

    @Override
    public void parse(String data, TextElement paragraph) {

        Pattern pattern = Pattern.compile(SENTENCE_TAG);
        Matcher matcher = pattern.matcher(data);
        String[] sentences = pattern.split(data);

        int i = 0;
        while (i < sentences.length) {
            //Create instance of sentence
            Sentence sentence = new Sentence();
            if (matcher.find()){
                ((Paragraph)paragraph).addPunctuatoinElement(matcher.group());
            }
            //punctuation is saved
            try {
                paragraph.addElement(sentence);
            } catch (MismatchTypesException e) {
                e.printStackTrace();
            }
            // SentencesParser is called
            if (toParser != null) {
                toParser.parse(sentences[i], sentence);
            }

            i++;
        }
    }
}
