package by.epam.javawebtraining.kudzko.task04.model.entity;

import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;

public interface TextElement {

    void addElement(TextElement element) throws MismatchTypesException;

    Object getChild(int index);

    int getAmountElements();
}
