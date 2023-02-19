package org.stream_api.practise.streams;

import java.util.Arrays;
import java.util.List;

/**
 * regular expression in JDK19 documentation:
 * https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/util/regex/Pattern.html#sum
 */

public class LongWordsCount {

    private static List<String> splitStringByWords(String string) {
        return Arrays.asList(string.split("\\PL+"));
    }

    public static int longWordsCounter(String string) {
        List<String> words = splitStringByWords(string);
        return (int) words.stream().
                filter(w -> w.length() >= 9).count();
    }

    public static void main(String[] args) {
        String words = "Требуется подсчитать все длинные слова в данной строке, "
                + "длинным слово считается слово - длина которого больше"
                + ", либо равно 9";
        System.out.println(longWordsCounter(words));
    }
}
