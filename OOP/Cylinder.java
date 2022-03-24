package OOP;

public class Cylinder extends Circle {
    private double height; 

    public Cylinder(String color, double radius, double height) { 
        super(radius, color);
        this.height = height;
    }

    public double getHeight() { return this.height; }
    public void setHeight() { this.height = height; }
    public double getVolume() { return (Math.PI *  Math.pow(this.getRadius(), 2) * this.height); }
}
