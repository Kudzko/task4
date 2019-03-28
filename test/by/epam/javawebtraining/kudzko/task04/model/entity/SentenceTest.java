package by.epam.javawebtraining.kudzko.task04.model.entity;

import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class SentenceTest {

    Sentence sentence;

    @Before
    public void createSentence() {
        sentence = new Sentence();
    }

    @After
    public void deleteWord() {
        sentence = null;
    }

    @Test()
    public void addElement_tst() throws MismatchTypesException {
        Word word1 = new Word();
        word1.setWord("Test1");
        int sizeBefor = sentence.getAmountElements();
        sentence.addElement(word1);
        int sizeAfter = sentence.getAmountElements();
        Object word2 = sentence.getChild(sizeAfter - 1);

        assertEquals(sizeBefor + 1, sizeAfter);
        assertTrue(word1.equals(word2));
    }

    @Test(expected = MismatchTypesException.class)
    public void tstNegative_addElement() throws MismatchTypesException {
        Sentence newSentence = new Sentence();

        sentence.addElement(newSentence);
    }

    @Test()
    public void getChild_test() {

        Word word1 = new Word();
        word1.setWord("Test1");
        Word word2 = new Word();
        word2.setWord("Test2");
        Word word3 = new Word();
        word3.setWord("Test3");
        try {
            sentence.addElement(word1);
            sentence.addElement(word2);
            sentence.addElement(word3);
        } catch (MismatchTypesException e) {
            e.printStackTrace();
        }

        assertEquals(sentence.getChild(0), word1);
        assertEquals(sentence.getChild(1), word2);
        assertEquals(sentence.getChild(2), word3);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void tstNegative_getChild() {
        sentence = new Sentence();
        sentence.getChild(1);
    }

    @Test()
    public void getAmountElements_test() {
        Word word1 = new Word();
        word1.setWord("Test1");
        int sizeBefor = sentence.getAmountElements();
        try {
            sentence.addElement(word1);
        } catch (MismatchTypesException e) {
            e.printStackTrace();
        }
        int sizeAfter = sentence.getAmountElements();

        assertEquals(sizeBefor + 1, sizeAfter);
    }

    @Test
    public void equals_test() {
        Word word1 = new Word();
        word1.setWord("Test1");
        Word word2 = new Word();
        word2.setWord("Test2");
        Word word3 = new Word();

        Sentence sentence1 = new Sentence();
        Sentence sentence2 = new Sentence();

        try {
            sentence1.addElement(word1);
            sentence1.addElement(word2);

            sentence2.addElement(word1);
            sentence2.addElement(word2);
        } catch (MismatchTypesException e) {
            e.printStackTrace();
        }
        assertTrue( sentence1.equals(sentence2));
    }

    @Test
    public void equalsNegative_test() {
        Word word1 = new Word();
        word1.setWord("Test1");
        Word word2 = new Word();
        word2.setWord("Test2");
        Word word3 = new Word();
        word3.setWord("Test3");
        Word word4 = new Word();
        word3.setWord("Test4");
        Sentence sentence1 = new Sentence();
        Sentence sentence2 = new Sentence();

        try {
            sentence1.addElement(word1);
            sentence1.addElement(word2);

            sentence2.addElement(word3);
            sentence2.addElement(word4);
        } catch (MismatchTypesException e) {
            e.printStackTrace();
        }
        assertFalse(sentence1.equals(sentence2));
    }

    @Test
    public void equalsNegative2_test() {
        Paragraph paragraph = new TextParagraph();

        assertFalse(sentence.equals(paragraph));
    }

}
