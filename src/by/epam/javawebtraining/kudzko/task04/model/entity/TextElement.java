package by.epam.javawebtraining.kudzko.task04.model.entity;

import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;

public interface TextElement<T> {

    /**
     * adds an element to the List<> of the instance
     * @param element
     * @throws MismatchTypesException if you try add element of unsuitable type
     * For example Word to the Paragraph
     */
    void addElement(TextElement element) throws MismatchTypesException;

    /**
     * Return element from instance's List<>
     * @param index
     * @return element of appropriate type witch contains in instance
     */
    TextElement getChild(int index);

    /**
     *
     * @return number of elements in a List<> of instance
     */
    int getAmountElements();
}
