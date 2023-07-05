package training_day3;

import java.util.ArrayList;
import java.util.Scanner;

public class Zad4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("String1: ");
        String ime = in.nextLine();
        System.out.println(iniciali(ime));
    }

    private static String iniciali(String ime){
        ime = ime.toUpperCase();
        ArrayList<Character> ans = new ArrayList<Character>();
        for (int i = 0; i < ime.length(); i++){
            if(!ans.contains(Character.valueOf(ime.toCharArray()[i]))){
                ans.add(Character.valueOf(ime.toCharArray()[i]));
            }
        }



        return ans.toString();
    }
}
