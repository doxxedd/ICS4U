package Tests;
import java.util.*;
public class ArrayFormative1 {

    public static boolean contains(int[] array, int num) {
        for (int i : array) {
            if (i == num) return true;
        }
        
        return false;
    }

    public static void main(String[] args) {
        Random randGen = new Random();
        int randNum;
        int[] array = new int[50];
        int[] digits = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
        // for (int i : array) {
        //     i = -1; //filling -1 because java fills int array 0
        // }

        System.out.println("Numbers generated:");
        for (int i : array) {
            do {
                randNum = randGen.nextInt(51); //0-100
            } while (contains(array, randNum));
            i = randNum;
            
            if (i > 9) {
                digits[i/10]++;
                digits[i%10]++;
            }
            else if (i == 100){
                //digits
            }
             else {digits[i]++;}
            
            System.out.println(i);
        }
        for (int i = 0; i < digits.length; i++) {
            System.out.println("Digit: " + i + "\tfrequency:" + digits[i]);
        }
    } 
}