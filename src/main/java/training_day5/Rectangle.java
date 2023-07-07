package training_day5;

import sun.font.CreatedFontTracker;

public class Rectangle implements Shape {
    double a;
    double b;

    public Rectangle(double a, double b){
        this.a = a;
        this.b = b;
    }

    @Override
    public double calculateArea() {
        return a * b;
    }

    @Override
    public double calculatePerimeter(){
        return (a + b) * 2;
    }
}
