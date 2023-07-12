package calculatorTask;

public class Operation {

    protected char name;
    protected int priority;

    public Operation(char name, int priority){
        this.name = name;
        this.priority = priority;
    }
}
