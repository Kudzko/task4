package by.epam.javawebtraining.kudzko.task04.model.logic;

import by.epam.javawebtraining.kudzko.task04.model.entity.*;
import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements ParseAble {
    public static final String SENTENCE_TAG = "[.!?] ";

    private SentenceParser root;

    public ParagraphParser(SentenceParser root) {
        this.root = root;
    }


    @Override
    public void parse(String data, TextElement paragraph) {

        System.out.println(getClass());

        Pattern pattern = Pattern.compile(SENTENCE_TAG);
        Matcher matcher = pattern.matcher(data);
        String[] sentences = pattern.split(data);

        int i = 0;
        while (i < sentences.length) {

            Sentence sentence = new Sentence();
            if (matcher.find()){
                sentence.addPunctuatoinElement(matcher.group());
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
