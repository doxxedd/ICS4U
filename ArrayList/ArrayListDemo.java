package ArrayList;

import java.util.*;

public class ArrayListDemo {
    public static void main(final String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("Word");
        list.add("Word1");
        list.add("Word2");

        System.out.println("Size of the list = " + list.size() + "\n");

        // methods for printing
        for (int i = 0; i < list.size(); i++) { // for i
            System.out.println(list.get(i));
        }

        for (String str : list) { // for each
            System.out.println(str);
        }

        Iterator iterator = list.iterator(); //
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "\n"); 
        }
    }
}
