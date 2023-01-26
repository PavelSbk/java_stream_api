package org.stream_api.theory;

import java.util.Objects;
import java.util.Optional;

/**
 * Класс Optional появился в Java 8.
 * Задачей этого класса является предоставление решений на уровне типа-обертки
 * для обеспечения удобства обработки возможных null-значений.
 * По сути является контейнером в котором находится ссылка или null.
 * Optional позволяет сократить код, за счёт избавления от проверок на null
 *
 * Концепция Optional состоит в том, что работа происходит с полями,
 * в которых, заранее не известно, есть объект или нет (object or null).
 *
 */

public class OptionalEx {

    public static void main(String[] args) {
        /**
         * Cоздание Optional.empty():
         * Optional + . + ctrl+alt+v
         */
        Optional<String> empty = Optional.empty();
        System.out.println(empty);
        /**
         * boolean isPresent() - вернёт true если значение есть
         */
        System.out.println(empty.isPresent()); // false
        /**
         * boolean isEmpty() - вернёт true если внутри есть значение
         */
        System.out.println(empty.isEmpty()); // true
        /**
         * <T> Optional<T> of(T value) - принимает значения в фабричный метод
         *        return new Optional<>(Objects.requireNonNull(value));
         * !! Важно, что requireNonNull при передачи в него null выкинет NPE !!
         * Для работы с null:
         * Optional.ofNullable()
         */
        System.out.println("================");
        Optional<String> optionalS = Optional.of("Hello");
        System.out.println(optionalS.isPresent()); // true
        System.out.println(optionalS.isEmpty()); // false
        Optional<String> optionalOfN = Optional.ofNullable(null);
        System.out.println(optionalOfN.isPresent()); // false
        System.out.println(optionalOfN.isEmpty()); // true
        /**
         * T orElse(T other) - вернёт other, если внутри был null
         *         return value != null ? value : other;
         */
        System.out.println("================");
        System.out.println(empty.isEmpty());
        String s = empty.orElse("World!");
        System.out.println(s);
        System.out.println("================");
        /**
         * Применение для упрощения кода:
         */
        String hello1 = null;
        String world;
        if (hello1 != null) {
            world = "World!";
            System.out.println(hello1 + " " + world);
        }
        Optional<String> hello = Optional.ofNullable("Hello");
        /**
         * Если hello != null - то совершается логика .map(String::toUpperCase)
         * Если hello == null - то совершается логика orElseGet(() -> {
         *                                                   // todo
         *                                                  return "world!";
         *                                              });
         */
        String orElse = hello
                .map(String::toUpperCase)
                .orElse("world!");
        System.out.println(orElse);
        /**
         * ifPresent()
         */
        System.out.println("================");
        hello.ifPresent(System.out::println);
        System.out.println("================");
        Optional<String> noHello = Optional.ofNullable(null);
        noHello.ifPresentOrElse(System.out::println, () -> System.out.println("null is inside"));
        /**
         * Объект Person описан двумя полями:
         * String name и String email, при этом достоверно известно, что String name есть всегда,
         * а String email может не быть и при инициализации может быть передан null
         *
         * Person person2 = new Person("Maria", null);
         * person2.getEmail().toUpperCase() - при обработке null с помощью метода toUpperCase() -
         * вылетит NullPointerException
         * Чтобы избежать подобной ситуации, необходимо доработать методы, возвращающие null,
         * в данном случае гетер поля String email
         * public Optional<String> getEmail() {
         *         return Optional.ofNullable(email);
         *     }
         * При вызове person2.getEmail() - будет возвращаться значение Optional,
         * что обязывает работать с этим объектом как с Optional
         */
        System.out.println("================");
        Person person1 = new Person("Ivan", "ivan666@mail.com");
        Person person2 = new Person("Maria", null);
        System.out.println(person1.getEmail()
                .map(String::toUpperCase)
                .orElse("person has not e-mail"));
        System.out.println(person2.getEmail()
                .map(String::toUpperCase)
                .orElse("person has not e-mail"));
    }
}

class Person{

    private final String name;
    private final String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}
