package by.epam.javawebtraining.kudzko.task04.model.entity;

import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TextParagraph extends Paragraph {

    private List<Sentence > sentences;

    public TextParagraph() {
        sentences = new ArrayList<>();
    }

    public TextParagraph(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public TextParagraph(List<String> punctuation, List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public void addElement(TextElement element) throws MismatchTypesException {
        sentences.add((Sentence) element);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextParagraph)) return false;
        TextParagraph that = (TextParagraph) o;
        return Objects.equals(sentences, that.sentences);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sentences);
    }

    @Override
    public String toString() {
       /* StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < sentences.size(); i++) {
            stringBuilder.append(sentences.get(i));
            List<String> punctuation = getPunctuation();

            if (i < punctuation.size()) {
                stringBuilder.append(punctuation.get(i));
            }
        }

        return stringBuilder.toString();
        */
       return toAbstractString(sentences);
    }
}
