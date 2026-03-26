// Program to demonstrate Wrapper Classes and String vs StringBuffer
//Problem Statement:
//Write a Java program demonstrating the use of Wrapper Classes and explaining the difference between String and StringBuffer.
public class Program3 {

    public static void main(String[] args) {

        // ----- Wrapper Class Demonstration -----

        int num = 10;

        // Converting primitive to Wrapper object (Autoboxing)
        Integer obj = num;

        System.out.println("Primitive value: " + num);
        System.out.println("Wrapper Object value: " + obj);

        // Converting Wrapper object back to primitive (Unboxing)
        int value = obj;

        System.out.println("Unboxed value: " + value);

        System.out.println();

        // ----- String Demonstration -----

        String str = "Hello";

        // String is immutable (creates new object)
        str = str + " Java";

        System.out.println("String after concatenation: " + str);

        System.out.println();

        // ----- StringBuffer Demonstration -----

        StringBuffer sb = new StringBuffer("Hello");

        // StringBuffer is mutable (same object modified)
        sb.append(" Java");

        System.out.println("StringBuffer after append: " + sb);

        System.out.println();

        // Showing length and capacity
        System.out.println("Length of StringBuffer: " + sb.length());
        System.out.println("Capacity of StringBuffer: " + sb.capacity());
    }
}