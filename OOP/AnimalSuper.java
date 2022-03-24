package OOP;

public class AnimalSuper extends Animal {
    
    private boolean wings;
    private boolean canTeleport;

    public AnimalSuper (String name, String gender, String color, int weight, boolean breatheAir) {
        super(name, gender, color, weight, breatheAir);
        
        this.wings = wings;
        this.canTeleport = canTeleport;
    }

    public String fly() {
        String message = getName() + " cannot fly.";
        if (wings) message = getName() + " can fly.";
        return message;
    }

    public String teleport() {
        String message = getName() + " cannot teleport.";
        if (canTeleport) message = getName() + " can teleport.";
        return message;
    }

    public void gaveBirth() {
        System.out.println("The SuperAnimal gave birth :)");
    }

}