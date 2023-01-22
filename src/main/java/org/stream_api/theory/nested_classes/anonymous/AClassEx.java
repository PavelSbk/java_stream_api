package org.stream_api.theory.nested_classes.anonymous;

/**
 * Анонимные классы не имеют имени - следовательно нельзя создать их конструктор
 *
 * Важно! Lambda expressions - это краткая форма написания анонимных классов
 *
 * Из него видны:
 * — все (даже private) свойства и методы OuterClass обычные и статические.
 * — public и protected свойства и методы родителя OuterClass обычные и статические.
 * То есть те, которые видны в OuterClass.
 *
 * Его видно:
 * — только в том методе где он определён.
 *
 * Не может быть наследован
 *
 * Может содержать:
 * — только обычные свойства и методы (не статические).
 */

public class AClassEx {

    public static void main(String[] args) {

        Math2 sum = new Math2() {
            @Override
            public int doOperation(int a, int b) {
                return a + b;
            }
        };
        System.out.println(sum.doOperation(2, 2));
        Math2 div = new Math2() {
            @Override
            public int doOperation(int a, int b) {
                return a / b;
            }
        };
        System.out.println(div.doOperation(35, 5));
    }
}

interface Math2 {

    int doOperation(int a, int b);
}
