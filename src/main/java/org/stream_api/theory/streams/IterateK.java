package org.stream_api.theory.streams;

import java.util.stream.Stream;

/**
 * Stream.iterate создаёт значения потока по требованию, так называемый бесконечный поток.
 * <p>
 * stream.iterate был улучшен в Java 9. Он поддерживает предикат (условие) в качестве второго аргумента,
 * и stream.iterate остановится, если предикат будет ложным
 */

public class IterateK {

    public static void main(String[] args) {
        /**
         * Stream.iterate(initial value, следующее значение)
         */
        Stream.iterate(0, n -> n + 1)
                .limit(10)
                .forEach(x -> System.out.println(x));
        /**
         * Только нечётные числа
         */
        Stream.iterate(0, n -> n + 1)
                .filter(x -> x % 2 != 0)
                .limit(10)
                .forEach(x -> System.out.println(x));
        /**
         * Числа Фибоначчи
         */

        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(20)
                .map(n -> n[0])
                .forEach(x -> System.out.println(x));
        /**
         * Остановить итерацию потока, если n >= 20
         * Аналогично:
         * for (int i = 1; i <= 20; i *= 2)
         */
        Stream.iterate(1, n -> n < 20, n -> n * 2)
                .forEach(x -> System.out.println(x));

        for (int i = 1; i <= 20; i *= 2) {
            System.out.println(i);
        }
    }
}
