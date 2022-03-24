package Tests;

import java.util.*;
import java.util.jar.Attributes.Name;

/*
* To test my abilities for 2D arrays. Shopping cart with price and name of bought input. Display and sort output.
*/

public class PrepGrid {

    static Scanner input = new Scanner(System.in);

    static double[][] price = new double[2][3];
    static String[][] name = new String[2][3];

    public static void inputAndStore() {
        for (int week = 0; week < name.length; week++) {
            for (int day = 0; day < name[week].length; day++) {
                System.out.println("Enter the name of the product on week: " + (week + 1) + " day: " + (day + 1));
                name[week][day] = input.nextLine();

                System.out.println("Enter the price of the product on week: " + (week + 1) + " day: " + (day + 1));
                price[week][day] = Double.parseDouble(input.nextLine());
            }
        }
    }

    public static void display() {
        for (int week = 0; week < name.length; week++) {
                System.out.print("\nWeek: " + (week + 1));
            for (int day = 0; day < name[week].length; day++) {
                System.out.println("\nDay: " + (day + 1));
                System.out.println(name[week][day] + "\t" + price[week][day]);
            }
        }
    }

    public static void sortPriceWeek() {
        
        System.out.println("SORTED PRICES BY WEEK:");
        
        for (int week = 0; week < name.length; week++) {
            for (int day = 0; day < name[week].length; day++) {
                
                
                for (int k = 0; k < price[week].length - day - 1; k++) {
                    if (price[week][k] > price[week][k + 1]) {
 
                        // swapping of elements
                        double t = price[week][k];
                        price[week][k] = price[week][k + 1];
                        price[week][k + 1] = t;
                    }
                }


            }
        }
    }

    public static void main(String[] args) {
        inputAndStore();
        display();
        sortPriceWeek();
        display();
        input.close();
    }
}