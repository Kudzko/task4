package by.epam.javawebtraining.kudzko.task04.model.entity;

import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TextParagraph extends Paragraph {

    public TextParagraph() {
    }

    public TextParagraph(List<String> punctuation, List<Sentence> textElements) {
        super(punctuation, textElements);
    }

    @Override
    public void addElement(TextElement element) throws MismatchTypesException {
        if (element instanceof Sentence) {
            getTextElements().add((Sentence) element);
        } else {
            throw new MismatchTypesException("Is not appropriate type to  " +
                    "add. Element should has type Sentence.");
        }


    }


    @Override
    public String toString() {
        return toAbstractString(getTextElements());
    }
}
