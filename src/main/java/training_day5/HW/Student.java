package training_day5.HW;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Student extends Person{

    private int clas;
    private int numberInClass;
    private School school;
    private HashMap<Subjects, Grade> gradesForSubject = new HashMap<>();
    private List<Subjects> subjects = new ArrayList<>();

    public Student(String name, List<Subjects> subjects, int clas, int numberInClass, School school){
        super(name);
        school.registerStudent(this);
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

    public School getSchool(){
        return this.school;
    }

    public void setSchool(School school){
        this.school = school;
    }

    public boolean addNewGrade(Subjects subject, Grade grade){
        if(grade.teacher.getSubjects().contains(subject) && this.subjects.contains(subject) &&
            grade.teacher.getSchool() == this.school && grade.value >= 2 && grade.value <= 6){
            this.gradesForSubject.put(subject, grade);
            return true;
        }
        else
            return false;
    }

    public void updateGrade(Subjects subject, int value){

        Grade temp = this.gradesForSubject.get(subject);
        temp.value = (temp.value + value)/2;
        gradesForSubject.replace(subject, temp);
    }

    public int getGrade(Subjects subject){
        return this.gradesForSubject.get(subject).value;
    }

    public float getAverageGrade(){
        float ans = 0;
        for (Subjects s:
            subjects) {
            ans += gradesForSubject.get(s).value;
        }
        return ans / subjects.size();
    }

    public String getFavouriteSubject(){
        int worst = -10;
        Subjects subject = null;
        for (int i = 0; i < subjects.size(); i++){
            if(gradesForSubject.get(subjects.get(i)).value > worst){
                worst = gradesForSubject.get(subjects.get(i)).value;
                subject = subjects.get(i);
            }
        }
        return subject.name();
    }

    public List<Subjects> getSubjects(){
        return this.subjects;
    }


}
