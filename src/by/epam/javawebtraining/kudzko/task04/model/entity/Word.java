package by.epam.javawebtraining.kudzko.task04.model.entity;

import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;
import by.epam.javawebtraining.kudzko.task04.model.entity.localconstants.WordConst;

import java.util.Objects;

public class Word extends AbstractTextPart implements TextElement {
    private String word;

    @Override
    public void addElement(TextElement element) throws MismatchTypesException {

    }

    @Override
    public Object getChild(int index) {
        return null;
    }

    @Override
    public int getAmountElements() {
        return 0;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {

        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return WordConst.CLASSNAME + "{" +
                WordConst.WORD+"='" + word + '\'' +
                '}';
    }
}
