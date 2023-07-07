package training_day5.HW;

import java.util.Arrays;
import java.util.HashMap;

public class Student extends Person{

    private int clas;
    private int numberInClass;
    private String school;
    public HashMap<Subjects, Float> gradesForSubject = new HashMap<>();
    Subjects[] subjects;

    public Student(String name, Subjects[] subjects, int clas, int numberInClass){
        super(name);
        registerStudent(this);
        this.subjects = subjects.clone();
        this.clas = clas;
        this.numberInClass = numberInClass;
    }


}
