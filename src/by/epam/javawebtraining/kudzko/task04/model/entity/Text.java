package by.epam.javawebtraining.kudzko.task04.model.entity;

import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Text extends AbstractTextPart<Paragraph> implements TextElement {


    @Override
    public void addElement(TextElement element) throws MismatchTypesException {
        if (element instanceof Paragraph) {
            getTextElements().add((Paragraph) element);
        } else {
            throw new MismatchTypesException("Is not appropriate type " +
                    "adding. Element should has type Paragraph.");
        }

    }

    @Override
    public String toString() {

        return toAbstractString(getTextElements());
    }
}
