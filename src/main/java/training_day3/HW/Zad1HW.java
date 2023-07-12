package training_day3.HW;

public class Zad1HW {

    public static void main(String[] args) {

    }

    private static int Smallest(int a, int b, int c) {
        if (a < b)
            return a < c ? a : c;
        else
            return b < c ? b : c;
    }
}


