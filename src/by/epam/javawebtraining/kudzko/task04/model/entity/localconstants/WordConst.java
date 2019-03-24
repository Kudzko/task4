package by.epam.javawebtraining.kudzko.task04.model.entity.localconstants;

import java.util.Locale;
import java.util.ResourceBundle;

public class WordConst {
    private  static ResourceBundle bundle;
    private static Locale locale;

    static {

    }

    public static String CLASSNAME;
    public static String WORD;

    public static void changeLocale(Locale locale){
        bundle = ResourceBundle.getBundle("", locale);
        WORD = bundle.getString("classname");
        CLASSNAME = bundle.getString("word");
    }
}
