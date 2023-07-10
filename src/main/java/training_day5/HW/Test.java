package training_day5.HW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args){
        Random rand = new Random();
        School school1 = new School("PGEE");
        for (int i = 0; i < 20; i++) {
            List<Subjects> subjectsS = Arrays.asList(Arrays.asList(Subjects.values()).get(Math.abs(rand.nextInt() % Subjects.values().length)), Arrays.asList(Subjects.values()).get(Math.abs(rand.nextInt() % Subjects.values().length)));
            List<Subjects> subjectsT = Arrays.asList(Arrays.asList(Subjects.values()).get(Math.abs(rand.nextInt() % Subjects.values().length)), Arrays.asList(Subjects.values()).get(Math.abs(rand.nextInt() % Subjects.values().length)));
            new Student("Student[" + (i + 1) + "]", subjectsS, rand.nextInt() % 3 + 8, rand.nextInt() % 9 + 1, school1);
            new Teacher("Teacher[" + (i + 1) + "]", subjectsT, rand.nextFloat() * 1000, school1);
        }

        school1.printTeachersAndStudents();
    }
}
