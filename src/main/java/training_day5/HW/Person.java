package training_day5.HW;

import javax.sound.sampled.DataLine;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Person {
    private String name;
    private Gender gender;
    private String ID;

    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();

    public Person(String name) {

        this.name = name;
        this.gender = Gender.Unknown;
        StringBuilder a = new StringBuilder(("" + new Random().nextLong()).substring(0, 17));
        //1212.1323.2584.5423
        a.replace(12, 12, a.charAt(12) + ".");
        a.replace(8, 8, a.charAt(8) + ".");
        a.replace(4, 4, a.charAt(4) + ".");

        this.ID = a.toString();
    }
    public Person(String name, Gender gender) {

        this(name);
        this.gender = gender;
    }

    protected void registerStudent(Student a) {
        students.add(a);
    }

    protected void registerTeacher(Teacher a) {
        teachers.add(a);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


    public static void printTeachersAndStudents(){
        System.out.println("*****Teachers*****");
        for (Teacher t:
             teachers) {
            System.out.println("\n" + t.getName() + ": ");
            System.out.println("Gender = " + t.getGender().name());
            System.out.println("ID = " + t.getID());
        }

        System.out.println("\n*****Students*****");
        for (Student s:
                students) {
            System.out.println("\n" + s.getName() + ": ");
            System.out.println("Gender = " + s.getGender().name());
            System.out.println("ID = " + s.getID());
        }
    }

    public static Student whoIsBestAt(Subjects subject){
        int worst = -10;
        Student best = null;
        for (int i = 0; i < students.size(); i++){
            if(students.get(i).getGrade(subject) > worst){
                worst = students.get(i).getGrade(subject);
                best = students.get(i);
            }
        }
        return best;
    }

    public static Student whoIsWorstAt(Subjects subject){
        int best = 10;
        Student worst = null;
        for (int i = 0; i < students.size(); i++){
            if(students.get(i).getGrade(subject) < best){
                best = students.get(i).getGrade(subject);
                worst = students.get(i);
            }
        }
        return worst;
    }

    public static float getAverageSalary(){
        float ans = 0;
        for (Teacher t:
             teachers) {
            ans += t.getSalary();
        }
        return ans / teachers.size();
    }

    public static float getAverageGradeForClass(String school, int clas){
        float ans = 0;
        int count = 0;
        for (Student s:
             students) {
            if(s.getSchool().equals(school) && s.getClas() == clas){
                ans += s.getAverageGrade();
                count++;
            }
        }
        if(count == 0)
            return -1;
        else
            return (float) ans / count;
    }

    public static Teacher whoIsTheMostGenerousTeacher(){
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
