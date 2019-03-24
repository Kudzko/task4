package by.epam.javawebtraining.kudzko.task04.model.entity;

import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Paragraph extends AbstractTextPart implements TextElement {

   // private List<Object> defaultParagraph;


    public Paragraph() {
        /*defaultParagraph = new ArrayList<>();*/
    }

    public Paragraph(List<Object> defaultParagraph) {
       /* this.defaultParagraph = defaultParagraph;*/
    }

    public Paragraph(List<String> punctuation, List<Object> defaultParagraph) {
        super(punctuation);
        /*this.defaultParagraph = defaultParagraph;*/
    }

    @Override
    public void addElement(TextElement element) throws MismatchTypesException {
       /* defaultParagraph.add(element);*/

    }

    @Override
    public int getAmountElements() {
        return 0;
    }

    /*@Override
    public Object getChild(int index) {

        return *//*defaultParagraph.get(index)*//* ;
    }*/

    @Override
    public Object getChild(int index) {
        return null;
    }



}
