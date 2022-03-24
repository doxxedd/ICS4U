package Recursion;

public class MoreRecursion1 {
    public static String laugh(int n) {
        if (n == 0) {
            return ""; //returning the empty string
        } else {
            return "HA" + laugh (n-1);
        }
    }
    public static void main(String[] args) {
        System.out.println("");
    }
}