import by.epam.javawebtraining.kudzko.task04.model.entity.Sentence;
import by.epam.javawebtraining.kudzko.task04.model.entity.Word;
import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static final String PARAGRAF_TAG ="(([.!?:]{1})|([\n]}\\s*[\n]))\\s*[\n]";

//            "(([.!?:]{1})|([\n]}\\s*[\n])" +
//        "|(;+\\s*[\n]))\\s*[\n]";

   public static void main(String[] args) {

/*
       Sentence sentence1 = new Sentence();
       Sentence sentence2 = new Sentence();
       Sentence sentence3 = new Sentence();
       Sentence sentence4 = sentence1;

       Word word1 = new Word();
       word1.setWord("Test1");
       Word word2 = new Word();
       word2.setWord("Test2");
       Word word3 = new Word();
       word3.setWord("Test1");

       try {
           sentence1.addElement(word1);
           sentence2.addElement(word2);
           sentence3.addElement(word3);

       } catch (MismatchTypesException e) {
           e.printStackTrace();
       }

      *//*  System.out.println(word1.equals(word3));
        System.out.println(sentence1.equals(sentence2));
        System.out.println(sentence1.equals(sentence3));
        System.out.println(sentence1.equals(sentence4));
*//*


       Map<Sentence, Integer> hashmap = new HashMap<>();

       hashmap.put(sentence1, 2);
       hashmap.put(sentence2, 3);
       hashmap.put(sentence3, 1);*/


       Word word1 = new Word();
       word1.setWord("Test1");
       Word word2 = new Word();
       word2.setWord("Test2");
       Word word3 = new Word();
       word3.setWord("Test1");
       Word word4 = new Word();
       word3.setWord("Test2");
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

       System.out.println(sentence1.equals(sentence2));

   }
}
