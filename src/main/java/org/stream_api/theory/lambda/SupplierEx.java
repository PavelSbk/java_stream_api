package org.stream_api.theory.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/** SUPPLIER
 * @FunctionalInterface
 * public interface Supplier<T> {
 *     T get();
 * }
 *
 * IntSupplier int getAsInt();
 * DoubleSupplier double getAsDouble();
 * LongSupplier long getAsLong();
 * BooleanSupplier boolean getAsBoolean();
 *
 * Supplier — это простой интерфейс, указывающий,
 * что данная реализация является поставщиком какого то результа.
 * Этот интерфейс, однако, не накладывает никаких дополнительных ограничений,
 * которые реализация поставщика должна возвращать при каждом новом получении результата.
 *
 * У поставщика есть только один метод get() и нет никаких других методов по умолчанию или статических методов.
 *
 * Интерфейс поставщик имеет свои примитивные варианты,
 * такие как IntSupplier, DoubleSupplier и т. д., как показано ниже.
 * !!!ВНИМАНИЕ!!! имя метода — get() используется для универсального интерфейса поставщика.
 * Однако для примитивных вариантов этот метод соответствует примитивному типу.
 *
 * Одно из основных применений этого интерфейса это использование для включения отложенного выполнения.
 * Это означает отсрочку выполнения до тех пор, пока оно не понадобится.
 */

public class SupplierEx {

    /**
     * Метод создаёт объект Car, помещает в ArrayList и выводит на печать
     */
    public static List<Car> createThreeCar(Supplier<Car> carSupplier) {
        List<Car> cars = new ArrayList<>();
            cars.add(carSupplier.get());
        return cars;
    }

    public static void main(String[] args) {
        List<Car> cars = createThreeCar(() -> new Car("Volvo", "Black", 2.4));
        cars.forEach(System.out::println);
        System.out.println("==== Random Integer ====");
        Supplier<Integer> sup1 = SupplierEx::getRandomInt;
        Supplier<Integer> sup2 = () -> (int) (Math.random() * 10);
        System.out.println(sup1.get());
        System.out.println(sup2.get());
        /**
         * Самая частая реализация Supplier - это ленивое создание объекта,
         * т.е. объект создаётся только при вызове метода get() в реализации интерфейса Supplier.
         * Если метод не вызывается - объект не создаётся, так как реализация интерфейса Supplier
         * хранит только ссылку на конструктор.
         */
        System.out.println("==== Created empty List ====");
        Supplier<List<String>> supplier = ArrayList::new;
        List<String> list = supplier.get();
        System.out.println(list);
    }

    public static Integer getRandomInt() {
        return (int) (Math.random() * 10);
    }
}

class Car {

    String model;

    String color;

    double engine;

    public Car(String model, String color, double engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car {"
                +
                "model = '" + model + '\''
                +
                ", color = '" + color + '\''
                +
                ", engine = " + engine
                +
                '}';
    }
}