package org.stream_api.theory.generics;

import java.util.ArrayList;
import java.util.List;

public class WildCard {

    public static void main(String[] args) {
        List<? extends Number> list = new ArrayList<Integer>(); // ограничение
        List<Double> list1 = List.of(3.14, 3.0);
        showListInfo(list1);
        List<String> list2 = List.of("Hi", "Go");
        List<Integer> list3 = List.of(1, 2, 4);
        showListInfo(list2);
        System.out.println(sum(list1));
        System.out.println(sum(list3));
    }

    static void showListInfo(List<?> list) {
        System.out.println("List " + list);
    }

    public static double sum(List<? extends Number> numbers) {
        double summ = 0;
        for (Number n : numbers) {
            summ += n.doubleValue();
        }
        return summ;
    }
}
