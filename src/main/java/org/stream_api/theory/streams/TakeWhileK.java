package org.stream_api.theory.streams;

import org.stream_api.model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** TAKE WHILE
 * takeWhile(Predicate p) - будет брать элементы стрима,
 * до тех пор пока не встретится элемент, подходящий под предикат, т.е.
 * получать поток данных до тех пор, пока условие истина.
 */

public class TakeWhileK {

    public static void main(String[] args) {

        /**
         * Вывести на экран студентов со среднимм баллом ниже 8
         * - сортируем
         * - условие предиката AvgGrade < 8.0
         */
        List<Student> students= new ArrayList<>(new Student().createListOfStudents());
        students.stream()
                .sorted(Comparator.comparing(Student::getAvgGrade))
                .takeWhile(student -> student.getAvgGrade() < 8.0)
                .forEach(System.out::println);
        /**
         * Вывести на экран студентов со среднимм баллом выше 8
         * - сортируем в обратном порядке
         * - условие предиката AvgGrade > 8.0
         */
        System.out.println("======================");
        students.stream()
                .sorted(Comparator.comparing(Student::getAvgGrade).reversed())
                .takeWhile(student -> student.getAvgGrade() > 8.0)
                .forEach(System.out::println);
    }
}
