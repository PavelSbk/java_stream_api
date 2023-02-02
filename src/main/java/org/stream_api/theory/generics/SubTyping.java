package org.stream_api.theory.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubTyping {

    public static void main(String[] args) {
        X x = new Y();
        List<X> list = new ArrayList<>();
        /**
         * List<X> list = new ArrayList<>();
         *
         * List<X> list = new ArrayList<Y>(); - нельзя создать
         */
        List<Number> listN = new ArrayList<>();
        /**
         * List<Number> listN = new ArrayList<>();
         *
         * List<Number> listN = new ArrayList<Integer>(); - нельзя создать
         */
        List<W> listW = List.of(new W<>(1.5));

        /**
         * List<W> listW = List.of(new W<>(1));
         * List<W> listW = List.of(new W<>(1.5));
         *
         * List<W> listW = List.of(new W<>("S")); - нельзя создать, так как class W<T extends Number>
         */
    }
}

class X {

}

class Y extends X {

}

class W<T extends Number> {

    private T value;

    public W(T value) {
        this.value = value;
    }
}

