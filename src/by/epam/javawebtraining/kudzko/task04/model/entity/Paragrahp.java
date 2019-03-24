package by.epam.javawebtraining.kudzko.task04.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Paragrahp extends AbstractTextPart implements TextElement {

    private List<Object> defaultParagraph;


    public Paragrahp() {
        defaultParagraph = new ArrayList<>();
    }

    public Paragrahp(List<Object> defaultParagraph) {
        this.defaultParagraph = defaultParagraph;
    }

    public Paragrahp(List<String> punctuation, List<Object> defaultParagraph) {
        super(punctuation);
        this.defaultParagraph = defaultParagraph;
    }

    @Override
    public void addElement(Object element) {

        defaultParagraph.add(element);

    }

    @Override
    public Object getChild(int index) {

        return defaultParagraph.get(index);
    }
}
