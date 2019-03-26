package by.epam.javawebtraining.kudzko.task04.model.entity;

import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;
import by.epam.javawebtraining.kudzko.task04.model.entity.localconstants.WordConst;

import java.util.Objects;

public class Word extends AbstractTextPart implements TextElement {
    private String word;

    @Override
    public void addElement(TextElement element) throws MismatchTypesException {

//log
    }

    @Override
    public Object getChild(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getAmountElements() {
        return -1;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if ((o == null) || (o.getClass() != this.getClass())) return false;
        if (this == o) return true;
        Word word1 = (Word) o;
        return word.equals(((Word) o).word);
    }

    @Override
    public int hashCode() {

        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return word;
    }
}
