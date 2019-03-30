package by.epam.javawebtraining.kudzko.task04.model.entity;

import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public abstract class AbstractTextPart<T extends TextElement> implements TextElement {

    private List<T> textElements;

    private List<String> punctuation;

    public AbstractTextPart() {
        punctuation = new ArrayList<>();
        textElements = new ArrayList<>();
    }

    public AbstractTextPart(List<String> punctuation, List<T> textElements) {
        this.punctuation = punctuation;
        this.textElements = textElements;

    }


    public void addPunctuatoinElement(String punctuatoinElement) {
        punctuation.add(punctuatoinElement);
    }

    public String getNextPunctuationElement() {
        return (String) ((Queue) punctuation).peek();
    }


    public List<String> getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(List<String> punctuation) {
        this.punctuation = punctuation;
    }


    @Override
    abstract public void addElement(TextElement element) throws MismatchTypesException;

    @Override
    public TextElement getChild(int index) {
        return textElements.get(index);
    }

    @Override
    public int getAmountElements() {
        return textElements.size();
    }


    public List<T> getTextElements() {
        return textElements;
    }

    public void setTextElements(List<T> textElements) {
        this.textElements = textElements;
    }

    /**
     * Create String from elements of List<>
     *
     * @param listTextParts
     * @return
     */
    public String toAbstractString(List<T> listTextParts) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < listTextParts.size(); i++) {
            stringBuilder.append(listTextParts.get(i));
            List<String> punctuation = getPunctuation();

            if (i < punctuation.size()) {
                stringBuilder.append(punctuation.get(i));
            }
        }
        return stringBuilder.toString();
    }


    @Override
    public boolean equals(Object o) {
        if ((o == null) || (o.getClass() != this.getClass())) return false;
        if (this == o) return true;
        AbstractTextPart<?> that = (AbstractTextPart<?>) o;
        return Objects.equals(textElements, that.textElements) &&
                Objects.equals(punctuation, that.punctuation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(textElements, punctuation);
    }
}
