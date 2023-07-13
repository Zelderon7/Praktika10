package training_day5.HW;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {

    List<Subjects> subjects = new ArrayList<>();
    private List<Grade> grades = new ArrayList<>();
    private School school;
    private float salary;

    public Teacher(String name, List<Subjects> subjects, float salary, School school) {
        super(name);
        school.registerTeacher(this);
        this.subjects.addAll(subjects);
        this.salary = salary;
        this.school = school;
    }

    public School getSchool() {
        return this.school;
    }

    public Teacher setSchool(School school) {
        this.school.resignTeacher(this);
        this.school = school;
        school.resignTeacher(this);
        return this;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public Teacher addSubjects(List<Subjects> subjects) {
        this.subjects.addAll(subjects);
        return this;
    }

    public int removeSubjects(List<Subjects> subjects) {
        int ans = 0;
        for (Subjects s :
                subjects) {
            ans += (this.subjects.remove(s) ? 1 : 0);
        }
        if (ans == 0)
            return -1;
        else
            return ans;
    }

    public float getSalary() {
        return this.salary;
    }

    public Teacher setSalary(float salary) {
        this.salary = salary;
        return this;
    }

    public void signNewGrade(Grade grade) {
        this.grades.add(grade);
    }

    public float getAverageGrade() {
        float ans = 0;
        for (Grade g :
                grades) {
            ans += (float) g.value;
        }
        if (ans == 0)
            return -1;
        else
            return ans / grades.size();
    }

    @Override
    public String toString() {
        StringBuilder a = new StringBuilder();
        a.append("\n" + this.getName() + ": " + "\n");
        a.append("Gender = " + this.getGender().name() + "\n");
        a.append("ID = " + this.getID() + "\n");
        a.append("Salary = " + this.getSalary() + "\n");
        a.append("Subjects: ");
        for (Subjects s : this.getSubjects()) {
            a.append(s.name() + "\n");
        }
        return a.toString();
    }
}
