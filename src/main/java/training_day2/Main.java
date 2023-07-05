package training_day2;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    static Map<String, User> Users = new HashMap<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String curName;
        String curPas;

        while (true){
            System.out.println("Choose an option: ");
            System.out.println("1. Sign in");
            System.out.println("2. Log in");



            if(getInt(1, 3) == 1){

                System.out.print("Enter Name: ");
                curName = getName();
                System.out.print("Enter Password: ");
                curPas = getPas();

                Users.put(curName, new User(curName, curPas));
                System.out.println("User saved successfully");
            }
            else {

                System.out.print("Enter Name: ");
                curName = getName();
                System.out.print("Enter Password");
                curPas = getPas();

                if(Users.get(curName).checkPassword(curPas)){
                    System.out.println("Logged in successfully " + Users.get(curName).getName());
                }else {
                    System.out.println("Wrong credentials!");
                }

            }
        }
    }

    private static int getInt(int min, int max){
        Scanner in = new Scanner(System.in);
        int a = -1;
        while (a < min || a >= max){
            try{
                a = in.nextInt();
            }catch (Exception e){
                in.next();
                System.out.println("Invalid Input please enter an integer!");
                continue;
            }
            if(a < min || a >= max)
                System.out.println("Value out of bounds!");
        }
        return a;
    }

    private static String getName(){
        Scanner in = new Scanner(System.in);
        String a = " ";
        while (a.length() <= 3 || a.contains(" ") || a.contains("@")) {
            a = in.nextLine();
            if(a.length() <= 3 || a.contains(" ") || a.contains("@"))
                System.out.println("Invalid Username");
        }
        return a;
    }

    private static String getPas(){
        Scanner in = new Scanner(System.in);
        String a = " ";
        while (a.length() <= 4 || a.contains(" ") || a.contains("@")) {
            a = in.nextLine();
            if(a.length() <= 4 || a.contains(" ") || a.contains("@"))
                System.out.println("Invalid Password");
        }
        return a;
    }
}