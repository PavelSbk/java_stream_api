package org.stream_api.practise.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapP {

    public static void main(String[] args) {
        /**
         * Дан двумерный массив Integer[][] arr = {{1,2}, {3,4}, {5, 6}, {7}};
         * Необходимо записать его в List<Integer> и вывести на печать одной строкой
         */
        Integer[][] arr = {{1, 2}, {3, 4}, {5, 6}, {7}};
        List<Integer> integerList = Arrays.stream(arr).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(integerList);
        /**
         * Дан двумерный массив Character[][] cArr = {{'a', 'r'}, {'r', 'a'}, {'y', ' '}, {'c', 'h'}};
         * Необходимо записать его в List<Character> и вывести на печать одной строкой
         */
        Character[][] cArr = {{'a', 'r'}, {'r', 'a'}, {'y', ' '}, {'c', 'h'}};
        List<Character> characterList = Stream.of(cArr).flatMap(Stream::of).collect(Collectors.toList());
        System.out.println(characterList);
    }
}

