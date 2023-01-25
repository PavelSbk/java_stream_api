package org.stream_api.theory.streams;

import org.stream_api.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** PARTITIONING
 *
 * Метод Collectors.partitioningBy() имеет похожее на Collectors.groupingBy() действие,
 * только он делит элементы на группы по принципу, соответствует ли элемент определенному условию
 *
 * Map<String, Long> phonesByCompany = phoneStream.collect(
 *  Collectors.groupingBy(Phone::getCompany, Collectors.counting())
 *  );
 */

public class PartitioningByM {

    public static void main(String[] args) {
        /**
         * необходимо разделить студентов по среднему баллу на две группы: высокий балл (true) и низкий балл (false)
         */
        List<Student> students = new ArrayList<>(new Student().createListOfStudents());
        Map<Boolean, List<Student>> map = students.stream()
                .collect(Collectors.partitioningBy(student -> student.getAvgGrade() > 8));
        map.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });
    }
}
