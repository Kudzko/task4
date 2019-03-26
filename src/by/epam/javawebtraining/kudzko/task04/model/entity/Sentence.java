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
                    "to add. Element should has type Word.");
        }
    }

    @Override
    public Object getChild(int index) {
        return wordList.get(index);
    }

    @Override
    public int getAmountElements() {
        return wordList.size();
    }

    public List<Word> getWordList() {
        return wordList;
    }

    public void setWordList(List<Word> wordList) {
        this.wordList = wordList;
    }

    @Override
    public boolean equals(Object o) {
        if ((o == null) || (o.getClass() != this.getClass())) return false;
        if (this == o) return true;
        Sentence sentence = (Sentence) o;
        return Objects.equals(wordList, sentence.wordList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(wordList);
    }

    @Override
    public String toString() {

        return toAbstractString(wordList);
    }
}
