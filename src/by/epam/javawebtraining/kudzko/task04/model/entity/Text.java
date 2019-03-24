package by.epam.javawebtraining.kudzko.task04.model.entity;

import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Text extends  AbstractTextPart implements TextElement{

    List<Paragraph> paragraphs;

    public Text() {
        paragraphs = new ArrayList<>();
    }

    public Text(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }


    @Override
    public void addElement(TextElement element) throws MismatchTypesException {
        if (element instanceof Paragraph){
            paragraphs.add((Paragraph)element);
        }else {
            throw new MismatchTypesException("Is not appropriate type " +
                    "adding. Element should has type Paragraph.");
        }


    }

    @Override
    public Object getChild(int index) {
        return paragraphs.get(index);
    }

    @Override
    public int getAmountElements() {
        return paragraphs.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Text)) return false;
        Text text = (Text) o;
        return Objects.equals(paragraphs, text.paragraphs);
    }

    @Override
    public int hashCode() {

        return Objects.hash(paragraphs);
    }

    @Override
    public String toString() {
        return "Text{" +
                "paragraphs=" + paragraphs +
                '}';
    }
}
