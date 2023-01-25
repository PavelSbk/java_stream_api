package org.stream_api.theory.streams;

import org.stream_api.model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** FLAT MAP
 * flatMap() используется тогда, когда нужно поработать не с самими элементами коллекции на которой вызван стрим,
 * а с элементами внутри элементов (List<Faculty> внутри имеет List<Student>)
 * flatMap, flatMapToInt, flatMapToDouble, flatMapToLong - сработает как map, но преобразует один элемент в ноль,
 * один или множество других
 * >>> collection.stream().flatMap((p) -> Arrays.asList(p.split(",")).stream()).toArray(String[]::
 *
 */

public class FlatMapM {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(new Student().createListOfStudents());
        students.forEach(System.out::println);
        Faculty f1 = new Faculty("Economics");
        Faculty f2 = new Faculty("Mathematics");
        f1.addStudent(new Student("Ivan", "Kozlov", 'M', 22, 3, 8.3));
        f1.addStudent(new Student("Nikolay", "Abramov",'M', 28, 2, 6.4));
        f1.addStudent(new Student("Maria", "Simonova",'F', 22, 4, 9.1));
        f2.addStudent(new Student("Elena", "Fedorova", 'F', 19, 1, 8.9));
        f2.addStudent(new Student("Petr", "Kirilov",'M', 35, 4, 7.3));
        f2.addStudent(new Student("Maria", "Smirnova",'F', 23, 5, 8.1));
        List<Faculty> faculties = new ArrayList<>();
        faculties.add(f1);
        faculties.add(f2);
        System.out.println("===============");
        /**
         * Вывести имена и средний балл всех студентов из всех факультетов
         */
        faculties.stream()
                .flatMap(faculty -> faculty.getStudentsOnFaculty().stream())
                .sorted(Comparator.comparing(Student::getCourse))
                .forEach(e -> System.out.println(e.getName() + " . " + e.getAvgGrade()));
    }
}

class Faculty{

    String name;

    List<Student> studentsOnFaculty;

    public Faculty(String name) {
        this.name = name;
        studentsOnFaculty = new ArrayList<>();
    }

    public List<Student> getStudentsOnFaculty() {
        return studentsOnFaculty;
    }

    public void addStudent(Student student) {
        studentsOnFaculty.add(student);
    }
}
