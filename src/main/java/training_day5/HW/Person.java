package training_day5.HW;

import javax.sound.sampled.DataLine;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Person {
    private String name;
    private Gender gender;
    private String ID;

    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

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


}
