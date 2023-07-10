package training_day5.HW;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{
    List<Subjects> subjects = new ArrayList<>();
    List<Integer> grades = new ArrayList<>();
    private String school;
    private float salary;

    public Teacher(String name, List<Subjects> subjects, float salary, String school){
        super(name);
        this.subjects.addAll(subjects);
        this.salary = salary;
        this.school = school;
    }

    public String getSchool(){
        return this.school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    public List<Subjects> getSubjects(){
        return subjects;
    }
    public void addSubjects(List<Subjects> subjects){
        this.subjects.addAll(subjects);
    }
    public int removeSubjects(List<Subjects> subjects){
        int ans = 0;
        for (Subjects s:
             subjects) {
            ans += (this.subjects.remove(s)? 1:0);
        }
        if(ans == 0)
            return -1;
        else
            return ans;
    }

    public float getSalary(){
        return this.salary;
    }
    public void setSalary(float salary){
        this.salary = salary;
    }

    public void signNewGrade(int grade){
        this.grades.add(grade);
    }

    public float getAverageGrade(){
        float ans = 0;
        for (Integer g:
             grades) {
            ans += (float)g;
        }
        if(ans == 0)
            return -1;
        else
            return  ans/grades.size();
    }
}
