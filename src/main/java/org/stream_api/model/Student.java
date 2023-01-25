package org.stream_api.model;

import java.util.List;
import java.util.function.Predicate;

public class Student {

    LearningForm learningForm;

    String name;

    String surname;

    char sex;

    int age;

    int course;

    double avgGrade;

    public Student() {
    }

    public Student(String name, String surname, char sex, int age, int course, double avgGrade) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgGrade = avgGrade;
    }

    public void printStudentOverGrade(List<Student> students, double grade) {
        for (Student s : students) {
            if (s.avgGrade > grade) {
                System.out.println(s);
            }
        }
    }

    public void printStudentUnderAge(List<Student> students, int age) {
        for (Student s : students) {
            if (s.age < age) {
                System.out.println(s);
            }
        }
    }

    public void printStudentMixCondition(List<Student> students, double grade, int age, char sex) {
        for (Student s : students) {
            if (s.age < age && s.avgGrade < grade && s.sex == sex) {
                System.out.println(s);
            }
        }
    }

    public void check(List<Student> students, StudentCheck sc) {
        for (Student s : students) {
            if (sc.check(s)) {
                System.out.println(s);
            }
        }
    }

    public void testStudents(List<Student> students, Predicate<Student> pr) {
        for (Student s : students) {
            if (pr.test(s)) {
                System.out.println(s);
            }
        }
    }

    public List<Student> createListOfStudents() {
        return List.of(
                new Student("Ivan", "Kozlov", 'M', 22, 3, 8.3),
                new Student("Nikolay", "Abramov",'M', 28, 2, 6.4),
                new Student("Nina", "Ivanova", 'F', 18, 1, 7.9),
                new Student("Elena", "Fedorova", 'F', 19, 1, 8.9),
                new Student("Petr", "Kirilov",'M', 35, 4, 7.3),
                new Student("Maria", "Simonova",'F', 22, 4, 9.1),
                new Student("Maria", "Smirnova",'F', 23, 5, 8.1)
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student {"
                +
                "name = '" + name + '\''
                +
                ", surname = '" + surname + '\''
                +
                ", sex = " + sex
                +
                ", age = " + age
                +
                ", course = " + course
                +
                ", avgGrade = " + avgGrade
                +
                '}';
    }
}
