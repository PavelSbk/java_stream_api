package org.stream_api.theory.streams;

import org.stream_api.model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** MIN MAX
 * min() - возвращает минимальный элемент, в качестве условия использует компаратор
 * >> collection.stream().min(String::compareTo).get()
 *
 * max() - возвращает максимальный элемент, в качестве условия использует компаратор
 * >> collection.stream().max(String::compareTo).get()
 */

public class MInMaxT {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(new Student().createListOfStudents());
        /**
         * Вывести на печать младшего по возрасту студента
         */
        students.stream().min(Comparator.comparing(Student::getAge)).ifPresent(System.out::println);
        /**
         * Вывести на печать худшего по среднему баллу студента
         */
        students.stream().min(Comparator.comparing(Student::getAvgGrade)).ifPresent(System.out::println);
        /**
         * Вывести на печать студента последнего в списке фамилий
         * !! Важно, фамилии будут выводиться от меньшей Абрамов к меньшей Смирнова (А < С)
         */
        students.stream().max(Comparator.comparing(Student::getSurname)).ifPresent(System.out::println);
    }
}
