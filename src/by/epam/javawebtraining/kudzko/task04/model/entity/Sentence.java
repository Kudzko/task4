package by.epam.javawebtraining.kudzko.task04.model.entity;

import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sentence extends AbstractTextPart implements TextElement {

    private List<Word> wordList;


    public Sentence() {
        wordList = new ArrayList<>();
    }

    public Sentence(List<Word> wordList) {
        this.wordList = wordList;
    }

    public Sentence(List<String> punctuation, List<Word> wordList) {
        super(punctuation);
        this.wordList = wordList;
    }

    @Override
    public void addElement(TextElement element) throws MismatchTypesException {
        if (element instanceof Word) {
            wordList.add((Word) element);
        } else {
            throw new MismatchTypesException("Is not appropriate type " +
                    "adding. Element should has type Sentence.");
        }
    }

    @Override
    public Object getChild(int index) {
        return null;
    }

    @Override
    public int getAmountElements() {
        return 0;
    }

    public List<Word> getWordList() {
        return wordList;
    }

    public void setWordList(List<Word> wordList) {
        this.wordList = wordList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;
        Sentence sentence = (Sentence) o;
        return Objects.equals(wordList, sentence.wordList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(wordList);
    }

    @Override
    public String toString() {
      /*  StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < wordList.size(); i++) {
            stringBuilder.append(wordList.get(i));
            List<String> punctuation = getPunctuation();

            if (i < punctuation.size()){
                stringBuilder.append(punctuation.get(i));
            }
        }

        return stringBuilder.toString();*/
        return toAbstractString(wordList);
    }
}
