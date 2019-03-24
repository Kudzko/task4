package by.epam.javawebtraining.kudzko.task04.util;

import by.epam.javawebtraining.kudzko.task04.model.entity.*;


public class TextElementCreator {

    public enum TextElementType {
        TEXT, PARAGRAPH, TEXT_PARAGRAPH, LISTING_PARAGRAPH, SENTENCE, WORD;
    }

    private static TextElementCreator textElementCreator;

    private TextElementCreator() {
    }

    public static TextElementCreator getTextElementCreator() {
        if (textElementCreator == null) {
            textElementCreator = new TextElementCreator();
        }
        return textElementCreator;
    }

    public static TextElement createTextElement(TextElementType
                                                        textElementType) {
        switch (textElementType) {
            case TEXT:
                return new Text();
            case PARAGRAPH:
                return new Paragrahp();
            case TEXT_PARAGRAPH:
                return new TextParagrahp();
            case LISTING_PARAGRAPH:
                return new ListingParagrahp();
            case SENTENCE:
                return new Sentence();
            default:
                return new Word();
        }
    }
}
