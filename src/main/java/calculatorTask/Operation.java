package calculatorTask;

class Operation {

    protected char name;
    protected int priority;

    protected Operation(char name, int priority){
        this.name = name;
        this.priority = priority;
    }
}
