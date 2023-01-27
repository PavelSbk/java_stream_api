package org.stream_api.theory.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Returns a Collector implementing a cascaded "group by" operation on input elements of type T,
 * grouping elements according to a classification function,
 * and then performing a reduction operation on the values associated with a given key using
 * the specified downstream Collector. The Map produced by the Collector is created with the supplied factory function.
 * The classification function maps elements to some key type K.
 * The downstream collector operates on elements of type T and produces a result of type D.
 * The resulting collector produces a Map<K, D>.
 * For example, to compute the set of last names of people in each city, where the city names are sorted:
 * <p>
 * Map<City, Set<String>> namesByCity = people
 * .stream()
 * .collect(groupingBy(Person::getCity,TreeMap::new,mapping(Person::getLastName,toSet())));
 * <p>
 * Params:
 * classifier – a classifier function mapping input elements to keys
 * mapFactory – a supplier providing a new empty Map into which the results will be inserted
 * downstream – a Collector implementing the downstream reduction
 * Returns:
 * a Collector implementing the cascaded group-by operation
 */

public class GroupingBy {

    public static void main(String[] args) {
        var workers = Arrays.asList(
                new Worker("Ivan", 35, 100000, "Boss"),
                new Worker("Vasily", 25, 55000, "Office"),
                new Worker("Dmitry", 27, 65000, "Worker"),
                new Worker("Stepan", 28, 75000, "Office"),
                new Worker("Petr", 35, 85000, "Worker")
        );
        /**
         * Сгруппировать список рабочих
         */
        workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition))
                .forEach((k, v) -> {
                    System.out.println(k);
                    v.forEach(System.out::println);
                });
        System.out.println("=================");
        workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.toSet()))
                .forEach((k, v) -> {
                    System.out.println(k);
                    v.forEach(System.out::println);
                });
        System.out.println("=================");
        workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.counting()))
                .forEach((k, v) -> {
                    System.out.println(k);
                    System.out.println(v);
                });
        System.out.println("=== Группировка списка рабочих по их должности (только имена) ===");
        workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.mapping(Worker::getName, Collectors.toSet())))
                .forEach((k, v) -> {
                    System.out.println(k + ":");
                    v.forEach(System.out::println);
                });
        System.out.println("=== Расчет средней зарплаты для данной должности ===");
        workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.averagingInt(Worker::getSalary)))
                .forEach((k, v) -> {
                    System.out.println(k);
                    System.out.println(v);
                });
        System.out.println("=== Группировка списка рабочих по их должности и по возрасту ===");
        workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.groupingBy(Worker::getAge)))
                .forEach((k, v) -> {
                    System.out.println(k);
                    v.forEach((k2, v2) -> {
                        System.out.println(k2);
                        System.out.println(v2);
                    });
                });
    }
}

class Worker {
    private String name;
    private int age;
    private int salary;
    private String position;

    public Worker(String name, int age, int salary, String position) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Worker {"
                + "name = '" + name + '\''
                + ", age = " + age
                + ", salary = " + salary
                + ", position = '" + position + '\''
                + '}';
    }
}
