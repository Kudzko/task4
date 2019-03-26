package by.epam.javawebtraining.kudzko.task04.model.logic.operation;

import by.epam.javawebtraining.kudzko.task04.model.entity.Sentence;
import by.epam.javawebtraining.kudzko.task04.model.entity.Text;
import by.epam.javawebtraining.kudzko.task04.model.entity.Word;

import java.util.Comparator;
import java.util.List;

public class AmountSentencesWithSameWords extends AbstractOperation {

    public static int countSentencesWithEqualsWords(Text text) {
        int amoutnSentencesWithEqualsWords = 0;
        List<Sentence> sentences = getAllSentences(text);

        for (int i = 0; i < sentences.size(); i++){
            if (checkEqualsWords(sentences.get(i))){
                amoutnSentencesWithEqualsWords++;
            }
        }

        return amoutnSentencesWithEqualsWords;
    }

    private static boolean checkEqualsWords (Sentence sentence){
        int amountWords = sentence.getAmountElements();
        for (int i = 0; i < amountWords - 1; i++){
            for (int j = i+1; j < amountWords; j++ ){
                Word word1 = (Word) sentence.getChild(i);
                Word word2 = (Word) sentence.getChild(j);

                if (word1.getWord().equalsIgnoreCase(word2.getWord())){
                    return true;
                }
            }
        }

        return false;
    }


}
