package OOP;

public class Toy {
    
    private String name;
    private double cost;
    private double sellingPrice;

    //constructor 
    public Toy(String name, double cost, double sellingPrice) {
        this.name = name;
        this.cost = cost;
        this.sellingPrice = sellingPrice;
    }

    //accessor - getter 
    public String getName() { return name; }
    public double getCost() { return cost; }
    public double getSellingPrice() { return sellingPrice; }
    public double getProfit() { return (sellingPrice - cost); }

    //modifier - accessor 
    public void setName(String newName) { this.name = newName; }
    public void setCost(double newCost) { this.cost = newCost; }
    public void setPrice(double newSellingPrice) { this.sellingPrice = newSellingPrice; }

}