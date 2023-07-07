package training_day5;

public class Triangle implements Shape {
    double a;
    double b;
    double c;
    double hc;

    public Triangle(double a, double b, double c, double hc){
        this.a = a;
        this.b = b;
        this.c = c;
        this.hc = hc;
    }

    @Override
    public double calculateArea() {
        return this.c * this.hc / 2;
    }

    @Override
    public double calculatePerimeter(){
        return a + b + c;
    }
}
