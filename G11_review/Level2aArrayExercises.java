/*
* Author: Daniel Dinari
* Teacher: Ms. Andreghetti 
* Date: Sept 23, 2020
* Description: menu driven program that will run each corresponding method depending on user input
*/

package G11_review;
import java.util.*;

public class Level2aArrayExercises {

    static Scanner input = new Scanner(System.in); //global scanner

    public static void enterFromKeyboard(int[] arrayInputed) 
    {
        for (int i = 0; i < arrayInputed.length; i++)
        {
            System.out.println("Enter an integer: (or input \"-111\" to stop inputting)");
            
            int response = Integer.parseInt(input.nextLine()); //doing this to avoid the enter character not being detected
            if (response == -111) break;
            arrayInputed[i] = response;
        }
    }

    public static int numberOfOccurences(int[] array, int num) {
        int occurences = 0;
        for (int i : array) {
            if (i == -1) continue;
            if (i == num) occurences++; //increases the counter
        }
        return occurences;
    }

    public static void initializeArray(int[] arrayInMethod) 
    {
        for (int i = 0; i < arrayInMethod.length; i++) 
        {
            arrayInMethod[i] = -1; //filling array with -1s
        }
    }

    public static int countWhole(int[] array) {
        int counter = 0;
        for (int i : array) {
            if (i >= 0) {
                counter++; //counting positive values entered
            }
        }
       
        return counter;
    }

    public static String display(int[] array) {
        String arrayInString = "";
        for (int i : array) {
            if (i == -1) continue; //ignores displaying -1s if user entered less than 10 values
            arrayInString += i + " "; //displaying all values
        }
        return arrayInString; 
    }

    public static String displayReverse(int[] array) {
        String arrayInString = "";
        for (int i : array) {
            if (i == -1) continue;
            arrayInString = i + " " + arrayInString; //displays ints in reverse order
        }
        return arrayInString; 
    }

    public static int sum(int[] array) {
        int sum = 0;
        for (int i : array) {
            if (i == -1) continue;
            sum += i; //stacks all nums entered
        }
        return sum; 
    }
    
    public static int avg(int[] array) {
        int sum = 0;
        for (int i : array) {
            if (i == -1) continue;
            sum += i;
        }
        return sum / array.length; //returns avg
    }

    public static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i : array) {
            if (i == -1) continue;
            if (i < min) min = i; //replaces min with lowest num
        }
        return min;
    }
    
    public static int findMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            if (i == -1) continue;
            if (i > max) max = i; //replaces min with highest num
        }
        return max;
    }

    public static int[] search(int[] array, int numToBeSearched){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) continue;
            if (array[i] == numToBeSearched) list.add(i); //adding the index of the element in the array, if nothing was added, number wasnt in the array.
        }

        return list.stream().mapToInt(i -> i).toArray(); //copied from stackoverflow i didnt know any other way to convert the listarray to array
    }

    public static void main(String[] args)
    {
        int[] array = new int[10];
        
        initializeArray(array);
        enterFromKeyboard(array);

        boolean stillRunning = true;

        while (stillRunning) {
            System.out.println("What do you want to do:\n \ncountWhole \ndisplay \ndisplayReverse \nsum \navg \nfindMax \nfindMin \nsearch \nexit");
            String response = input.nextLine();

            switch (response) //reacting to user menu choice
            {
                case "countWhole":
                    System.out.println("Amount of whole numbers entered: " + countWhole(array));
                    break;
                case "display":
                    System.out.println("Values entered: " + display(array));
                    break;
                case "displayReverse":
                    System.out.println("Values entered in reverse: " + displayReverse(array));
                    break;
                case "sum":
                    System.out.println("Sum is: " + sum(array));
                    break;
                case "avg":
                    System.out.println("Average is: " + avg(array));
                    break;
                case "findMin":
                    System.out.println("Minimum value is: " + findMin(array) + "\n# of occurences of this number is: " + numberOfOccurences(array, findMin(array)));
                    break;
                case "findMax":
                    System.out.println("Maximum value is: " + findMax(array) + "\n# of occurences of this number is: " + numberOfOccurences(array, findMax(array)));
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    stillRunning = false;
                    break;
                case "search":
                    String output = "";
                    System.out.println("Enter the number to be searched: ");
                    int response3 = Integer.parseInt(input.nextLine());
                    
                    int[] arrayTemp = search(array, response3);
                    if (arrayTemp.length == 0) {
                        System.out.println("Invalid number");
                    } else {
                        for (int i : arrayTemp) {
                            output += i + ", "; //separating the index position 
                        }
                        System.out.println("Your number " + response3 + " was found on index(s)" + output);
                    }
    
                    break;
                default: //else
                    System.out.println("Unknown command.");
                    break;
            }
        }
    }
}