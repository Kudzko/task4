package by.epam.javawebtraining.kudzko.task04.model.entity;

import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TextParagraph extends Paragraph {

    private List<Sentence> sentences;

    public TextParagraph() {
        sentences = new ArrayList<>();
    }

    public TextParagraph(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public TextParagraph(List<String> punctuation, List<Sentence> sentences) {
        this.sentences = sentences;
    }


    @Override
    public void addElement(TextElement element) throws MismatchTypesException {
        if (element instanceof Sentence) {
            sentences.add((Sentence) element);
        } else {
            throw new MismatchTypesException("Is not appropriate type to  " +
                    "add. Element should has type Sentence.");
        }


    }

    @Override
    public Object getChild(int index) {
        return sentences.get(index);
    }

    @Override
    public int getAmountElements() {
        return sentences.size();
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public boolean equals(Object o) {
        if ((o == null) || (o.getClass() != this.getClass())) return false;
        if (this == o) return true;
        TextParagraph that = (TextParagraph) o;
        return Objects.equals(sentences, that.sentences);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sentences);
    }

    @Override
    public String toString() {

        return toAbstractString(sentences);
    }
}
