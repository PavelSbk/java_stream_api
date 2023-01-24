package org.stream_api.theory.streams;

import org.stream_api.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * В Java 8 Stream API доступны методы двух видов — конвейерные и терминальные.
 * Кроме них можно выделить ряд спецметодов для работы с числовыми стримами и несколько методов для проверки
 * параллельности/последовательности. Но это формальное разделение.
 *
 * Конвейерных методов в стриме может быть много.
 * Терминальный метод — только один. После его выполнения стрим завершается.
 *
 * Пока вы не вызвали терминальный метод, ничего не происходит.
 * Все потому, что конвейерные методы ленятся. Это значит, что они обрабатывают данные и ждут команды,
 * чтобы передать их терминальному методу
 */

public class FilterM {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(new Student().createListOfStudents());
        students.stream()
                .filter(student -> student.getAvgGrade() > 8 && student.getAge() < 25)
                .forEach(System.out::println);
    }
}
