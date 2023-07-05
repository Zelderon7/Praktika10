package training_day2;

import java.util.Objects;

public class User {
    private String name;
    private String password;

    public User(String Name, String Password){
        this.name = Name;
        this.password = Password;
    }
    public String getName() {
        return name;
    }
    public boolean checkPassword(String password){
        return Objects.equals(this.password, password);
    }

}
