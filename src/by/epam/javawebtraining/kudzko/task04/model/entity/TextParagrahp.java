package by.epam.javawebtraining.kudzko.task04.model.entity;

import java.util.ArrayList;
import java.util.List;

public class TextParagrahp extends Paragrahp {

    private List<Sentence> sentences;

    public TextParagrahp() {
        sentences = new ArrayList<>();
    }

    public TextParagrahp(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public TextParagrahp(List<String> punctuation, List<Sentence> sentences) {
        this.sentences = sentences;
    }
}
