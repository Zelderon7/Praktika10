package org.example;

import java.util.Arrays;

public class hw2 {


    public static void main(String[] args) {

        System.out.println(sumArr(new int[] {2, 34, 5, 67, 78, 89, 8, 3}));
    }
    static int sumArr(int[] arr){
        return Arrays.stream(arr).sum();
    }

}


