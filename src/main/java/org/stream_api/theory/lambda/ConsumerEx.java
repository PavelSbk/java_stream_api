package org.stream_api.theory.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * public interface Consumer<T> {
 * <p>
 * void accept(T t);
 * <p>
 * default Consumer<T> andThen(Consumer<? super T> after) {
 * Objects.requireNonNull(after);
 * return (T t) -> { accept(t); after.accept(t);};
 * }
 * <p>
 * Consumer — это функциональный интерфейс, который принимает один параметр на вход
 * и не возвращает никаких выходных данных.
 * <p>
 * На языке непрофессионала, как следует из названия, реализация этого интерфейса потребляет вводимые данные.
 * Пользовательский интерфейс имеет два метода:
 * - void accept(T t);
 * - default Consumer<T> andThen(Consumer<? super T> after);
 * Метод accept является единым абстрактным методом (SAM), который принимает один аргумент типа T.
 * Тогда как другой метод andThen является методом по умолчанию и используется для композиции.
 * Интерфейс Consumer имеет специфические типы реализаций для типов integer,
 * double и long -> IntConsumer, DoubleConsumer и LongConsumer
 */

public class ConsumerEx {

    /**
     * Что именно делает метод с объектом Car, будет задано внутри самого метода
     */

    public static void changeCar(Car car, Consumer<Car> carConsumer) {
        carConsumer.accept(car);
    }

    public static void main(String[] args) {
        System.out.println("=== New car list ===");
        List<Car> cars = new ArrayList<>(List.of(
                new Car("Toyota", "Black", 1.2),
                new Car("Volvo", "Red", 2.4),
                new Car("Lada", "Blue", 1.6)));
        cars.forEach(System.out::println);
        System.out.println("=== Upgrade Toyota ===");
        changeCar(cars.get(0), car -> {
            car.color = "White";
            car.engine = 2.6;
            System.out.println("Car " + car + " just upgraded");
        });
    }
}

