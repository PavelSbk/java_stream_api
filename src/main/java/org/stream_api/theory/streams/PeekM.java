package org.stream_api.theory.streams;

import java.util.Arrays;
import java.util.Comparator;

/**
 * PEEK
 * Метод peek(), так же как и forEach() принимает в параметр Consumer FI, но возвращает Stream
 * <p>
 * Чаще всего он используется, для просмотра этапов method chaining для отладки
 * <p>
 * peek	- выполнить действие над каждым элементом элементов, вернет стрим с исходными элементами
 * > collection.stream()
 * .map(String::toLowerCase).peek((e) -> System.out.print("," + e))
 * .collect(Collectors.toList())
 */

public class PeekM {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 5, 6, 2, 5, 1};
        Arrays.stream(arr).distinct()
                .peek(e -> System.out.println(e + "Уникальный элемент"))
                .filter(i -> i % 2 == 0)
                .peek(e -> System.out.println(e + "Чётный элемент"))
                .map(i -> i / 2)
                .peek(e -> System.out.println(e + "Элемент поделён на 2"))
                .forEach(System.out::println);
    }
}
