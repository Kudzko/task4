package by.epam.javawebtraining.kudzko.task04.model.logic.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RegexConst {

    private static String[] regexConsts = readRegexConsts();
    public static final String PARAGRAPH_TAG = regexConsts[0];
    public static final String SENTENCE_TAG = regexConsts[1];
    public static final String WORD_TAG = regexConsts[2];

    private static String[] readRegexConsts() {

        Properties properties = new Properties();
        try {
            FileInputStream constant = new FileInputStream
                    ("..\\task4\\src\\by\\epam\\javawebtraining\\kudzko" +
                            "\\task04\\model\\logic\\parser\\RegexConst.properties");
            properties.load(constant);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] regexConsts = new String[3];
        regexConsts[0] = properties.getProperty("PARAGRAPH_TAG");
        regexConsts[1] = properties.getProperty("SENTENCE_TAG");
        regexConsts[2] = properties.getProperty("WORD_TAG");

        return regexConsts;
    }


}
