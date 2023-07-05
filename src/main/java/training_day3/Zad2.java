package training_day3;

import java.util.Scanner;

public class Zad2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("String1: ");
        String str1 = in.nextLine();
        System.out.print("String2: ");
        String str2 = in.nextLine();
        String str3 = Separate(str1, str2);
        System.out.println(str3);

    }

    private static String Separate(String str1, String str2){
        StringBuilder sb = new StringBuilder(str1);
        if(sb.indexOf(str2) != -1)
            sb.replace(sb.indexOf(str2), sb.indexOf(str2) + str2.length(), "");
        return sb.toString();
    }
}
