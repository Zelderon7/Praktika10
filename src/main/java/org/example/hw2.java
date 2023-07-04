package org.example;

import java.util.Arrays;

public class hw2 {

    public static void main(String[] args) {
        int[] arr = {2,3,4};
        System.out.println(sumArr(arr));
    }

    public static int sumArr(int[] arr){
        return Arrays.stream(arr).sum();
    }


}
