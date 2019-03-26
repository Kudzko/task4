package by.epam.javawebtraining.kudzko.task04.model.logic.parser;

import by.epam.javawebtraining.kudzko.task04.model.entity.*;
import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;
import by.epam.javawebtraining.kudzko.task04.model.logic.parser.ParseAble;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements ParseAble {
    private static SentenceParser sentenceParser;
    public static final String WORD_TAG = "([ ]|([,;] )) ";

    private SentenceParser() {

    }

    public static SentenceParser getSentenceParser(){
        if (sentenceParser == null){
            sentenceParser = new SentenceParser();
        }
        return sentenceParser;
    }

    @Override
    public void parse(String data, TextElement sentence) {

        Pattern pattern = Pattern.compile(WORD_TAG);
        Matcher matcher = pattern.matcher(data);
        String[] words = pattern.split(data);

        int i = 0;
        while (i < words.length) {

            Word word = new Word();
            if (matcher.find()){
                ((Sentence)sentence).addPunctuatoinElement(matcher.group());
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
