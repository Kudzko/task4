package by.epam.javawebtraining.kudzko.task04.model.logic.operation;

import by.epam.javawebtraining.kudzko.task04.model.entity.Text;
import by.epam.javawebtraining.kudzko.task04.model.logic.parser.ParagraphParser;
import by.epam.javawebtraining.kudzko.task04.model.logic.parser.SentenceParser;
import by.epam.javawebtraining.kudzko.task04.model.logic.parser.TextParser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShowSentencesByLengthTest {
    String text;

    @Before
    public void createText() {
        text = "I love java! " +
                "I enjoy  enjoy  enjoy java.\n" +
                "I want to be a good developer otherwise. " +
                "Another good awesome sentence. " +
                "Test?";
    }

    @Test
    public void tst_showSentencesIncreaseLength() {
        String expectResult = "Sentence 0:\n" +
                "Test?" + "\n"+
                "Sentence 1:\n" +
                "I love java" + "\n"+
                "Sentence 2:\n" +
                "I enjoy  enjoy  enjoy java" + "\n"+
                "Sentence 3:\n" +
                "Another good awesome sentence" + "\n"+
                "Sentence 4:\n" +
                "I want to be a good developer otherwise" + "\n";

        Text textInstance = new Text();
        SentenceParser sentenceParser = SentenceParser.getSentenceParser(null);
        ParagraphParser paragraphParser = ParagraphParser.getParagraphParser(sentenceParser);
        TextParser textParser = TextParser.getTexParser(paragraphParser);

        textParser.parse(text, textInstance);

        String result = ShowSentencesByLength.showSentencesIncreaseLength
                (textInstance);

        assertTrue(result.equals(expectResult));
    }


    @Test
    public void tst_showSentencesDecreaseLength() {
        String expectResult = "Sentence 0:\n" +
                "I want to be a good developer otherwise" + "\n"+
                "Sentence 1:\n" +
                "Another good awesome sentence" + "\n"+
                "Sentence 2:\n" +
                "I enjoy  enjoy  enjoy java" + "\n"+
                "Sentence 3:\n" +
                "I love java" + "\n"+
                "Sentence 4:\n" +
                "Test?" + "\n";

        Text textInstance = new Text();
        SentenceParser sentenceParser = SentenceParser.getSentenceParser(null);
        ParagraphParser paragraphParser = ParagraphParser.getParagraphParser(sentenceParser);
        TextParser textParser = TextParser.getTexParser(paragraphParser);

        textParser.parse(text, textInstance);

        String result = ShowSentencesByLength.showSentencesDecreaseLength(textInstance);

        assertTrue(result.equals(expectResult));
    }
}
