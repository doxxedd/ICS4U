/*
* Author: Daniel Dinari
* Teacher: Ms. Andreghetti 
* Date: Sept 30, 2020
* Description: menu driven shopping list containing methods for each menu item
*/

package Tests;
import java.util.*;

public class ShoppingList {

    static Scanner input = new Scanner(System.in);
    
    public static void enterItem(ArrayList l) {
        System.out.println("Enter your items: ('no' to stop)");
        
        //filling up the array (up to 10 items)
        for (int i = 0; i < 10; i++) {
            String temp = input.nextLine();
            if (temp.equals("no")) break; //giving user chance to stop inputting
            else l.add(temp);
        }
    }

    public static void displayItems(ArrayList l) { //displaying the list with good formatting
        System.out.println("Your items are:");
        
        String temp = "[";
        for (int i = 0; i < l.size(); i++) {
            temp += "\"" + l.get(i) + "\"";
            if (i != l.size() - 1) temp += ", ";
        }
        temp += "]";
        System.out.println(temp); 
    }

    public static void markBought(ArrayList l, String boughtItem) { //adding **** after every bought item by user input
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).equals(boughtItem)) l.add(i + 1, "****");
        }
    }

    public static boolean areItemsBought(ArrayList l) { //returning true if the all items are bought and false if even one is not bought
        for (int i = 0; i < l.size(); i++) {
            if (!l.get(i).equals("****")) {
                if (i == l.size() - 1) return false;
                else if (!l.get(i + 1).equals("****")) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(); //creating the arraylist of strings for the user's shopping cart


        while(1 == 1) { //menu giving user choice
            System.out.println("What do you want to do? (enterItems = 1) (displayItems = 2) (markBought = 3) (areItemsBought = 4)");
            String menuResponse = input.nextLine();
            
            switch(menuResponse) //menu that opens whatever user desires
            {
                case "1":
                    enterItem(list);
                    break;
                case "2":
                    displayItems(list);
                    break;
                case "3":
                    System.out.println("What have you bought?");
                    String response = input.nextLine();
                    markBought(list, response);
                    break;
                case "4":
                    displayItems(list);
                    System.out.println(areItemsBought(list));;
                    break;
                default: 
                    System.out.println("Invalid input.");
                    break;
            }
        }
    }
}
