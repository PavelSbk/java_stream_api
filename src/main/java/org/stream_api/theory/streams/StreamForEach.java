package org.stream_api.theory.streams;

import java.util.Arrays;

/**
 * FOR EACH
 * Терминальные метод - после его выполнения стрим завершается
 *
 * void forEach - применит функцию ко всем элементам, но порядок выполнения гарантировать не может
 * >>> set.stream().forEach((p) -> p.append("_2"))
 */

public class StreamForEach {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 78, 77, 88, 81};
        Arrays.stream(arr).forEach(e -> System.out.println(e * 2));
    }
}
