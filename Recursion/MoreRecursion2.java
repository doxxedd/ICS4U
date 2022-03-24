package Recursion;

public class MoreRecursion2 {
    public static int addUp (int [] list, int index) {
        if (index == 0) {
            return list[index];
        } else {
            return list[index] + addUp(list, index-1);
        }
    }
}
