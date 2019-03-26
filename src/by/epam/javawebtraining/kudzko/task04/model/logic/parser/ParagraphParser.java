package by.epam.javawebtraining.kudzko.task04.model.logic.parser;

import by.epam.javawebtraining.kudzko.task04.model.entity.*;
import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements ParseAble {

    private static ParagraphParser paragraphParser;

    public static final String SENTENCE_TAG = "[.!?] ";

    private SentenceParser root;

    private ParagraphParser(SentenceParser root) {
        this.root = root;
    }

    public static ParagraphParser getParagraphParser(SentenceParser root){
        if (paragraphParser == null) {
            paragraphParser = new ParagraphParser(root);
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

            Sentence sentence = new Sentence();
            if (matcher.find()){
                ((Paragraph)paragraph).addPunctuatoinElement(matcher.group());
            }

            try {
                paragraph.addElement(sentence);
            } catch (MismatchTypesException e) {
                e.printStackTrace();
            }

            if (root != null) {
                root.parse(sentences[i], sentence);
            }

            i++;
        }
    }
}
