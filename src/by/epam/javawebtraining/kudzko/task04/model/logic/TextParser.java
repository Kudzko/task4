package by.epam.javawebtraining.kudzko.task04.model.logic;

import by.epam.javawebtraining.kudzko.task04.inputdatacontroller.TextReader;
import by.epam.javawebtraining.kudzko.task04.model.entity.ListingParagrahp;
import by.epam.javawebtraining.kudzko.task04.model.entity.Paragrahp;
import by.epam.javawebtraining.kudzko.task04.model.entity.Text;
import by.epam.javawebtraining.kudzko.task04.model.entity.TextParagrahp;
import by.epam.javawebtraining.kudzko.task04.util.TextElementCreator;

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
    public void parse(String data, Text textInstance) {
        Pattern pattern = Pattern.compile(PARAGRAPH_TAG);
        Matcher matcher = pattern.matcher(data);
        String[] paragraphs = pattern.split(data);


        int i = 0;
        while (matcher.find()) {

            i++;
            Paragrahp paragrahp = createApropriareParagraph(paragraphs[i]);
            paragrahp.addPunctuatoinElement(matcher.group());
            textInstance.addElement(paragrahp);

            if (parant != null) {
               parant.parse(paragraphs[i], textInstance);
            }
        }
    }

    private Paragrahp createApropriareParagraph(String paragraf) {
        if (KindConteinsChecker.analiseParagraph(paragraf)
                == KindConteinsChecker.ParagraphType.TEXT) {
            return new TextParagrahp();
        } else {
            return  new ListingParagrahp();
        }
    }


}
