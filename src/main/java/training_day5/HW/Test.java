package training_day5.HW;

import java.util.*;

public class Test {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        School school1 = new School("PGEE");

        //initialising Teachers
        Teacher mat = new Teacher("mat", Collections.singletonList(Subjects.Math), 4983.96f, school1);
        mat.setGender(Gender.Female);
        Teacher bel = new Teacher("bel", Collections.singletonList(Subjects.Bulgarian), 5983.96f, school1);
        mat.setGender(Gender.Male);
        Teacher matBel = new Teacher("MatBel", Arrays.asList(Subjects.Math, Subjects.Bulgarian), 3283.96f, school1);
        matBel.setGender(Gender.Dinosaur);
        Teacher programing = new Teacher("GPT", Collections.singletonList(Subjects.Programming), 7683.96f, school1);
        programing.setGender(Gender.AI);
        Teacher phis = new Teacher("Galileo", Collections.singletonList(Subjects.Physics), 4000f, school1);
        phis.setGender(Gender.Monkey);

        //initialising Students
        Student Pesho = new Student("Pesho", Arrays.asList(Subjects.Math, Subjects.Physics), 8, 10, school1);
        Pesho.setGender(Gender.Male);
        Student Ivan = new Student("Ivan", Arrays.asList(Subjects.History, Subjects.Bulgarian, Subjects.English), 9, 16, school1);
        Ivan.setGender(Gender.Alien);
        Student Leon = new Student("Leon", Arrays.asList(Subjects.Physics, Subjects.Biology), 9, 3, school1);
        Student Koko = new Student("Koko", Arrays.asList(Subjects.Physics), 9, 5, school1);
        Koko.setGender(Gender.Monkey);

        school1.printTeachersAndStudents();

        System.out.println("\n\n\n\n\n\n\n");
        System.out.println("Average salary: " + school1.getAverageSalary());

        in.nextLine();

        //Writing a grade
        System.out.println(Ivan.getGrade(Subjects.Bulgarian));
        new Grade(5, matBel, Ivan, Subjects.Bulgarian);
        System.out.println(Ivan.getGrade(Subjects.Bulgarian));

        in.nextLine();

        //Writing a second Grade
        System.out.println(Ivan.getGrade(Subjects.Bulgarian));
        new Grade(3, bel, Ivan, Subjects.Bulgarian);
        System.out.println(Ivan.getGrade(Subjects.Bulgarian));

        in.nextLine();

        //Trying to add a grade to a wrong subject
        System.out.println(Pesho.getGrade(Subjects.Bulgarian));
        new Grade(2, matBel, Pesho, Subjects.Bulgarian);
        System.out.println(Pesho.getGrade(Subjects.Bulgarian));

        in.nextLine();

        System.out.println(Pesho.getGrade(Subjects.Physics));
        new Grade(2, matBel, Pesho, Subjects.Physics);
        System.out.println(Pesho.getGrade(Subjects.Physics));

        in.nextLine();

        //Trying to write a grade from another school
        School school2 = new School("Softuni");
        System.out.println("Softuni: ");
        school2.printTeachersAndStudents();

        in.nextLine();

        System.out.println("PGEE: ");
        school1.printTeachersAndStudents();

        in.nextLine();

        mat.changeSchool(school2);
        System.out.println("Softuni: ");
        school2.printTeachersAndStudents();

        in.nextLine();

        System.out.println("PGEE: ");
        school1.printTeachersAndStudents();

        in.nextLine();

        System.out.println(Pesho.getGrade(Subjects.Math));
        new Grade(2, mat, Pesho, Subjects.Math);
        System.out.println(Pesho.getGrade(Subjects.Math));

        in.nextLine();

        //Student with the highest Grades
        System.out.println(school1.getTopperIn(Subjects.Bulgarian));
    }
}
