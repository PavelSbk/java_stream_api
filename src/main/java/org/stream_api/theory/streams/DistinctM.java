package org.stream_api.theory.streams;

import org.stream_api.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * DISTINCT
 * distinct	- найдет и уберет элементы, которые повторяются; вернет элементы без повторов
 * >>> collection.stream().distinct().collect(Collectors.toList())
 * <p>
 * Метод проверяет элементы с помощью метода equals
 */

public class DistinctM {

    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 2);
        Stream<Integer> stream2 = Stream.of(4, 5, 6, 5);
        Stream<Integer> stream3 = Stream.concat(stream1, stream2);
        stream3.distinct().forEach(System.out::println);
        System.out.println("==============");
        String[] arr = {"s", "i", "l", "l", "y"};
        Arrays.stream(arr).distinct().forEach(System.out::println);
        System.out.println("==============");
        List<Student> students = new ArrayList<>(new Student().createListOfStudents());
        students.add(new Student("Ivan", "Kozlov", 'M', 22, 3, 8.3));
        students.stream().distinct().sorted(Comparator.comparing(Student::getName)).forEach(System.out::println);
    }
}
