package org.stream_api.theory.streams;

import org.stream_api.model.Student;

import java.util.ArrayList;
import java.util.List;

/** SKIP
 * skip() - позволяет пропустить N первых элементов
 * >> collection.stream().skip(collection.size() — 1).findFirst().orElse(«1»)
 */

public class SkipK {

    /**
     * Не выводить на печать двух первых студентов старше 20 лет
     */
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(new Student().createListOfStudents());
        students.stream().filter(s -> s.getAge() > 20).skip(2).forEach(System.out::println);
    }
}
