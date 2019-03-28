package by.epam.javawebtraining.kudzko.task04.model.entity;

import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;
import org.junit.After;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WordTest {
    Word word;

    @Before
    public void createWord() {
        word = new Word();
        word.setWord("Test");
    }

    @After
    public void deleteWord() {
        word = null;
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addElement_tst() throws MismatchTypesException {
        Word addingWord = new Word();
        addingWord.setWord("addingWord");
        word.addElement(addingWord);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getChild_test() {
        word.getChild(0);
    }

    @Test()
    public void getAmountElements_test() {

        assertEquals(-1, word.getAmountElements());
    }

    @Test
    public void equals_test() {
        Word word2 = new Word();
        word2.setWord("Test");

        assertTrue(word.equals(word2));
    }

    @Test
    public void equalsNegative_test() {
        Word word2 = new Word();
        word2.setWord("Test2");

        assertFalse(word.equals(word2));
    }

    @Test
    public void equalsNegative2_test() {
        Sentence sentence = new Sentence();

        assertFalse(word.equals(sentence));
    }


}
