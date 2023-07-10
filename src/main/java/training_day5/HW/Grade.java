package training_day5.HW;

public class Grade{
    public int value;
    public Teacher teacher;
    public Grade(int value, Teacher teacher){
        this.value = value;
        this.teacher = teacher;
        teacher.signNewGrade(this);
    }
    public Grade(int value, Teacher teacher, Student student, Subjects subject){
        this.value = value;
        this.teacher = teacher;
        teacher.signNewGrade(this);
        if(student.getGrade(subject) == 0){
            student.addNewGrade(subject, this);
        }
        else{
            student.updateGrade(subject, value);
        }
    }
}
