package by.epam.javawebtraining.kudzko.task04.model.logic.operation;

import by.epam.javawebtraining.kudzko.task04.model.entity.Sentence;
import by.epam.javawebtraining.kudzko.task04.model.entity.Text;

import java.util.Comparator;
import java.util.List;

public class ShowSentencesByAmountWords extends AbstractOperation {

    public static String showSentencesByIncreaceAmountWords(Text text) {
        Comparator<Sentence> comparator = new IncreaseAmountWordsSentence();
        return returnSentencesByComparator(text, comparator);

    }

    public static String showSentencesByDecreaceAmountWords(Text text) {
        Comparator<Sentence> comparator = new DecreaseAmountWordsSentence();
        return returnSentencesByComparator(text, comparator);

    }


    private static String returnSentencesByComparator(Text text, Comparator<Sentence>
            comparator) {

        List<Sentence> sentences = getAllSentences(text);
        sentences.sort(comparator);
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\nSentences in order with comparator " +
                comparator.getClass().getName() + ":\n");

        for (int i = 0; i < sentences.size(); i++) {
            stringBuilder.append("Sentence " + (i + 1) + ":\n");
            stringBuilder.append(sentences.get(i));
        }

        return stringBuilder.toString();
    }

    private static class IncreaseAmountWordsSentence implements Comparator<Sentence> {
        @Override
        public int compare(Sentence o1, Sentence o2) {
            return o1.getAmountElements() - o2.getAmountElements();
        }
    }

    private static class DecreaseAmountWordsSentence implements
            Comparator<Sentence> {
        @Override
        public int compare(Sentence o1, Sentence o2) {
            return o2.getAmountElements() - o1.getAmountElements();
        }
    }
}
