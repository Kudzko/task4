package by.epam.javawebtraining.kudzko.task04.model.logic;

import by.epam.javawebtraining.kudzko.task04.model.entity.*;
import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser implements ParseAble {

    public static final String PARAGRAPH_TAG = "(([.!?:]{1})|([\n]}\\s*[\n]))\\s*[\n]";
    //("\\s*.*// ([(){};," +"+-=&\"\']+)\\s*[\n]");

    private ParagraphParser parant;
    // private String  message;

    public TextParser(ParagraphParser parant) {
        this.parant = parant;
        //    this.message = message;
    }

    @Override
    public void parse(String data, TextElement textInstance){

        Pattern pattern = Pattern.compile(PARAGRAPH_TAG);
        Matcher matcher = pattern.matcher(data);
        String[] paragraphs = pattern.split(data);

        int i = 0;
        while (i < paragraphs.length) {

            Paragraph paragraph = createApropriareParagraph(paragraphs[i]);
            if (matcher.find()){
                ((Text)textInstance).addPunctuatoinElement(matcher.group());
            }

            try {
                textInstance.addElement(paragraph);
            } catch (MismatchTypesException e) {
                e.printStackTrace();
            }

            if (paragraph instanceof TextParagraph){
                if (parant != null) {
                    parant.parse(paragraphs[i], paragraph);
                }
            }else {
                ((ListingParagraph) paragraph).setListing(paragraphs[i]);
            }
            i++;
        }
    }

    private Paragraph createApropriareParagraph(String paragraf) {
        if (KindConteinsChecker.analiseParagraph(paragraf)
                == KindConteinsChecker.ParagraphType.TEXT) {
            return new TextParagraph();
        } else {
            return  new ListingParagraph();
        }
    }


}
