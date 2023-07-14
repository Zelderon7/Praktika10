package training_day5.HW;

public class Grade{

    public int value;
    public Teacher teacher;

    public Grade(int value, Teacher teacher, Student student, Subjects subject){
        this.value = value;
        this.teacher = teacher;
        teacher.signNewGrade(this);
        if(student.getGrade(subject) == -1){
            student.addNewGrade(subject, this);
        }
        else{
            student.updateGrade(subject, value);
        }
    }
}
