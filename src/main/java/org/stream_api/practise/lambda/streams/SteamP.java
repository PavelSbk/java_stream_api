package org.stream_api.practise.lambda.streams;

import org.stream_api.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SteamP {

    public static void main(String[] args) {
        /**
         * Создать поток из массива интов [1, 6, 15, 3, 8, 11, 27, 82, 77, 64, 12, 48, 81] и обработать его так, чтобы:
         * - оставить только нечётные числа
         * - все числа, которые делятся на 9 без остатка разделить на 3
         * - и вернуть сумму всех оставшихся чисел;
         * Ответ: 143
         */
        int[] arr = {1, 6, 15, 3, 8, 11, 27, 82, 77, 64, 12, 48, 81};
        int result = Arrays.stream(arr)
                .filter(i -> i % 2 != 0)
                .map(i -> i % 9 == 0 ? i / 3 : i).sum();
        System.out.println(result);
        /**
         * Для списка студентов:
         * - к именам всех студентов добавить обрамление <<Имя>>
         * - отсортировать по полу
         * - отсортировать по возрасту
         * - отсортировать по среднему баллу
         */
        List<Student> students = new ArrayList<>(new Student().createListOfStudents());
        List<Student> sortedStudents = students.stream()
                .map(s -> new Student("<<" + s.getName() + ">>"
                        , s.getSurname()
                        , s.getSex()
                        , s.getAge()
                        , s.getCourse()
                        , s.getAvgGrade()))
                .sorted(Comparator.comparing(Student::getSex)
                        .thenComparing(Student::getAge)
                        .thenComparing(Student::getAvgGrade))
                .toList();
        sortedStudents.forEach(System.out::println);
    }
}
