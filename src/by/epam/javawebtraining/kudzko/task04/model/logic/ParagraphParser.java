package by.epam.javawebtraining.kudzko.task04.model.logic;

import by.epam.javawebtraining.kudzko.task04.model.entity.Text;

public class ParagraphParser implements ParseAble {

    SentenceParser root;

    public ParagraphParser(SentenceParser root) {
        this.root = root;
    }


    @Override
    public void parse(String data, Text textInstance) {
        



    }
}
