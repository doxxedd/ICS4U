package OOP;

public class Circle {

    private double radius;
    private String color;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() { return this.radius; }
    public void setRadius(double newRadius) { this.radius = newRadius; } 
    public String getColor() { return this.color; } 
    public void setColor(String newColor) { this.color = newColor; } 
    public double getArea() { return Math.pow(this.radius, 2) * Math.PI; }
    public String toString() { 
        return "Circle[radius = " + this.radius + ", color = " + this.color + "]";
    }
}
