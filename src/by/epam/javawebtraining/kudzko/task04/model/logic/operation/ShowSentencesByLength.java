package by.epam.javawebtraining.kudzko.task04.model.logic.operation;

import by.epam.javawebtraining.kudzko.task04.model.entity.Sentence;
import by.epam.javawebtraining.kudzko.task04.model.entity.Text;


import java.util.*;

public class ShowSentencesByLength extends AbstractOperation {

    public static String showSentencesIncreaseLength(Text text) {

        Comparator<Sentence> comparator = new IncreaseSentenceLength();

        return sortSentences(text, comparator);
    }

    public static String showSentencesDecreaseLength(Text text) {

        Comparator<Sentence> comparator = new DecreaseSentenceLength();

        return sortSentences(text, comparator);
    }

    private static String sortSentences(Text text, Comparator<Sentence>
            comparator) {
        List<Sentence> sentences = getAllSentences(text);
        sentences.sort(comparator);
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < sentences.size(); i++) {
            stringBuilder.append("Sentence " + i + ":\n");
            stringBuilder.append(sentences.get(i));
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    static class IncreaseSentenceLength implements Comparator<Sentence> {
        @Override
        public int compare(Sentence o1, Sentence o2) {
            return (o1.toString().length() - o2.toString().length());
        }
    }

    static class DecreaseSentenceLength implements Comparator<Sentence> {
        @Override
        public int compare(Sentence o1, Sentence o2) {
            return (o2.toString().length() - o1.toString().length());
        }
    }
}
