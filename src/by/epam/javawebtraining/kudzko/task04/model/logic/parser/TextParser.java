package by.epam.javawebtraining.kudzko.task04.model.logic.parser;

import by.epam.javawebtraining.kudzko.task04.model.entity.*;
import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Split String of whole text for String[] of Paragraphs and calls
 * ParagraphParser
 */
public class TextParser implements ParseAble {

    private static TextParser textParser;

    public static final String PARAGRAPH_TAG = "(([.!?:]{1})|([\n]}\\s*[\n]))\\s*[\n]";
    //("\\s*.*// ([(){};," +"+-=&\"\']+)\\s*[\n]");

    private ParagraphParser parant;

    private TextParser(ParagraphParser parant) {
        this.parant = parant;
    }

    public static TextParser getTexParser(ParagraphParser parant) {
        if (textParser == null) {
            textParser = new TextParser(parant);
        }
        return textParser;
    }


    @Override
    public void parse(String data, TextElement textInstance) {

        Pattern pattern = Pattern.compile(PARAGRAPH_TAG);
        Matcher matcher = pattern.matcher(data);
        String[] paragraphs = pattern.split(data);

        //call ParagraphParser several times
        int i = 0;
        while (i < paragraphs.length) {
            //Create instance of paragraph
            Paragraph paragraph = createApropriareParagraph(paragraphs[i]);
            if (matcher.find()) {
                ((Text) textInstance).addPunctuatoinElement(matcher.group());
            }
            //punctuation is saved
            try {
                textInstance.addElement(paragraph);
            } catch (MismatchTypesException e) {
                e.printStackTrace();
            }
            //ParagraphParser is called
            if (paragraph instanceof TextParagraph) {
                if (parant != null) {
                    parant.parse(paragraphs[i], paragraph);
                }
            } else {
                ((ListingParagraph) paragraph).setListing(paragraphs[i]);
            }
            i++;
        }
    }

    /**
     * Checks if String is a listing or text and create instance
     *
     * @param paragraf
     * @return new TextParagraph() or  new ListingParagraph()
     */
    private Paragraph createApropriareParagraph(String paragraf) {
        if (KindConteinsChecker.analiseParagraph(paragraf)
                == KindConteinsChecker.ParagraphType.TEXT) {
            return new TextParagraph();
        } else {
            return new ListingParagraph();
        }
    }


}
