package ro.mirodone;
import java.util.Arrays;
import java.util.Comparator;

public class HighestScoringWord {

    public  String high(String s) {

        String[] words = s.split(" ");
        int max = 0;
        String sToReturn = null;
        for (String word : words) {
            char[] tempWordChars = word.toCharArray();
            int total = 0;
            for (int j = 0; j < tempWordChars.length; j++) {
                total = total + (int) tempWordChars[j];
            }
            if (total > max) {
                sToReturn = word;
                max=total;
            }

        }
        return sToReturn;

    }


    private final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String high3(String s)  {
        int high = Integer.MIN_VALUE;
        String result = "";
        for (String item : s.split(" ")) {
            int sum = Arrays.stream(item.split("")).mapToInt(x -> ALPHABET.indexOf(x)+1).sum();
            if(high < sum) {
                high = sum;
                result = item;
            }
        }
        return result;
    }

    public static String high4(String s) {
        return Arrays.stream(s.split(" "))
                .max(Comparator.comparingInt(
                        a -> a.chars().map(i -> i - 96).sum()
                )).get();
    }

}
