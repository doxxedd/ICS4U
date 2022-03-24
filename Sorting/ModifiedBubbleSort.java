package Sorting;

public class ModifiedBubbleSort {
    public static void bubbleSort (int [] list) {
        boolean swapped = true;
        int j = 0; //pass counter
        int temp;
        int n = list.length;

        while (swapped) {
            swapped = false; //reset this for every pass
            j++;
            for (int i = 0; i < (n-j); i++) { // #passes = n-1
                if (list[i] > list [i + 1]) { //# of comparisons = n(n-1)/2
                    temp = list[i];
                    list[i] = list [j + 1];
                    list[i + 1] = temp;
                    swapped = true; //swap was made
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 2, 6, 1};
        bubbleSort(array);
        
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}