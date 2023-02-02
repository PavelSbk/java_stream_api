package org.stream_api.theory.generics.game;

public class PlayGame {

    public static void main(String[] args) {

        var scholar1 = new Scholar("Ivan", 13);
        var scholar2 = new Scholar("Olga", 15);

        var student1 = new Student("Igor", 19);
        var student2 = new Student("Katya", 21);

        var employee1 = new Employee("Semen", 35);
        var employee2 = new Employee("Klava", 42);

        Team<Scholar> scholarTeam = new Team<>("Dragons");
        scholarTeam.addNewParticipant(scholar1);
        scholarTeam.addNewParticipant(scholar2);
        Team<Student> studentTeam = new Team<>("Robots");
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);
        Team<Employee> employeeTeam = new Team<>("Workers");
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);


    }
}
