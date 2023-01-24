package org.stream_api.theory.streams;


import java.util.*;
import java.util.stream.Collectors;

/**
 * MAP
 * Stream API – по сути это поток данных и последовательные операции над ними
 * <p>
 * map()
 * map(Function<? super T,? extends R> mapper)
 * Returns a stream consisting of the results of applying
 * the given function to the elements of this stream.
 * <p>
 * Map - берёт по очереди каждый элемент из потока и сопоставляет ему элемент,
 * который получатся после применения на нём действий, описанных внутри map()
 */

public class MapM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "Aaaa",
                "Bb",
                "Ccc",
                "D"
        ));
        /**
         * Вывести на печать длины строк
         * на list вызвать поток stream(), далее с помощью метода l -> l.length()
         * l - каждый вошедший элемент list.stream()
         * -> l.length() на выходе преобразуется в его длину
         */
        list.stream()
                .map(l -> l.length()).forEach(System.out::println);
        /**
         * Записать в новый лист интов длины строк
         * map - берёт из потока элемент класса String и c помощью ссылки на метод ::
         * вызывается метод length (:: - это Method References введённый в Java 8 или 1.8)
         * toList - это временный накопитель, который аккумулирует в себе элементы потока
         * далее накопитель класса List<T> будет передан обратно для записи в переменную
         */
        System.out.println("====================");
        List<Integer> listOfLength = list.stream()
                .map(String::length)
                .toList();
        listOfLength.forEach(System.out::println);
        /**
         * Создать массив случайных интов и с помошью стрима преобразовать и вывести на печать его так, чтобы:
         * - если число на цело делится на 3, то его нужно разделить на 3
         * - если число на цело не делится на 3, то заменить его на 0
         */
        System.out.println("====================");
        int[] array = {5, 6, 9, 3, 8, 1};
        Arrays.stream(array).map(i -> i % 3 == 0 ? i / 3 : 0).forEach(System.out::println);
        /**
         * преобразовать полученные данные в ArrayList
         */
        System.out.println("====================");
        Arrays.stream(array).map(i -> i % 3 == 0 ? i / 3 : 0).toArray();
        System.out.println(Arrays.toString(array));
        System.out.println("====================");
        Set<String> set = new TreeSet<>(Set.of(
                "Aaaa",
                "Bb",
                "Ccc",
                "D"
        ));
        set.forEach(System.out::println);
        System.out.println("====================");
        Set<Integer> setInt = set.stream().map(String::length).collect(Collectors.toSet());
        setInt.forEach(System.out::println);
    }
}
