package by.epam.javawebtraining.kudzko.task04.model.logic;

public class ParagrafParser implements AbstractParser{

    SentenceParser root;

    public ParagrafParser(SentenceParser root) {
        this.root = root;
    }


    @Override
    public void request() {

    }
}
