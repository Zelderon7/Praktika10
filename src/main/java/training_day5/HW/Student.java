package training_day5.HW;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Student extends Person{

    private int clas;
    private int numberInClass;
    private String school;
    public HashMap<Subjects, Integer> gradesForSubject = new HashMap<>();
    private List<Subjects> subjects = new ArrayList<>();

    public Student(String name, List<Subjects> subjects, int clas, int numberInClass, String school){
        super(name);
        registerStudent(this);
        this.subjects.addAll(subjects);
        this.clas = clas;
        this.numberInClass = numberInClass;
        this.school = school;
    }

    public int getClas() {
        return clas;
    }

    public void setClas(int clas) {
        this.clas = clas;
    }
    public int getNumberInClass(){
        return this.numberInClass;
    }
    public void setNumberInClass(int number){
        this.numberInClass = number;
    }

    public String getSchool(){
        return this.school;
    }

    public void setSchool(String school){
        this.school = school;
    }

    public boolean addNewGrade(Teacher teacher, Subjects subject, int grade){
        if(teacher.getSubjects().contains(subject) && this.subjects.contains(subject) &&
            teacher.getSchool().equals(this.school) && grade >= 2 && grade <= 6){
            this.gradesForSubject.put(subject, grade);
            return true;
        }
        else
            return false;
    }

    public int getGrade(Subjects subject){
        return this.gradesForSubject.get(subject);
    }

    public float getAverageGrade(){
        float ans = 0;
        for (Subjects s:
            subjects) {
            ans += gradesForSubject.get(s).floatValue();
        }
        return ans / subjects.size();
    }

    public String getFavouriteSubject(){
        int worst = -10;
        Subjects subject = null;
        for (int i = 0; i < subjects.size(); i++){
            if(gradesForSubject.get(subjects.get(i)) > worst){
                worst = gradesForSubject.get(subjects.get(i));
                subject = subjects.get(i);
            }
        }
        return subject.name();
    }
}
