package org.stream_api.theory.lambda;

import org.stream_api.model.CheckOverGrade;
import org.stream_api.model.Student;
import org.stream_api.model.StudentCheck;

import java.util.*;

/**
 * Лямбда выражения были добавлены в Java 8.
 * Их основная цель – повысить читабельность и уменьшить количество кода
 * и позволить программировать в java в функциональном стиле.
 *
 * Lambda expression - это краткое описание логики реализации функции (пример метод интерфейса)
 *
 * Лямбда выражения позволяют проделать несколько операций в одну (условно) строчку, а именно:
 * - создать интерфейс с общим методом
 * - создать реализацию метода интерфейса в классе
 * - создать экземпляр класса, вставляя его в параметр метода
 * либо
 * - создать экземпляр класса
 * - вызвать метод с параметрами (данные, интерфейс с общим методом)
 * - переопределить метод интерфейса в анонимном классе
 * Пример анонимного класса:
 *
 * stud.check(students, new StudentCheck() {
 *             @Override
 *             public boolean check(Student student) {
 *                 return student.getAge() > 25;
 *             }
 *         });
 *
 * Пример упрощения с помощью лямбды (в функциональном стиле):
 * stud.check(students, student -> student.getAge() < 25);
 */
public class LambdaExOne {

    public static void main(String[] args) {
        Student stud = new Student();
        List<Student> students = new ArrayList<>(stud.createListOfStudents());
        /**
         * Сравнение через методы класса
         */
        stud.printStudentOverGrade(students, 8);
        System.out.println("=====");
        stud.printStudentUnderAge(students, 25);
        System.out.println("=====");
        stud.printStudentMixCondition(students, 9, 20, 'F');
        /**
         * сравнение через анонимный класс на основе интерфейса StudentCheck() с методом check()
         */
        System.out.println("=== Age > 25 ===");
        stud.check(students, new StudentCheck() {
            @Override
            public boolean check(Student student) {
                return student.getAge() > 25;
            }
        });
        System.out.println("=== AvgGrade > 9 ===");
        stud.check(students, new StudentCheck() {

            @Override
            public boolean check(Student student) {
                return student.getAvgGrade() < 9;
            }
        });
        /**
        * замена анонимного класса на lambda expression
        */
        System.out.println("== Lambda with return ==");
        stud.check(students, student -> {
            return student.getAge() < 25;
        });
        System.out.println("== Lambda without return ==");
        stud.check(students, stu -> stu.getAge() < 20);
        System.out.println("=== AvgGrade < 8 ===");
        stud.check(students, student -> student.getAvgGrade() < 8);
        System.out.println("=== Sort by avg higher -> lower with Collections.sort() ===");
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) Double.compare(o2.getAvgGrade(), o1.getAvgGrade());
            }
        });
        students.forEach(System.out::println);
        System.out.println("=== Sort by avg lower -> higher lambda expression ===");
        students.sort(Comparator.comparingDouble(Student::getAvgGrade));
        students.forEach(System.out::println);
    }
}
