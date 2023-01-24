package org.stream_api.theory.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * REDUCE (аккумулятор)
 * <p>
 * Метод reduce выполняет терминальные операции сведения,
 * возвращая некоторое значение - результат операции. Он имеет следующие формы:
 * <p>
 * Optional<T> reduce(BinaryOperator<T> accumulator) - Объект BinaryOperator<T> представляет функцию,
 * которая принимает два элемента и выполняет над ними некоторую операцию, возвращая результат.
 * <p>
 * T reduce(T identity, BinaryOperator<T> accumulator) -
 * T identity - элемент, который предоставляет начальное значение для функции из второго параметра,
 * а также предоставляет значение по умолчанию, если поток не имеет элементов.
 * BinaryOperator<T> accumulator, как и первая форма метода reduce,
 * представляет ассоциативную функцию, которая запускается для каждого элемента в потоке и принимает два параметра.
 * Первый параметр представляяет промежуточный результат функции, а второй параметр - следующий элемент в потоке.
 *
 * <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
 */
public class ReduceM {

    public static void main(String[] args) {
        /**
         * Найти произведение всех элементов массива
         */
        List<Integer> list = new ArrayList<>(List.of(5, 6, 9, 3, 8));
        int rsl = list.stream().reduce((a, e) -> a * e).get();
        /** (a, e) -> a * e - подробно
         * а - аккумулятор;
         * е - элемент потока;
         * аккумулятор один для всех элементов потока, его задача накапливать результаты работы функции
         * при завершении потоков, метод get() - преобразует Optional в Integer и возвращает аккумулятор,
         * размещая его в переменной rsl.
         *
         * Optional - оборачивает примитивное значение для провверки на null
         *
         * a = 5  30 270 810 6480 get()
         * e = 5  6   9   3   8
         */
        System.out.println(rsl);

    }
}
