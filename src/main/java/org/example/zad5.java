package org.example;

import java.util.Arrays;

public class zad5 {

    public static void main(String[] args) {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        for (String item : days) {
            System.out.println(item);
        }

        Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday").stream().forEach(System.out::println);

        System.out.println(String.join("\n", new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"}));
    }
}
