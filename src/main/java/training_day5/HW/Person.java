package training_day5.HW;

import javax.sound.sampled.DataLine;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Person {
    private String name;
    private Gender gender;
    private String ID;

    public Person(String name) {

        this.name = name;
        this.gender = Gender.Unknown;

        this.ID = getRandomID();
    }
    public Person(String name, Gender gender) {

        this(name);
        this.gender = gender;
    }

    private static String getRandomID(){
        Random random = new Random();
        return ((Math.abs(random.nextInt() % 9) + 1) * 1000 + Math.abs(random.nextInt() % 1000)) + "." +
                ((Math.abs(random.nextInt() % 9) + 1) * 1000 + Math.abs(random.nextInt() % 1000)) + "." +
                ((Math.abs(random.nextInt() % 9) + 1) * 1000 + Math.abs(random.nextInt() % 1000)) + "." +
                ((Math.abs(random.nextInt() % 9) + 1) * 1000 + Math.abs(random.nextInt() % 1000));
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
