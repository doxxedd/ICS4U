package OOP;

public class Demo {

    //defining state/characteristics of object demo (instance variable)
    private String name; //class level variable (static)
    private int barCode; //instance
    private double price; //instance

    //public access modifier
    //constructor - MUST BE THE SAME NAME AS CLASS (the method that is called when we call "new" keyword)
    public Demo(String name, int barCode, double price) {
        this.name = name;
        this.barCode = barCode;
        this.price = price; 
    }

    //accessor methods (getter)
    public String getName()  { return name; }
    public int getBarcode()  { return barCode; }
    public double getPrice() { return price; }

    //modifier methods (accessor)
    public void setName(String name) { this.name = name; }
    //OR
    //public void setName(String newName) { name = newName; }

    public void setBarcode(int barCode) { this.barCode = barCode; }
    public void price(double price) { this.price = price; }
}
