package by.epam.javawebtraining.kudzko.task04.model.entity;

import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sentence extends AbstractTextPart<Word> {

    public Sentence() {
    }

    public Sentence(List punctuation, List textElements) {
        super(punctuation, textElements);
    }

    @Override
    public void addElement(TextElement element) throws MismatchTypesException {
        if (element instanceof Word) {
            getTextElements().add((Word) element);
        } else {
            throw new MismatchTypesException("Is not appropriate type " +
                    "to add. Element should has type Word.");
        }
    }

    @Override
    public String toString() {

        return toAbstractString(getTextElements());
    }
}
