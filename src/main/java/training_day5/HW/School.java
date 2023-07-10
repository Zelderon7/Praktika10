package training_day5.HW;

import java.util.ArrayList;
import java.util.List;

public class School {

    private String name;
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public School(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    protected void registerStudent(Student a) {
        this.students.add(a);
    }

    protected void registerTeacher(Teacher a) {
        this.teachers.add(a);
    }

    public void printTeachersAndStudents(){
        System.out.println("*****Teachers*****");
        for (Teacher t:
                teachers) {
            System.out.println("\n" + t.getName() + ": ");
            System.out.println("Gender = " + t.getGender().name());
            System.out.println("ID = " + t.getID());
            System.out.println("Salary = " + t.getSalary());
            System.out.print("Subjects: ");
            for (Subjects s:
                 t.getSubjects()) {
                System.out.print(s.name() + ", ");
            }
            System.out.println();
        }

        System.out.println("\n*****Students*****");
        for (Student s:
                students) {
            System.out.println("\n" + s.getName() + ": ");
            System.out.println("Gender = " + s.getGender().name());
            System.out.println("ID = " + s.getID());
            System.out.println("Class = " + s.getClas());
            for (Subjects ss:
                    s.getSubjects()) {
                System.out.print(ss.name() + ", ");
            }
            System.out.println();
        }
    }

    public Student getTopperIn(Subjects subject){
        int bestGrade = -10;
        Student bestStudent = null;
        for (int i = 0; i < students.size(); i++){
            if(students.get(i).getGrade(subject) > bestGrade){
                bestGrade = students.get(i).getGrade(subject);
                bestStudent = students.get(i);
            }
        }
        return bestStudent;
    }

    public Student getLowestGraderIn(Subjects subject){
        int lowestGrade = 10;
        Student lowestGrader = null;
        for (int i = 0; i < students.size(); i++){
            if(students.get(i).getGrade(subject) < lowestGrade){
                lowestGrade = students.get(i).getGrade(subject);
                lowestGrader = students.get(i);
            }
        }
        return lowestGrader;
    }

    public float getAverageSalary(){
        float ans = 0;
        for (Teacher t:
                teachers) {
            ans += t.getSalary();
        }
        return ans / teachers.size();
    }

    public float getAverageGradeForClass(int clas){
        float ans = 0;
        int count = 0;
        for (Student s:
                students) {
            if(s.getClas() == clas){
                ans += s.getAverageGrade();
                count++;
            }
        }
        if(count == 0)
            return -1;
        else
            return (float) ans / count;
    }

    public Teacher highestGradingTeacher(){
        float best = -1;
        Teacher ans = null;
        for (Teacher t:
                teachers) {
            if(t.getAverageGrade() > best){
                best = t.getAverageGrade();
                ans = t;
            }
        }
        return ans;
    }
}
