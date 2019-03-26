package by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception;

import by.epam.javawebtraining.kudzko.task04.model.entity.exception.LogicException;

public class UnsupportedOperationException extends LogicException {
    public UnsupportedOperationException() {
    }

    public UnsupportedOperationException(String message) {
        super(message);
    }
}
