/*
* Author: Daniel Dinari
* Teacher: Ms. Andreghetti 
* Date: Sept 27, 2020
* Description: Creating a menu driven program that will run any method described below.
*/

package G11_review;
import java.util.*;
public class Level3aArrayExercises {

    static Scanner input = new Scanner(System.in); //global scanner

    public static void noDuplicates(int[] array) 
    {
        boolean duplicate;
        int counter = 1;

        while (counter <= array.length) 
        { //runs the loop while nums still need to be entered
            duplicate = false;
            
            System.out.println("Enter a number:"); //getting data
            int response = Integer.parseInt(input.nextLine());

            for (int i = 0; i <= counter - 2; i++) 
            { //getting data within the accepted range
                if (response == array[i]) 
                { //duplicate
                    duplicate = true;
                    break;
                }
            }
            if (duplicate) { //if duplicate is found
                System.out.println("Number already entered. Enter a unique number: ");
            }
            else { //if there is no duplicate, continue as usual
                array[counter - 1] = response;
                counter++;
            }
        }
        System.out.println("Your numbers are: \n" + Arrays.toString(array) + "\n"); //printing final array without duplicates
    }

    public static int[] randomNoDuplicates(int min, int max) {
        Random randGen = new Random();
        int[] temp = new int[10];
        int tempNum = 0;
        boolean hadDuplicate = false;
        for (int i = 0; i < temp.length; i++) 
        {
            hadDuplicate = false;
            tempNum = randGen.nextInt(max) + min;
            for (int j : temp) { 
                if(j == tempNum) //check if the array contains the randgen number
                {
                    hadDuplicate =true;
                    i--; //redoing the above for loop
                    break;
                }
            }
            if (!hadDuplicate) {
                temp[i] = tempNum; //setting the ith element = the new tempNum
            }
        }
        return temp;
    }

    public static void enterAndCount(int[] array) {
        
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter 4 unique numbers:");
            int response = Integer.parseInt(input.nextLine());
            response = array[i];
        }
        
    }

    public static void randomOrder(String one, String two, String three, String four, String five) {

        ArrayList<String> names = new ArrayList<String>(); //array list of the names
        names.add(one); 
        names.add(two); 
        names.add(three); 
        names.add(four); 
        names.add(five);
        
        Collections.shuffle(names); //collections.shuffle randomizes the list
        System.out.println(names);
    }

    public static String threeRandomOrder(String one, String two, String three, String four, String five) {   

        ArrayList<ArrayList<String>> names = new ArrayList<ArrayList<String>>(); //2D arraylist of the names
        //three different lists inside the big list
        names.add(new ArrayList<String>()); 
        names.add(new ArrayList<String>()); 
        names.add(new ArrayList<String>());

        for (int i = 0; i < 3; i++) //fills up everysingle array
        {
            names.get(i).add(one); 
            names.get(i).add(two);
            names.get(i).add(three); 
            names.get(i).add(four); 
            names.get(i).add(five);
        }
        Collections.shuffle(names.get(0)); // randomizes the first list
        
        do 
        {
            Collections.shuffle(names.get(1)); //randomize the second list
        }
        while(names.get(0).get(0) == names.get(1).get(0) || names.get(0).get(4) == names.get(1).get(4)); //if the FIRST element of both 1st and 2nd list OR the LAST element of both 1st and 2nd list are equal

        do
        {
            Collections.shuffle(names.get(2)); //randomize the third list
        }
        while(names.get(0).get(0) == names.get(2).get(0) || names.get(0).get(4) == names.get(2).get(4) || names.get(1).get(0) == names.get(2).get(0) || names.get(1).get(4) == names.get(2).get(4));
        //if the FIRST element of the 3rd list equals to either the FIRST element of the 1st or 2nd list, OR if the LAST element of the 3rd list equals to either the LAST element of the 1st or 2nd list
        
        String response = "Here are the divers:\n\n"; 
        for (ArrayList<String> sList : names) { //goes through the 3 lists inside the big list
            for (String s : sList) { //goes through the strings of every list
                response += s + " "; //and adds them to the response with a space
            }
            response += "\n\n"; //adds 2 line breaks after every list 
        }
        return response;
    }

    public static void main(String[] args) {
        int[] array = new int[7]; //for noDuplicates

        boolean stillRunning = true;

        while (stillRunning) {
            System.out.println("What do you want to do:\n \nnoDuplicates \nrandomNoDuplicates \nrandomOrder \nthreeRandomOrder \nexit \n");
            String response = input.nextLine();

            switch (response) //reacting to user menu choice
            {
                case "noDuplicates":
                    noDuplicates(array);
                    break;
                
                case "randomNoDuplicates":
                    System.out.println("Enter the min range for random gen:");
                    int responseMin = Integer.parseInt(input.nextLine());
                    System.out.println("Enter the max range for random gen:");
                    int responseMax = Integer.parseInt(input.nextLine());
                    System.out.println("Your random numbers are:");
                    for (int i : randomNoDuplicates(responseMin, responseMax)) {
                        System.out.println(i);
                    }
                    break;

                case "enterAndCount":
                    //enterAndCount();
                    break;
                    
                case "randomOrder":
                    System.out.println("Enter diver #1's name:");
                    String response1 = input.nextLine();
                    System.out.println("Enter diver #2's name:");
                    String response2 = input.nextLine();
                    System.out.println("Enter diver #3's name:");
                    String response3 = input.nextLine();
                    System.out.println("Enter diver #4's name:");
                    String response4 = input.nextLine();
                    System.out.println("Enter diver #5's name:");
                    String response5 = input.nextLine();
                    
                    System.out.println("Your new order is:" );
                    randomOrder(response1, response2, response3, response4, response5);
                    System.out.println("\n");
                    break;
                
                case "threeRandomOrder":
                    System.out.println("Enter diver #1's name:");
                    String response6 = input.nextLine();
                    System.out.println("Enter diver #2's name:");
                    String response7 = input.nextLine();
                    System.out.println("Enter diver #3's name:");
                    String response8 = input.nextLine();
                    System.out.println("Enter diver #4's name:");
                    String response9 = input.nextLine();
                    System.out.println("Enter diver #5's name:");
                    String response10 = input.nextLine();
                    
                    System.out.println(threeRandomOrder(response6, response7, response8, response9, response10));
                    break;
                
                case "exit":
                    System.out.println("Exiting...");
                    stillRunning = false;
                    break;
                
                default: //else
                    System.out.println("Unknown command.");
                    break;
            }
        }
    }
}