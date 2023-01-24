package org.stream_api.theory.streams;

import org.stream_api.model.Student;

import java.util.*;
import java.util.stream.Collectors;

/**
 * SORTED
 * Конвейерный метод:
 * <p>
 * sorted - отсортирует элементы в естественном порядке; можно использовать Comparator
 * >>> collection.stream().sorted().collect(Collectors.toList())
 */

public class SortedM {

    public static void main(String[] args) {
        int[] arr = {1, 5, 111, -1, 12, 6, 98};
        Arrays.stream(arr).sorted().forEach(System.out::println);
        System.out.println("==============");
        List<Student> students = new ArrayList<>(new Student().createListOfStudents());
        students.forEach(System.out::println);
        System.out.println("====Sort by avgGrade====");
        students.stream()
                .sorted(Comparator.comparingDouble(Student::getAvgGrade))
                .sorted(Comparator.comparingInt(Student::getCourse))
                .sorted(Comparator.comparingInt(Student::getAge))
                .forEach(System.out::println);
    }
}
