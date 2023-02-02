package org.stream_api.theory.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Java Generics — это одно из самых значительных изменений за всю историю языка Java.
 * «Дженерики», доступные с Java 5, сделали использование Java Collection Framework проще, удобнее и безопаснее.
 * Ошибки, связанные с некорректным использованием типов, теперь обнаруживаются на этапе компиляции.
 */

public class GenericsT {

    public static void main(String[] args) {
        /**
         * Коллекция List не параметризована (raw type), в неё можно добавлять элементы любого класса и типа
         * Такая реализация крайне не желательна из-за не стабильности работы
         */
        List rawList = new ArrayList();
        rawList.add("Hello");
        rawList.add(1);
        rawList.add(new Example());
        rawList.forEach(System.out::println);
        /**
         * Правильное создание с параметризацией типа, обеспечивающие type safe & reusable code
         */
        List<String> list = new ArrayList<>();
    }
}

class Example {
}
