package org.stream_api.theory.nested_classes.local_inner;

/**
 * Локальные Inner классы крайне редки. Они создаются внутри методов или конструкторов.
 * <p>
 * Из него видны:
 * — все (даже private) свойства и методы OuterClass обычные и статические.
 * — public и protected свойства и методы родителя OuterClass обычные и статические.
 * То есть те, которые видны в OuterClass.
 * <p>
 * Его видно:
 * — только в том методе где он определён.
 * <p>
 * Может наследовать:
 * — обычные классы.
 * — внутренние классы в OuterClass и его предках.
 * — такие же локальные классы определённые в том же методе.
 * <p>
 * Может быть наследован:
 * — таким же локальным классом определённом в том же методе.
 * <p>
 * Может имплементировать интерфейс
 * <p>
 * Может содержать:
 * — только обычные свойства и методы (не статические).
 */

public class ExOne {

    public static void main(String[] args) {
        Math m = new Math();
        m.getResult(35, 4);
    }
}

class Math {

    public void getResult(int divider, int dividend) {
        // int dividend = 21; // должна быть effectively final
        class Division {

//            private int dividend;
//
//            private int divider;

//            public int getDividend() {
//                return dividend;
//            }
//
//            public void setDividend(int dividend) {
//                this.dividend = dividend;
//            }
//
//            public int getB() {
//                return divider;
//            }
//
//            public void setB(int b) {
//                this.divider = b;
//            }

            public int getDiv() {
                return dividend / divider;
            }

            public int divRem() {
                return dividend % divider;
            }
        }
        Division div = new Division();
        System.out.println(div.getDiv() + " " + div.divRem());
    }
}
