package org.stream_api.theory.nested_classes.inner;

/**
 * Inner class - это нестатический вложенный класс и всегда жестко связан со своим внешним классом
 *
 * В создании Inner class всегда задействован объект внешнего класса
 *
 * В Inner class всегда содержатся только non-static элементы, кроме final констант
 *
 * Inner class может обращаться даже к private элементам внешнего класса
 *
 * Внешний класс может обращаться к private элементам внутреннего класса, только прежде создав его объект
 */

public class Car {

    String color;

    int doorCount;

    Engine engine;

    public Car(String color, int doorCount) {
        this.color = color;
        this.doorCount = doorCount;
    }

    public Car(String color, int doorCount, int horsePower) {
        this.color = color;
        this.doorCount = doorCount;
        /**
         * Car - внешний класс
         * Engine - внутренний класс
         * this - текущий объект класса Car
         * this.new Engine(horsePower); == new Car.Engine(horsePower);
         */
        this.engine = this.new Engine(horsePower);
    }

    /**
     * Внешний класс может обращаться к private элементам внутреннего класса,
     * только прежде создав его объект
     */
    public void engineInfo() {
        Engine engine = new Engine(315, 8);
        System.out.println(engine.cylinderCount);
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
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

    public class Engine {

        private int horsePower;

        private int cylinderCount;

        public Engine(int horsePower) {
            this.horsePower = horsePower;
        }

        public Engine(int horsePower, int cylinderCount) {
            this.horsePower = horsePower;
            this.cylinderCount = cylinderCount;
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
        /**
         * Создание внешнего класса с созданием внутреннего через конструктор внешнего
         */
        Car newCar = new Car("Red", 4, 210);
        System.out.println(newCar);
        /**
         * Создание внешнего класса с добавлением внутреннего через setter
         */
        Car newCar2 = new Car("Black", 3);
        /**
         * newCar2.new Engine(150); - создание
         */
        Car.Engine engine = newCar2.new Engine(150);
        newCar2.setEngine(engine);
        System.out.println(newCar2);
        /**
         * Создание внешнего класса с добавлением внутреннего в конце
         * ВНИМАНИЕ! Переменная будет хранить ссылку ТОЛЬКО на последний созданный объект
         */
        Car.Engine engine1 = new Car("Yellow", 5).new Engine(200);

    }
}
