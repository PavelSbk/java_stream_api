package org.stream_api.theory.lambda;

import org.stream_api.model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/** PREDICATE
 * @FunctionalInterface
 * public interface Predicate<T> {
 *
 *     boolean test(T t);
 *
 *     default Predicate<T> and(Predicate<? super T> other); - это &&
 *     Ex:
 *     coursePredicate.and(agePredicate.and(genderPredicate)))
 *
 *     default Predicate<T> or(Predicate<? super T> other); - это ||
 *     Ex:
 *     coursePredicate.or(agePredicate.or(genderPredicate)))
 *
 *     static <T> Predicate<T> isEquals(Object targetRef); - это ==
 *
 *     default Predicate<T> negate(); - это !=
 *    }
 *
 * Параметаризированный функциональный интерфейс.
 *
 * Функциональный дескриптор интерфейса:
 * T -> boolean
 *
 * Интерфейс Predicate представляет собой логическую функцию аргумента.
 * Он в основном используется для фильтрации данных из потока (stream) Java.
 * Метод фильтра потока принимает предикат для фильтрации данных и возврата нового потока,
 * удовлетворяющего предикату. У предиката есть метод test(),
 * который принимает аргумент и возвращает логическое значение.
 *
 * Интерфейс Predicate для задания условия:
 * .removeIf(student -> student.getCourse() < 3);
 *
 * List<String> names = Arrays.asList("Smith", "Samueal", "Catley", "Sie");
 * names.stream().filter(str -> str.startsWith("S")).forEach(System.out::println);
 */

public class PredicateEx {

    public static void main(String[] args) {
        System.out.println("==== New list of students ====");
        Student st = new Student();
        List<Student> students = new ArrayList<>(st.createListOfStudents());
        students.forEach(System.out::println);
        System.out.println("==== Print students course > 2 & age > 22 & M ====");
        st.testStudents(students, student ->
                student.getCourse() > 2
                && student.getAge() > 22
                && student.getSex() == 'M'
        );
        System.out.println("==== Print students course > 3 & age < 23 & F ====");
        Predicate<Student> coursePredicate = student -> student.getCourse() > 3;
        Predicate<Student> agePredicate = student -> student.getAge() < 23;
        Predicate<Student> genderPredicate = student -> student.getSex() == 'F';
        st.testStudents(students, coursePredicate.and(agePredicate.and(genderPredicate)));
        System.out.println("==== Remove all who's course is 1 with Predicate ====");
        /**
         * public interface Predicate<T> {
         * boolean test(T t);
         * }
         */
        students.removeIf(student -> student.getCourse() == 1);
        students.forEach(System.out::println);
    }
}
