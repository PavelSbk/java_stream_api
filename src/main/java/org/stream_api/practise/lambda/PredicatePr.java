package org.stream_api.practise.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;

public class PredicatePr {

    /**
     * 1.
     * C помощью Predicate<String> реализовать удаление слов из списка строк, начинающихся с определённой буквы.
     */
    public static List<String> removeBy(List<String> list, char ch) {
        list.removeIf(s -> s.toLowerCase().startsWith(String.valueOf(ch).toLowerCase()));
        return list;
    }

    /**
     * 2.
     * Используя Predicate<String> реализовать удаления из списка строк, всех строк, которые начинаются
     * с любой буквы из переданного массива.
     */
    public static List<String> removeByArr(List<String> list, char[] sArray) {
        List<String> rst = new ArrayList<>(list);
        for (Character ch : sArray) {
            rst.removeIf(s -> s.toLowerCase().startsWith(ch.toString().toLowerCase()));
        }
        return rst;
    }


    /**
     * 3.
     * Используя BiPredicate<Integer, String> удалить из Map<Integer, String> все пары,
     * для которых длина строки при ключе не равна ключу.
     * [5 : "Hello"] - оставить, [3 : "World"] - удалить
     */

    public static Map<Integer, String> removeFromMap(Map<Integer, String> map) {
        Map<Integer, String> rst = new HashMap<>(map);
        BiPredicate<Integer, String> predicate = (k, v) -> k != v.length();

        return rst;
    }

    /**
     * 4.
     * Используя IntPredicate создать метод, который вернёт true в случае, когда сумма цифр числа - чётная.
     * 103 - true (1 + 0 + 3), 56 - false
     */

    public static boolean numberCheck(Integer number) {
        IntPredicate intPredicate = i -> i % 2 == 0;
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return intPredicate.test(sum);
    }
}
