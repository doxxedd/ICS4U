package Search;

import java.util.*;
import java.io.*;

public class Exercise2 {

    static ArrayList<String> list = new ArrayList<>();

    public static void readAndStore() throws Exception {
        File file = new File("wordlist.txt");
        Scanner fileInput = new Scanner(file);

        while(fileInput.hasNext()) {
            list.add(fileInput.nextLine());
        }

        fileInput.close();
    }

    public static boolean binarySearch(ArrayList list, String word) {
        int firstIndex = 0;
        int lastIndex = list.size() - 1;

        while (firstIndex <= lastIndex) { //if theres nothing between the first and last element (no middle)
            int m = firstIndex + (lastIndex - firstIndex) / 2;

            if (word.equals(list.get(m))) return true;

            if (word.compareTo(list.get(m).toString()) <  0) lastIndex = m - 1;
            else firstIndex = m + 1;
        }
        return false;
    }

    /**
     * @param firstIndex Give it -1 for auto configuration.
     * @param lastIndex  Give it -1 for auto configuration.
    */
    public static boolean binarySearchRecursive(ArrayList list, String word, int firstIndex, int lastIndex) {
        // Autoconfig
        if(firstIndex  == -1 || lastIndex == -1){
            firstIndex = 0;
            lastIndex = list.size() - 1;
        }

        if(firstIndex <= lastIndex){
            int m = firstIndex + (lastIndex - firstIndex) / 2;

            if (word.equals(list.get(m))) return true;
    
            if (word.compareTo(list.get(m).toString()) <  0) return binarySearchRecursive(list, word, firstIndex, m - 1);
            else return binarySearchRecursive(list, word, m + 1, lastIndex);
        }

        return false;
    }
    
    public static void main(String[] args) throws Exception {
        
        readAndStore();

        Scanner input = new Scanner(System.in);


        System.out.println("Enter your word to be searched: ");
        String word = input.nextLine();

        if (!binarySearchRecursive(list, word, -1, -1)){
            System.out.println("does not exist");
        } else System.out.println("exists");

        if (!binarySearch(list, word)){
            System.out.println("does not exist");
        } else System.out.println("exists");
    }
}