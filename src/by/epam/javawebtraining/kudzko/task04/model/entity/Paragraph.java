package by.epam.javawebtraining.kudzko.task04.model.entity;

import java.util.List;

public abstract class Paragraph extends AbstractTextPart<Sentence>{


    public Paragraph() {

    }

    public Paragraph(List<String> punctuation, List<Sentence> textElements) {
        super(punctuation, textElements);
    }
}
