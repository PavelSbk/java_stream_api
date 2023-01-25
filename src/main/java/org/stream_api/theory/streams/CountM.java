package org.stream_api.theory.streams;

import java.util.stream.Stream;

/** COUNT
 *
 * count - посчитает и выведет long, сколько элементов, соответствующих условию
 * >>> collection.stream().filter("f5"::equals).count()
 *
 */

public class CountM {

    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 2);
        Stream<Integer> stream2 = Stream.of(4, 5, 6, 5);
        Stream<Integer> stream3 = Stream.concat(stream1, stream2);
        long counter = stream3.filter(i -> i > 4).count();
        System.out.println(counter);
    }
}
