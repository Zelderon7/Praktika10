package training_day3;

import java.util.Scanner;

public class Zad3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        System.out.println(Reverse(in.nextLine()));
    }

    public static String Reverse(String a){
        String ans = "";
        for (int i = a.split(" ").length - 1; i > 0; i--)
            ans += a.split(" ")[i] + " ";

        return ans + a.split(" ")[0];
    }
}
