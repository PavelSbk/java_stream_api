package org.stream_api.theory.lambda;

import org.stream_api.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Функциональный интерфейс Function<T,R> представляет функцию перехода от объекта типа T к объекту типа R.
 * T - входной параметр
 * R - выходной параметр
 * public interface Function<T, R> {
 * R apply(T t);
 * }
 * <p>
 * Интерфейс Function — это более общий интерфейс, который принимает один аргумент и выдает результат.
 * В нем применяется единый абстрактный метод (SAM), который принимает аргумент типа T и выдает результат типа R.
 * Одним из распространенных вариантов использования этого интерфейса является метод Stream.map.
 */

public class FunctionEx {

    private static double avgAny(List<Student> students, Function<Student, Double> f) {
        double rst = 0D;
        for (Student s : students) {
            rst += f.apply(s);
        }
        return rst / students.size();
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(new Student().createListOfStudents());
        students.forEach(System.out::println);
        double rslt = avgAny(students, student -> (double) student.getAge());
        System.out.printf("%.1f %s", rslt, System.lineSeparator());
        rslt = avgAny(students, student -> student.getAvgGrade());
        System.out.printf("%.1f %s", rslt, System.lineSeparator());
    }
}
