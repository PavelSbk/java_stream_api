package org.stream_api.theory.streams;

import java.util.ArrayList;
import java.util.List;

/**
 * Метод должен вернуть первое нечётное число или null
 */

public class OrElseConstruct {

    public static Integer returnFirstOdd(List<Integer> integers) {
        return integers.stream().filter(i -> i % 2 == 0).findFirst().orElse(null);
    }

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(List.of(1, 3, 5));
        System.out.println(returnFirstOdd(integers));
    }
}


