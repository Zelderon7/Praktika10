package training_day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static HashMap<Character, Operation> operations = new HashMap<>();
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println(calculate(in.nextLine()));
    }

    static private double calculate(String inp){
        StringBuilder a = new StringBuilder(inp.trim());
        ArrayList<Character> allowed = new ArrayList<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '6', '8', '9',
                '+', '-', '*', '/', '(', ')', '.', '%', '^', ' ', ':', ','));
        operations.put('+', new Operation('+', 0));
        operations.put('-', new Operation('-', 0));
        operations.put('*', new Operation('*', 1));
        operations.put('/', new Operation('/', 1));
        operations.put('%', new Operation('%', 1));
        operations.put('^', new Operation('^', 2));

        for (int i = 1; i < a.length(); i++){
            if(a.charAt(i) == ' ')
                a.replace(i, i+1, "");

            if(a.charAt(i) == ',')
                a.replace(i, i+1, ".");

            if(a.charAt(i) == ':')
                a.replace(i, i+1, "/");

            if(!allowed.contains(a.charAt(i)))
                throw new RuntimeException("Invalid character: {" + a.charAt(i) + "}");
        }


        return prioritySplitSolve(a);
    }

    private static double prioritySplitSolve(StringBuilder inp){
        int endAt = inp.length(), startAt = 0, targetIndex = -1;

        targetIndex = findHighestPriorityOperation(inp.toString());

        if(targetIndex == -1)
            return Double.parseDouble(inp.toString());

        for(int i = targetIndex - 1; i >= 0; i--){
            if(!(getIntFromChar(inp.charAt(i)) != -1 || inp.charAt(i) == '.')){
                startAt = i + 1;
                break;
            }
        }

        for(int i = targetIndex + 1; i < inp.length(); i++){
            if(!(getIntFromChar(inp.charAt(i)) != -1 || inp.charAt(i) == '.')){
                endAt = i;
                break;
            }
        }

        inp.replace(startAt, endAt, simpleCalculation(String.valueOf(inp.subSequence(startAt, endAt))));

        return prioritySplitSolve(inp);
    }

    private static int findHighestPriorityOperation(String inp){
        int targetPriority = -1;
        int targetIndex = -1;
        for(int i = 0; i < inp.length(); i++){
            if(getIntFromChar(inp.charAt(i)) != -1 || inp.charAt(i) == '.'){
                continue;
            }else if(operations.get(inp.charAt(i)).priority > targetPriority){
                targetPriority = operations.get(inp.charAt(i)).priority;
                targetIndex = i;
            }
        }
        return targetIndex;
    }

    private static int getIntFromChar(char a){
        if((int)a >= 48 && (int)a <= 57)
            return (int)a - 48;
        else
            return -1;
    }

    private static String simpleCalculation(String inp){
        String operation = "+";
        double a, b;

        for (int i = 0; i < inp.length(); i++){
            if(!(getIntFromChar(inp.charAt(i)) != -1 || inp.charAt(i) == '.')){
                operation = String.valueOf(inp.charAt(i));
                break;
            }
        }

        if(operation.equals("+"))
            operation = "\\+";

        if(operation.equals("*"))
            operation = "\\*";

        if(operation.equals("^"))
            operation = "\\^";

        a = Double.parseDouble(inp.split(String.valueOf(operation))[0]);
        b = Double.parseDouble(inp.split(String.valueOf(operation))[1]);

        switch (operation){
            case "\\+":
                return String.valueOf(a + b);

            case "-":
                return String.valueOf(a -b);

            case "\\*":
                return String.valueOf(a * b);

            case "/":
                return String.valueOf(a / b);

            case "%":
                return String.valueOf(a % b);

            case "\\^":
                double ans = a;
                for (int i = 0; i < (int)b - 1; i++){
                    ans *= a;
                }
                return String.valueOf(a);

            default:
                throw new RuntimeException("Tf is this: {" + operation + "}");
        }
    }
}
