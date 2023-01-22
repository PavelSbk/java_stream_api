package org.stream_api.theory.nested_classes.static_nested;

/**
 * Из него (самого класса) видны:
 * — статические свойства и методы OuterClassа (даже private).
 * — статические свойства и методы родителя OuterClassа public и protected.
 * То есть те, которые видны в OuterClassе.
 *
 * Из его экземпляра видны:
 * — все (даже private) свойства и методы OuterClassа обычные и статические.
 * — public и protected свойства и методы родителя OuterClassа обычные и статические.
 * То есть те, которые видны в OuterClassе.
 *
 * Его видно:
 * — согласно модификатору доступа.
 *
 * Может наследовать:
 * — обычные классы.
 * — такие же статические внутренние классы в OuterClassе и его предках.
 *
 * Может быть наследован:
 * — любым классом:
 * — вложенным
 * — не вложенным
 * — статическим
 * — не статическим!
 *
 * Может имплементировать интерфейс
 *
 * Может содержать:
 * — статические свойства и методы.
 * — не статические свойства и методы.
 *
 * Внутри класса можно создать:
 * - класс
 * - интерфейс
 * Внутри интерфейса можно создать:
 * - класс
 * - интерфейс
 *
 * static nested class - очень похож на обычный внешний класс, но находится внутри другого класса
 *
 * Создание static nested clas:
 *  Car.CarEngine engine = new Car.CarEngine(256);
 *  При создании static nested class нужно указывать и класс, содержащий его.
 *
 * Static nested class может содержать static и non-static элементы.
 *
 * Внутри static nested class можно обращаться только к static полям, даже private
 *
 * Внешний класс может обращаться даже к private элементам static nested class
 */

public class Car {

    String color;

    int doorCount;

    CarEngine engine;
    /**
     * Статические поля являются общими для всего класса.
     * Поэтому они могут использоваться без создания объектов класса.
     */
    private static int a;

    public Car(String color, int doorCount, CarEngine engine) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
    }

    void countOfEngines() {
        /**
         * Внешний класс может обращаться даже к private элементам static nested class
         */
        System.out.println(CarEngine.engineCreateCounter);
    }

    /**
     * Обращение к private методам вложенного класса
     */
    void horsePowerOfEngine() {
        CarEngine carEngine = new CarEngine(123);
        System.out.println(engine.horsePower);
    }

    @Override
    public String toString() {
        return "My car: {"
                +
                "color = '" + color + '\''
                +
                ", doorCount = " + doorCount
                +
                ", engine = " + engine
                +
                '}';
    }

    public static class CarEngine {

        private int horsePower;
        static int engineCreateCounter;

        public CarEngine(int horsePower) {
            this.horsePower = horsePower;
            engineCreateCounter++;
            /**
             * Внутри static nested class можно обращаться только к static полям, даже private
             */
            System.out.println(a);
        }

        @Override
        public String toString() {
            return "My engine: {"
                    +
                    "horsePower = " + horsePower
                    +
                    '}';
        }
    }
}

class Test {

    public static void main(String[] args) {
        Car.CarEngine engine = new Car.CarEngine(256);
        System.out.println(engine);
        Car car = new Car("Red", 3, engine);
        System.out.println(car);
    }
}
