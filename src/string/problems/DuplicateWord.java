package string.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrahman on 04/22/17.
 */
public class DuplicateWord {

    public static void main(String[] args) {
        /*
         * Write a java program to find the duplicate words and their number of occurrences in the string.
         * Also Find the average length of the words.
         */

        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";

        String[] words = st.split(" ");


        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        Integer wordCount = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toUpperCase();

            if (wordMap.get(word) == null) {
                wordMap.put(word, wordCount);
            } else {
                System.out.println("Duplicated/Repeated word: " + word);

                wordMap.replace(word, wordMap.get(word) + 1);
                System.out.println("Number of occurrence: " + wordMap.get(word));
            }
        }
        int sum = 0, count = 0;
        for (String str : wordMap.keySet()) {

            if (wordMap.get(str) > 0) {
                sum += str.length();
                count++;
            }

        }
        System.out.println("Average: " + sum / count);



    }

}
