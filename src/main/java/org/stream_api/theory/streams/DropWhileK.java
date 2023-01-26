package org.stream_api.theory.streams;

import org.stream_api.model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * DROP WHILE
 * dropWhile() - метода отбрасывает все элементы до тех пор, пока предикат не вернёт true.
 *
 * !!Важно!! Порядок в котором отсортированы элементы
 */

public class DropWhileK {

    public static void main(String[] args) {

        /**
         * Вывести на экран студентов со среднимм баллом выше 8
         * - сортируем
         * - условие предиката AvgGrade < 8.0
         * метод удаляет элементы, пока предикат false (AvgGrade < 8.0 - true)
         * и начинает их пропускать дальше в стрим при (AvgGrade < 8.0 - false)
         */
        List<Student> students = new ArrayList<>(new Student().createListOfStudents());
        students.stream()
                .sorted(Comparator.comparing(Student::getAvgGrade))
                .dropWhile(s -> s.getAvgGrade() < 8.0)
                .forEach(System.out::println);
        /**
         * Вывести на экран студентов со средним баллом ниже 8
         * - сортируем в обратном порядке
         * - условие предиката AvgGrade > 8.0
         */
        System.out.println("======================");
        students.stream()
                .sorted(Comparator.comparing(Student::getAvgGrade).reversed())
                .dropWhile(s -> s.getAvgGrade() > 8.0)
                .forEach(System.out::println);
        System.out.println("======================");
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .dropWhile(n -> n < 5)
                .forEach(System.out::println);
        System.out.println("======================");
        Stream.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
                .dropWhile(n -> n > 5)
                .forEach(System.out::println);
    }
}
