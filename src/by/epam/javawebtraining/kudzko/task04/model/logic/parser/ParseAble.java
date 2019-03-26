package by.epam.javawebtraining.kudzko.task04.model.logic.parser;

import by.epam.javawebtraining.kudzko.task04.model.entity.Text;
import by.epam.javawebtraining.kudzko.task04.model.entity.TextElement;
import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;

public interface ParseAble {
    public void parse(String data, TextElement textElement);
}
