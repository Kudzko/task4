package by.epam.javawebtraining.kudzko.task04.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Text extends  AbstractTextPart implements TextElement{

    List<Paragrahp> paragrahps;

    public Text() {
        paragrahps = new ArrayList<>();
    }

    public Text(List<Paragrahp> paragrahps) {
        this.paragrahps = paragrahps;
    }


    @Override
    public void addElement(Object element) {

    }

    @Override
    public Object getChild(int index) {
        return null;
    }
}
