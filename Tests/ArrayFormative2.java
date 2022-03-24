package Tests;
import java.util.*;
public class ArrayFormative2 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> colours = new ArrayList<>(); //making the colour ArrayList

        for (int i = 0; i < 10; i++) {
            colours.add(input.nextLine()); //filling up the list with user input
        }
        
        //printing the colours entered
        System.out.println("The colours you entered: ");
        for (String string : colours) {
            System.out.println(string);
        }

        colours.add(5, "Black"); //inserting black at index 5
        colours.set(1, "White"); //replacing colour at index 1 with "White"
        
        //printing the new colour list
        System.out.println("The new colours: ");
        for (String string : colours) {
            System.out.println(string);
        }

        colours.remove(5); //removing the "black" we entered at index 5
    } 
}