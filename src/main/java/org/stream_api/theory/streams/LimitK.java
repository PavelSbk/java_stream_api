package org.stream_api.theory.streams;

import org.stream_api.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * LIMIT
 * limit() - позволяет ограничить выборку определенным количеством первых элементов
 * >> collection.stream().limit(2).collect(Collectors.toList())
 */

public class LimitK {

    /**
     * Вывести на печать двух первых студентов старше 20 лет
     */

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(new Student().createListOfStudents());
        students.stream().filter(s -> s.getAge() > 20).limit(2).forEach(System.out::println);
    }
}
