package by.epam.javawebtraining.kudzko.task04.model.logic;

public class TextParser implements AbstractParser {

    ParagrafParser parant;

    public TextParser(ParagrafParser parant) {
        this.parant = parant;
    }

    @Override
    public void request() {

    }
}
