package training_day3;

import java.util.ArrayList;

public class Zad5 {
    public static void main(String[] args) {
        ArrayList<String> testArr = new ArrayList<>();
        testArr.add("1");
        testArr.add("2");
        testArr.add("3");
        testArr.add("4");
        testArr.add("5");
        testArr.add("6");
        testArr.add("7");
        testArr.add("8");
        testArr.add("9");

        testArr = Swap(testArr);

        for (String a:
             testArr) {
            System.out.println(a);
        }
    }

    private static ArrayList<String> Swap(ArrayList<String> arr){
        String t = arr.get(0);
        arr.set(0, arr.get(arr.size() - 1));
        arr.set(arr.size() - 1, t);
        return arr;
    }

}
