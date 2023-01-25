package org.stream_api.theory.streams;

/** PEEK
 * Метод peek(), так же как и forEach() принимает в параметр Consumer FI, но возвращает Stream
 *
 * Чаще всего он используется, для просмотра этапов method chaining для отладки
 *
 * peek	- выполнить действие над каждым элементом элементов, вернет стрим с исходными элементами
 * > collection.stream()
 *  .map(String::toLowerCase).peek((e) -> System.out.print("," + e))
 *  .collect(Collectors.toList())
 */

public class PeekM {

    public static void main(String[] args) {

    }
}
