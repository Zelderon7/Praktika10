package org.example;

import java.util.Scanner;

public class zad3 {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter weight: ");
        int weight = getIntBetween(50, 500);

        if (weight < 90) {
            if (weight < 71) {
                System.out.println("skinny");
            } else {
                System.out.println("skinny fat");
            }
        } else {
            if (weight < 111) {
                System.out.println("obese");
            } else {
                System.out.println("extra obese");
            }
        }
    }

    private static int getIntBetween(int min, int max) {
        Scanner in = new Scanner(System.in);
        int a = -1;
        while (a < min || a >= max) {
            try {
                a = in.nextInt();
            } catch (Exception e) {
                in.next();
                System.out.println("Invalid Input please enter an integer!");
                continue;
            }
            if (a < min || a >= max) System.out.println("Value out of bounds!");
        }
        return a;
    }
}
