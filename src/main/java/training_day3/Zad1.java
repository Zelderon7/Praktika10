package training_day3;

import java.util.Scanner;

public class Zad1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter 10 numbers (, )");
        int[] nums = getNums(10);

        System.out.println("Positive: ");
        for (int i:
                nums){
            if(i >= 0)
                System.out.println(i);
        }

        System.out.println("Negative: ");
        for (int i:
                nums){
            if(i < 0)
                System.out.println(i);
        }

        System.out.println("Odd: ");
        for (int i:
                nums){
            if(i%2 == 0)
                System.out.println(i);
        }

        System.out.println("Even: ");
        for (int i:
                nums){
            if(i%2 != 0)
                System.out.println(i);
        }

        System.out.print("Number of \"5\": ");
        int c = 0;
        for (int i:
                nums){
            if(i == 5)
                c++;
        }
        System.out.println(c);
    }

    private static int[] getNums(int count){
        Scanner in = new Scanner(System.in);
        int[] ans = new int[count];
        while (true) {
            String[] a = new String[0];
            try {
                a = in.nextLine().split(", ");
                if (a.length != count) {
                    System.out.println("Enter exactly " + count + " numbers!");
                    continue;
                }

                for (int i = 0; i < count; i++) {
                    ans[i] = Integer.parseInt(a[i]);
                }

                break;

            } catch (Exception e) {
                System.out.println("Invalid Input please enter " + count + "words separated with \", \"");
                System.out.println(e);
                System.out.println(a[9]);
                continue;
            }
        }

        return ans;
    }

}
