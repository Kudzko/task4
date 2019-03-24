package by.epam.javawebtraining.kudzko.task04.model.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KindConteinsChecker {

    public static final String[] KEY_WORDS = {"abstract", "continue",
            "for\\s?\\(", "\\p{Punct}+\\s+new", "switch", "assert",
            "default",
            "goto",
            "package", "synchronized", "boolean", "do\\s?\\(", "if\\s?\\(",
            "private", "this", "break", "double", "implements",
            "protected\\s+.{1,}\\s*\\;",
            "throw", "byte", "}\\s?else\\s?\\{", "import", "public",
            "throws\\s+.{1,}\\s+\\{",
            "case", "enum", "instanceof", "return\\s+.+\\;", "transient",
            "catch\\s?\\{",
            "extends", "int", "short", "try", "char", "final", "interface", "static",
            "void", "class", "finally", "long", "strictfp", "volatile",
            "const", "float", "native", "super", "while\\s?[(]", "true",
            "false",
            "null"};

    public static final String PUNKT = "\\p{Punct}";
    public static final String NEW_LINE = "\\n";

    /**
     * Sets max amount of new lines in paragraf with text
     */
    public static final int MAX_AMOUNT_NEW_LINES = 2;

    /**
     * Sets max percent of sum all letters key words, witch contains in
     * paragraph, to letters of whole paragraph
     */
    public static final int PERCENT_KEY_WORDS = 10;

    /**
     * Sets MIN amount key words in listing
     */
    public static final int MIN_AMOUNT_KEY_WORDS = 2;

    /**
     * Sets min percent of punctuations on one new line listing
     */
    public static final int MIN_RATIO_PUNKTS = 2;

    public enum ParagraphType {
        TEXT, LISTING;
    }

    /**
     * Defines type of paragraph
     * @param paragraph
     * @return ParagraphType (TEXT, LISTING;)
     */
    public static ParagraphType analiseParagraph(String paragraph) {

        int amountKeyWords = countKeyWords(paragraph);
        // int amountLettersKeyWords = countLettersKeyWords(paragraph);
        int amountNewLines = countAmountNewLines(paragraph);
        int amountPunct = countAmountPunkt(paragraph);
        // int paragrafLength = paragraph.length();


        if ((amountKeyWords >= MIN_AMOUNT_KEY_WORDS)
                && (amountNewLines >= MAX_AMOUNT_NEW_LINES)
                && ((double) amountPunct / amountNewLines >= MIN_RATIO_PUNKTS)) {
            return ParagraphType.LISTING;
        }
        return ParagraphType.TEXT;
    }

    public static int countAmountPunkt(String paragraf) {
        return countPatternMatchings(paragraf, PUNKT);
    }

    public static int countAmountNewLines(String paragraf) {
        return countPatternMatchings(paragraf, NEW_LINE);
    }

    /**
     * Search patterns and count matchings
     *
     * @param searchingText
     * @param regex
     * @return amount matchers with regex
     */
    public static int countPatternMatchings(String searchingText, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(searchingText);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }

    /**
     * @param paragraph
     * @return return amount key words in paragraph
     */
    public static int countKeyWords(String paragraph) {

        int keyWordsAmount = 0;

        for (int i = 0; i < KEY_WORDS.length; i++) {

            Pattern patternKey = Pattern.compile(KEY_WORDS[i]);
            Matcher matcherKey = patternKey.matcher(paragraph);

            while (matcherKey.find()) {
                keyWordsAmount++;
            }


        }
        return keyWordsAmount;
    }

    /**
     * @param paragraph
     * @return return amount letters of paragraph witch contains in key words
     */
    public static int countLettersKeyWords(String paragraph) {

        int lettersKeyWordsAmount = 0;

        for (int i = 0; i < KEY_WORDS.length; i++) {
            if (paragraph.contains(KEY_WORDS[i])) {
                lettersKeyWordsAmount += KEY_WORDS[i].length();
            }
            ;
        }

        return lettersKeyWordsAmount;
    }

    /**
     * @param paragraph
     * @return an object AmountKeyWodsAndLetters witch contains amount of key
     * words (amountKeyWods) in text and amount letters of these words (amountKeyWodsLetters)
     */
    public static AmountKeyWodsAndLetters countKeyWords1(String paragraph) {

        AmountKeyWodsAndLetters keyWordsAmount = new AmountKeyWodsAndLetters();
        int amountKeyWords = 0;
        int amountLettersKeyWords = 0;

        for (int i = 0; i < KEY_WORDS.length; i++) {
            if (paragraph.contains(KEY_WORDS[i])) {
                amountKeyWords++;
                amountLettersKeyWords++;
                keyWordsAmount.setAmountKeyWods(amountKeyWords);
                keyWordsAmount.setAmountKeyWodsLetters(amountLettersKeyWords);
            }
            ;
        }

        return keyWordsAmount;
    }

    /**
     * class witch contain amount key words and amount letters of this whole
     * words
     */
    public static class AmountKeyWodsAndLetters {
        private int amountKeyWods;
        private int amountKeyWodsLetters;

        public AmountKeyWodsAndLetters() {
        }

        public int getAmountKeyWods() {
            return amountKeyWods;
        }

        public int getAmountKeyWodsLetters() {
            return amountKeyWodsLetters;
        }

        public void setAmountKeyWods(int amountKeyWods) {
            this.amountKeyWods = amountKeyWods;
        }

        public void setAmountKeyWodsLetters(int amountKeyWodsLetters) {
            this.amountKeyWodsLetters = amountKeyWodsLetters;
        }
    }
}
