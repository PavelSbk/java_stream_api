package org.stream_api.theory.nested_classes.local_inner;

public class ExTwo {

    public static void main(String[] args) {
        class Sum implements Math2{

            @Override
            public int doOperation(int a, int b) {
                return a + b;
            }
        }

        Sum sum = new Sum();
        System.out.println(sum.doOperation(5, 3));
    }
}

interface Math2 {

    int doOperation(int a, int b);
}
