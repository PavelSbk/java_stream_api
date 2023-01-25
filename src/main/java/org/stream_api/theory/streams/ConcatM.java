package org.stream_api.theory.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
 *
 * Этот метод нельзя использовать в цепочке стрима
 *
 * Creates a lazily concatenated stream whose elements
 * are all the elements of the first stream followed by all the elements of the second stream.
 */

public class ConcatM {

    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        Stream<Integer> stream2 = Stream.of(4, 5, 6);
        Stream<Integer> stream3 = Stream.concat(stream1, stream2);
        stream3.forEach(System.out::println);
    }
}
