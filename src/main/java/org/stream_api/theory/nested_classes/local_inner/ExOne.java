package org.stream_api.theory.nested_classes.local_inner;

/**
 * Локальные Inner классы крайне редки. Они создаются внутри методов или конструкторов.
 *
 * Из него видны:
 * — все (даже private) свойства и методы OuterClass обычные и статические.
 * — public и protected свойства и методы родителя OuterClass обычные и статические.
 * То есть те, которые видны в OuterClass.
 *
 * Его видно:
 * — только в том методе где он определён.
 *
 * Может наследовать:
 * — обычные классы.
 * — внутренние классы в OuterClass и его предках.
 * — такие же локальные классы определённые в том же методе.
 *
 * Может быть наследован:
 * — таким же локальным классом определённом в том же методе.
 *
 * Может имплементировать интерфейс
 *
 * Может содержать:
 * — только обычные свойства и методы (не статические).
 */

public class ExOne {

    public static void main(String[] args) {
        Math m = new Math();
        m.getResult();
    }
}

class Math {

    public void getResult() {
        class Division {
            private int a;
            private int b;

            public int getA() {
                return a;
            }

            public void setA(int a) {
                this.a = a;
            }

            public int getB() {
                return b;
            }

            public void setB(int b) {
                this.b = b;
            }

            public int getDiv() {
                return a / b;
            }

            public int divRem() {
                return a % b;
            }
        }
        Division div = new Division();
        div.setA(21);
        div.setB(4);
        System.out.println(div.getDiv() + " " + div.divRem());
    }
}
