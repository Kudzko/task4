package by.epam.javawebtraining.kudzko.task04.model.logic;

import by.epam.javawebtraining.kudzko.task04.model.entity.*;
import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements ParseAble {
    public static final String WORD_TAG = "([ ]|([,;] )) ";

    public SentenceParser() {

    }

    @Override
    public void parse(String data, TextElement sentence) {

        System.out.println(getClass());

        Pattern pattern = Pattern.compile(WORD_TAG);
        Matcher matcher = pattern.matcher(data);
        String[] words = pattern.split(data);

        int i = 0;
        while (i < words.length) {

            Word word = new Word();
            if (matcher.find()){
                word.addPunctuatoinElement(matcher.group());
            }
            word.setWord(words[i]);
            try {
                sentence.addElement(word);
            } catch (MismatchTypesException e) {
                e.printStackTrace();
            }

            i++;
        }
    }
}
