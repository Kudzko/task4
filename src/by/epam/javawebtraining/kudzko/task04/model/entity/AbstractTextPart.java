package by.epam.javawebtraining.kudzko.task04.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AbstractTextPart {

    private List<String> punctuation;

    public AbstractTextPart() {
        punctuation = new ArrayList<>();
    }

    public AbstractTextPart(List<String> punctuation) {
        this.punctuation = punctuation;
    }


    public void addPunctuatoinElement( String punctuatoinElement){
        punctuation.add(punctuatoinElement);
    }

    public String getNextPunctuationElement(){
        return (String) ((Queue)punctuation).peek();
    }



    public List<String> getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(List<String> punctuation) {
        this.punctuation = punctuation;
    }
}