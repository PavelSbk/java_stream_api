package org.stream_api.theory.streams;

import org.stream_api.model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Чтобы сгруппировать данные в Map по какому-нибудь признаку,
 * нам надо использовать в связке метод collect() объекта Stream и метод Collectors.groupingBy().
 * <p>
 * Пример:
 * phoneStream.collect(Collectors.groupingBy(Phone::getCompany));
 * <p>
 * Для создания групп в метод phoneStream.collect() передается вызов функции Collectors.groupingBy(),
 * которая с помощью выражения Phone::getCompany группирует объекты по компании.
 * В итоге будет создан объект !!!Map!!! Map<Компания, Телефон>, в котором ключами являются названия компаний,
 * а значениями - список связанных с компаниями телефонов.
 *
 * Map.forEach(((classification, animals1) -> {
 *             System.out.println(classification);
 *             animals1.forEach(System.out::println);
 *             System.out.println();
 *         }));
 */

public class GroupingByM {

    public static void main(String[] args) {
        /**
         * Необходимо изменить написание имён студентов на написание заглавными буквами
         * и отсортировать их по возрастанию курса, далее вывести на печть только имя и средний балл
         */
        List<Student> students = new ArrayList<>(new Student().createListOfStudents());
        Map<Integer, List<Student>> map = students.stream().map(e -> {
            e.setName(e.getName().toUpperCase());
            return e;
        }).collect(Collectors.groupingBy(Student::getCourse));
        /**
         * Map.forEach(((k, v) -> {
         *             System.out.println(k);
         *             v.forEach(System.out::println);
         *             System.out.println();
         *         }));
         */
        map.forEach((k, v) -> {
            System.out.println(k + ")");
            v.forEach(e -> System.out.println(e.getName() + " " + e.getAvgGrade()));
        });
    }
}
