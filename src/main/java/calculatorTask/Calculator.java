
package calculatorTask;

import java.util.*;

public class Calculator {

    static Map<Character, Operation> operations = new HashMap<>();
    static List<Character> allowed;

    public static double calculate(String inp) {

        //region Initialising allowed characters and operations

        allowed = new ArrayList<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                '+', '-', '*', '/', '(', ')', '.', '%', '^', ' ', ':', ','));
        operations.put('+', new Operation('+', 0));
        operations.put('-', new Operation('-', 0));
        operations.put('*', new Operation('*', 1));
        operations.put('/', new Operation('/', 1));
        operations.put('%', new Operation('%', 1));
        operations.put('^', new Operation('^', 2));

        //endregion

        StringBuilder b = new StringBuilder(inp.replaceAll(" ", ""));

        //region formatting input

        handleWordInput(b);

        for (int i = b.length() - 1; i >= 0; i--) {
            if (b.charAt(i) == ',')
                b.replace(i, i + 1, ".");

            if (b.charAt(i) == ':')
                b.replace(i, i + 1, "/");

            if (!allowed.contains(b.charAt(i)))
                throw new RuntimeException("Invalid character: {" + b.charAt(i) + "}");
        }

        if(b.charAt(0) == '-' || b.charAt(0) == '+'){
            b.replace(0, indexOfNextOperator(1, b), "(" + b.substring(0, indexOfNextOperator(1, b)) + ")");
        }

        for (int i = 2; i < b.length(); i++) {
            if ((b.charAt(i) == '+' || b.charAt(i) == '-') && operations.containsKey(b.charAt(i - 1))) {
                b.replace(i, indexOfNextOperator(i + 1, b), "(" + b.substring(i, indexOfNextOperator(i + 1, b)) + ")");
                break;
            }
        }

        //endregion

        if (!checkBrackets(b.toString()))
            throw new RuntimeException("Invalid brackets placement");

        String a = solveToSingleEquation(b.toString());

        if (a.charAt(0) == '[')
            return Double.parseDouble("-" + a.substring(1, a.length() - 1));
        return Double.parseDouble(a);
    }

    private static String solveToSingleEquation(String inp) {
        StringBuilder a = new StringBuilder(inp);

        while (a.indexOf("(") != -1) {
            int startI = a.indexOf("(");
            int endI = startI + getClosingIndex(a.substring(startI));
            a.replace(startI,
                    endI + 1,
                    String.valueOf(solveToSingleEquation(a.substring(startI + 1, endI))));
        }
        return prioritySplitSolve(a);
    }

    private static int getClosingIndex(String inp) {
        int bCount = 0;
        for (int i = 0; i < inp.length(); i++) {
            if (inp.charAt(i) == '(')
                bCount++;
            else if (inp.charAt(i) == ')') {
                bCount--;
                if (bCount == 0)
                    return i;
            }
        }
        return 8930374;
    }

    private static void handleWordInput(StringBuilder a) {

        while (a.indexOf("plus") != -1 || a.indexOf("minus") != -1 || a.indexOf("times") != -1 ||
                a.indexOf("onthepowerof") != -1 || a.indexOf("dividedby") != -1 || a.indexOf("reminder") != -1) {

            if (a.indexOf("plus") != -1)
                a.replace(a.indexOf("plus"), a.indexOf("plus") + 4, "+");

            if (a.indexOf("minus") != -1)
                a.replace(a.indexOf("minus"), a.indexOf("minus") + 5, "-");

            if (a.indexOf("times") != -1)
                a.replace(a.indexOf("times"), a.indexOf("times") + 5, "*");

            if (a.indexOf("onthepowerof") != -1)
                a.replace(a.indexOf("onthepowerof"), a.indexOf("onthepowerof") + 12, "^");

            if (a.indexOf("dividedby") != -1)
                a.replace(a.indexOf("dividedby"), a.indexOf("dividedby") + 9, "/");

            if (a.indexOf("remainder") != -1)
                a.replace(a.indexOf("remainder"), a.indexOf("remainder") + 9, "%");
        }
    }

    private static String prioritySplitSolve(StringBuilder inp) {

        int endAt = inp.length(), startAt = 0, targetIndex = -1;
        targetIndex = findHighestPriorityOperation(inp.toString());

        if (targetIndex == -1)
            return inp.toString();

        if (targetIndex == 0) {
            if (inp.charAt(targetIndex) == '-')
                return "[" + inp.replace(targetIndex, targetIndex + 1, "") + "]";
            else
                return inp.replace(targetIndex, targetIndex + 1, "").toString();
        }

        for (int i = targetIndex - 1; i >= 0; i--) {
            if (!(getIntFromChar(inp.charAt(i)) != -1 || inp.charAt(i) == '.'
                    || inp.charAt(i) == '[' || inp.charAt(i) == ']')) {
                startAt = i + 1;
                break;
            }
        }

        for (int i = targetIndex + 1; i < inp.length(); i++) {
            if (!(getIntFromChar(inp.charAt(i)) != -1 || inp.charAt(i) == '.'
                    || inp.charAt(i) == '[' || inp.charAt(i) == ']')) {
                endAt = i;
                break;
            }
        }

        inp.replace(startAt, endAt, simpleCalculation(String.valueOf(inp.subSequence(startAt, endAt))));

        return prioritySplitSolve(inp);
    }

    private static int findHighestPriorityOperation(String inp) {
        int targetPriority = -1;
        int targetIndex = -1;
        for (int i = 0; i < inp.length(); i++) {
            if (getIntFromChar(inp.charAt(i)) != -1 || inp.charAt(i) == '.' || inp.charAt(i) == '[' || inp.charAt(i) == ']') {
                continue;
            } else if (operations.get(inp.charAt(i)).priority > targetPriority) {
                targetPriority = operations.get(inp.charAt(i)).priority;
                targetIndex = i;
            }
        }
        return targetIndex;
    }

    private static int getIntFromChar(char a) {
        if ((int) a >= 48 && (int) a <= 57)
            return (int) a - 48;
        else
            return -1;
    }

    private static String simpleCalculation(String inp) {
        String operation = "+";
        double a, b;

        for (int i = 0; i < inp.length(); i++) {
            if (!(getIntFromChar(inp.charAt(i)) != -1 || inp.charAt(i) == '.' || inp.charAt(i) == '[' || inp.charAt(i) == ']')) {
                operation = String.valueOf(inp.charAt(i));
                break;
            }
        }

        if (operation.equals("+"))
            operation = "\\+";

        if (operation.equals("*"))
            operation = "\\*";

        if (operation.equals("^"))
            operation = "\\^";

        String[] splited = inp.split(operation);
        if (splited[0].charAt(0) == '[')
            splited[0] = "-" + splited[0].substring(1, splited[0].length() - 1);

        if (splited[1].charAt(0) == '[')
            splited[1] = "-" + splited[1].substring(1, splited[1].length() - 1);

        a = Double.parseDouble(splited[0]);
        b = Double.parseDouble(splited[1]);

        switch (operation) {
            case "\\+":
                if (a + b < 0)
                    return "[" + Math.abs(a + b) + "]";
                return String.valueOf(a + b);

            case "-":
                if (a - b < 0)
                    return "[" + Math.abs(a - b) + "]";
                return String.valueOf(a - b);

            case "\\*":
                if (a * b < 0)
                    return "[" + Math.abs(a * b) + "]";
                return String.valueOf(a * b);

            case "/":
                if (b == 0)
                    throw new RuntimeException("Ti si idiot!");
                if (a / b < 0)
                    return "[" + Math.abs(a / b) + "]";
                return String.valueOf(a / b);

            case "%":
                if (b == 0)
                    throw new RuntimeException("Ti si idiot!");
                if (a % b < 0)
                    return "[" + Math.abs(a % b) + "]";
                return String.valueOf(a % b);

            case "\\^":
                if (b == 0)
                    return 1 + "";
                double ans = a;
                for (int i = 0; i < (int) b - 1; i++)
                    ans *= a;

                if (b < 0)
                    ans = 1 / ans;

                if (ans < 0)
                    return "[" + Math.abs(ans) + "]";
                return String.valueOf(ans);

            default:
                throw new RuntimeException("Tf is this: {" + operation + "}");
        }
    }

    private static boolean checkBrackets(String inp) {
        int opened = 0;
        for (int i = 0; i < inp.length(); i++) {
            if (inp.charAt(i) == '(')
                opened++;
            if (inp.charAt(i) == ')')
                opened--;
            if (opened < 0)
                return false;
        }
        if (opened == 0)
            return true;

        return false;
    }

    private static int indexOfNextOperator(int start, StringBuilder sb) {
        for (int i = start; i < sb.length(); i++) {
            if (operations.containsKey(sb.charAt(i)))
                return i;
        }
        return sb.length();
    }
}
