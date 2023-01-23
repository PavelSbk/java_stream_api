package org.stream_api.theory.lambda;

/**
 * Inter функциональный интерфейс т.к. int i(String s) его единственный метод
 *
 * static void def(Inter inter) - принимает в качестве параметра реализацию функционального интерфейса Inter inter
 * и выводит на экран результат работы метода i над переданной строкой "Hello" ==> inter.i("Hello")
 *
 * В методе main, с помощью lambda expression прописывается логики реализации метода i интерфейса Inter, а именно:
 * - вызывается статический метод def(Inter inter)
 * - в его сигнатуре, с помощью lambda expression описывается логика работы метода:
 *
 * s - String string
 * -> - оператор стрелка, разделяет параметры метода и тело метода так, что справа от оператора стрелка
 * находится тело метода, которое было бы у метода соответствующего класса,
 * имплементировавшего функциональный интерфейс
 * s.length() - return string.length;
 */

interface Inter {

    int i(String s);
}

interface ReturnAny{

    String returnAnything();
}

public class LambdaExTwo {

    static void def(Inter inter) {
        System.out.println(inter.i("Hello"));
    }

    static void def2(ReturnAny returnAny) {
        System.out.println(returnAny.returnAnything());
    }

    public static void main(String[] args) {
        def(s -> s.length());

        System.out.println("== with return ==");
        def2(() -> {
            return "Hello";
        });

        System.out.println("== with anonymous class ==");
        def2(new ReturnAny() {
            @Override
            public String returnAnything() {
                return "World";
            }
        });

        System.out.println("== with short lambda ==");
        def2(() -> "World!");

        System.out.println("== with new object of interface ReturnAny helloWorld ==");
        ReturnAny helloWorld = () -> "Hello World!";
        def2(helloWorld);
    }
}


