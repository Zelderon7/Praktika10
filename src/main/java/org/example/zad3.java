package org.example;

import java.util.Scanner;

public class zad3 {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.print("Enter weight: ");
        int w = getInt(50, 500);

        while (w > 10){
            switch (w){
                case 50:
                    System.out.println("skinny");
                    w = 0;
                    break;

                case 71:
                    System.out.println("skinny fat");
                    w = 0;
                    break;

                case 90:
                    System.out.println("obese");
                    w = 0;
                    break;

                case 111:
                    System.out.println("extra obese");
                    w = 0;
                    break;

                default:
                    w--;
                    break;
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
}
