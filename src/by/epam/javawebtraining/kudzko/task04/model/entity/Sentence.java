package by.epam.javawebtraining.kudzko.task04.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence extends AbstractTextPart implements TextElement {

    private List<Word> wordList;


    public Sentence() {
        wordList = new ArrayList<>();
    }

    public Sentence(List<Word> wordList) {
        this.wordList = wordList;
    }

    public Sentence(List<String> punctuation, List<Word> wordList) {
        super(punctuation);
        this.wordList = wordList;
    }


    @Override
    public void addElement(Object element) {

    }

    @Override
    public Object getChild(int index) {
        return null;
    }

    public List<Word> getWordList() {
        return wordList;
    }

    public void setWordList(List<Word> wordList) {
        this.wordList = wordList;
    }

    }
