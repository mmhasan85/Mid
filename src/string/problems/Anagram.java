package string.problems;

/**
 * Created by mrahman on 04/22/17.
 */
public class Anagram {

    public static void main(String[] args) {
        //Write a Java Program to check if the two String are Anagram. Two String are called Anagram when there is
        //same character but in different order.For example,"CAT" and "ACT", "ARMY" and "MARY".


        String str1 = "CAB";
        String str2 = "ABC";
        System.out.println("Anagram?? :"+isAnagram(str1, str2));}

    private static boolean isAnagram(String a, String b) {

        int[] counts = new int[26];  // 0,0,0,0,0
        char[] aArr = a.toLowerCase().toCharArray();
        char[] bArr = b.toLowerCase().toCharArray();
        for (int i = 0; i < aArr.length; i++)
        {
            counts[aArr[i] - 97]++;
            counts[bArr[i] - 97]--;
        }


        for (int i = 0; i < 26; i++)
        {
            if (counts[i] != 0)
            {
                return false;
            }
        }
        return true;
    }
}
