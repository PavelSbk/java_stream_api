package org.stream_api.theory.generics;

public class ParameterizedClassT {

    public static void main(String[] args) {
        Info<String> info = new Info<>("Hello");
        System.out.println(info);
        var intInfo = new Info<>(666);
        System.out.println(intInfo);
        String s = String.valueOf(intInfo);
        System.out.println(s);

        Pair<String, Integer> pair = new Pair<>("key", 1);
        System.out.println(pair);
    }
}

/**
 * @param <T> - это любой тип (Type place holder)
 */

class Info<T> {

    private T value;//не может быть static так как тогда она принадлежала бы классу, а не объекту (т.е. общая для всех)

    public Info(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return ">>> " + value + " <<<";
    }
}

class Pair<V1, V2> {

    private V1 value1;

    private V2 value2;

    public Pair(V1 value1, V2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return ">>> " + value1 +
                " : " + value2 + " <<<";
    }
}
