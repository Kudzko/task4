import by.epam.javawebtraining.kudzko.task04.inputdatacontroller.FileByteReader;
import by.epam.javawebtraining.kudzko.task04.inputdatacontroller.TextReader;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static final String PARAGRAF_TAG = "(([.!?:]{1})|([\n]}\\s*[\n]))\\s*[\n]";

    public static void main(String[] args) {


        TextReader textReader = new TextReader();
        FileByteReader textReader2 = new FileByteReader();

        String text = textReader.readTxtFile
                ("F:\\git_rep\\task4\\src\\by\\epam\\javawebtraining\\kudzko" +
                        "\\task04\\inputdatacontroller\\testText.txt");


        Pattern pattern = Pattern.compile(PARAGRAF_TAG);
        //("\\s*.*// ([(){};," +"+-=&\"\']+)\\s*[\n]");

        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println("-----------------");
            count++;
        }
        System.out.println(count);

        String[] result = pattern.split(text);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
            System.out.println("-----------------");
        }


    }
}
