package OOP;

import java.util.*;

public class DemoMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Demo xmasTree = new Demo("Christmas Tree", 12345, 299.99);

        System.out.println("Product name: " + xmasTree.getName());
        System.out.println("Barcode: " + xmasTree.getBarcode());
        System.out.println("Price: " + xmasTree.getPrice());



        System.out.println("Enter product name: ");
        String name = input.nextLine();

        System.out.println("Enter product barcode: ");
        int barCode = input.nextInt();

        System.out.println("Enter product price: $ ");
        double price = input.nextDouble();

        Demo userProduct = new Demo(name, barCode, price);

        System.out.println("\nProduct name: " + userProduct.getName());
        System.out.println("Product barcode: " + userProduct.getBarcode());
        System.out.println("Product price: " + userProduct.getPrice());


        input.close();
    }
}
