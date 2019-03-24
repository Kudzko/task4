package by.epam.javawebtraining.kudzko.task04.model.entity;

import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;

public interface TextElement {

    public void addElement(TextElement element) throws MismatchTypesException;
    public Object getChild(int index);
    public int getAmountElements();
    public abstract String toString();
//    public void operation();
//    public TextElement remove(int index);

}
