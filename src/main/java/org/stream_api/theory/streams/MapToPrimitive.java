package org.stream_api.theory.streams;

import org.stream_api.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** MAP TO
 * mapToInt,
 * mapToDouble,
 * mapToLong
 *
 * Аналог map, но возвращает числовой стрим (то есть стрим из числовых примитивов)
 * >> collection.stream().mapToInt((s) -> Integer.parseInt(s)).toArray()
 *
 * Для этого рода методов, существуют собственные методы:
 *
 * sum - возвращает сумму всех чисел
 * >> collection.stream().mapToInt((s) -> Integer.parseInt(s)).sum()
 *
 * average - возвращает среднее арифметическое всех чисел
 * >> collection.stream().mapToInt((s) -> Integer.parseInt(s)).average()
 *
 * mapToObj - преобразует числовой стрим обратно в объектный
 * >> intStream.mapToObj((id) -> new Key(id)).toArray()
 */

public class MapToPrimitive {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(new Student().createListOfStudents());
        /**
         * Нужно сформировать список номеров курсов, на которых учатся студенты
         * и вывести их на печать в порядке возрастания
         *
         * !!! Важно - boxed() - упаковывает примитив в дженерик !!!
         */
        List<Integer> courses = students.stream()
                .mapToInt(Student::getCourse)
                .distinct()
                .sorted()
                .boxed()
                .collect(Collectors.toList());
        System.out.println(courses);
        /**
         * Нужно расчитать средний возраст студентов и вывести его на экран
         */
        double avrAge = students.stream()
                .mapToDouble(Student::getAge)
                .average().getAsDouble();
        System.out.println(avrAge);
    }
}
