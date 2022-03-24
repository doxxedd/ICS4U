package OOP;

public class Animal {
    
    private String name;
    private String gender;
    private String color;
    private int weight;
    private boolean breatheAir;

    //constructor - states
    public Animal(String name, String gender, String color, int weight, boolean breatheAir) {
        this.name = name;
        this.gender = gender;
        this.color = color;
        this.weight = weight;
        this.breatheAir = breatheAir;
    }

    //behaviors
    public void eat(String food){
        System.out.println("Eating " + food);
    }

    public void walk() {
        System.out.println("Walking now...");
    }

    public void sleeping() {
        System.out.println("Sleeping now Zzz...");
    }

    public void fighting() {
        System.out.println("Fighting now...");
    }

    public void swimming() {
        System.out.println("Swimming now... ");
    }


    //accessor
    public String getName() { return this.name; }
    public String getGender() { return this.gender; }
    public String getColor() { return this.color; }
    public int getWeight() { return this.weight; }
    public boolean getBreathAir() { return this.breatheAir; }

    //modifier
    public void setName(String newName) { this.name = newName; }
    public void setGender(String newGender) { this.gender = newGender; }
    public void setColor(String newColor) { this.color = newColor; }
    public void setWeight(int newWeight) { this.weight = newWeight; }
    public void setBreatheAir(boolean newBreatheAir) { this.breatheAir = newBreatheAir; }

}