package by.epam.javawebtraining.kudzko.task04.model.logic.operation;

import by.epam.javawebtraining.kudzko.task04.model.entity.*;

import java.util.ArrayList;
import java.util.List;

public class AbstractOperation {

    protected static List<Sentence> getAllSentences(Text text) {
        List<Sentence> sentences = new ArrayList<>();

        for (int i = 0; i < text.getAmountElements(); i++) {
            Paragraph paragraph = (Paragraph) text.getChild(i);
            if (paragraph instanceof TextParagraph) {
                TextParagraph textParagraph = (TextParagraph) paragraph;
                sentences.addAll(textParagraph.getTextElements());
            }

        }
        return sentences;
    }

    protected static List<Word> getAllWords(Text text) {
        List<Word> words = new ArrayList<>();

        for (int i = 0; i < text.getAmountElements(); i++) {
            Paragraph paragraph = (Paragraph) text.getChild(i);

            if (paragraph instanceof TextParagraph) {
                TextParagraph textParagraph = (TextParagraph) paragraph;

                for (int j = 0; j < textParagraph.getAmountElements(); j++) {
                    Sentence sentence = (Sentence) textParagraph.getChild(j);
                    words.addAll(sentence.getTextElements());
                }

            }
        }
        return words;
    }
}
