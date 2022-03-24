package Tests;
import java.util.*;

public class GridFormative {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[][] array = new double[4][7];

        //prompt the user to enter in data
        for (int week = 0; week < array.length; week++) {
            for (int day = 0; day < array[week].length; day++) {
                System.out.println("Enter the precipitation for week: " + (week + 1) + " day: " + (day + 1 ));
                array[week][day] = Integer.parseInt(input.nextLine());
            }
        }

        //output and calculate average
        System.out.println("\tDay 1\tDay 2\tDay 3\tDay 4\tDay 5\t Day 6\t Day 7\tAverage");
        double weeklyTotal = 0;

        for (int weekIndex = 0; weekIndex < array.length; weekIndex++) {
            System.out.println("Week " + (weekIndex + 1) + ":");
            
            for (int dayIndex = 0; dayIndex < array[weekIndex].length; dayIndex++) {
                System.out.print("\t" + array[weekIndex][dayIndex]);

                weeklyTotal += array[weekIndex][dayIndex];
            }
            System.out.println((weeklyTotal/array[weekIndex].length));
        }
        input.close();
    }
}