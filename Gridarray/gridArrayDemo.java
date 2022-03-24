package Gridarray;
import java.util.*;
public class gridArrayDemo {
    public static void main(String[] args) {
        int [][] aGrid = new int[3][4];
        Scanner input = new Scanner(System.in);

        for (int row = 0; row < aGrid.length; row++) {
            for (int col = 0; row < aGrid.length; col++) {
                System.out.println("Enter in a value: ");
                int response = Integer.parseInt(input.nextLine());
            }
        }

        for (int row = 0; row < aGrid.length; row++) {
            for (int col = 0; row < aGrid.length; col++) {
                System.out.println(aGrid + "\t");
            }
            System.out.println();
        }
    }
}