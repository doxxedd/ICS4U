package OOP;

import java.util.*;

public class AnimalMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Animal dog = new Animal("Duke", "Male", "Gold", 10, true);
        System.out.println("\nName: " + dog.getName());
        System.out.println("Gender: " + dog.getGender());
        System.out.println("Color: " + dog.getColor());
        System.out.println("Weight: " + dog.getWeight());
        System.out.println("Is the animal breathing air? " + dog.getBreathAir());

        System.err.println("\nEnter new weight: ");
        int newWeight = input.nextInt();
        dog.setWeight(newWeight);
        System.out.println(dog.getName() + " is now " + newWeight + " kilos");

        Animal horse = new Animal("Mike", "Female", "Black", 100, true);
        System.out.println("\nName: " + horse.getName());
        System.out.println("Gender: " + horse.getGender());
        System.out.println("Color: " + horse.getColor());
        System.out.println("Weight: " + horse.getWeight());
        System.out.println("Is the animal breathing air? " + horse.getBreathAir());

        AnimalSuper superDog = new AnimalSuper("Bob", "M", "Black and White", 1000, false);
        System.out.println(superDog.getName() + " is ");
        superDog.sleeping();

    }
}