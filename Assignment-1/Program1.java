//Problem statement
//Write a Java program to perform array and string operations such as reverse, sort, search, average, and 
//finding the maximum element using classes and objects.
import java.util.Scanner;

// Class to perform different array operations
class ArrayOperations {

    int[] arr; // Array to store elements
    int n; // Number of elements

    // Method to take input from user
    void input() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        n = sc.nextInt();

        arr = new int[n]; // Create array

        System.out.println("Enter array elements:");

        // Loop to read array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }

    // Method to display reversed array
    void reverse() {
        System.out.print("Reversed Array: ");

        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    // Method to sort the array using simple bubble sort
    void sort() {

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (arr[i] > arr[j]) {

                    // Swap elements
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.print("Sorted Array: ");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    // Method to calculate average of array elements
    void average() {

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        double avg = (double) sum / n;

        System.out.println("Average = " + avg);
    }

    // Method to find maximum element
    void maximum() {

        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Maximum element = " + max);
    }

    // Method to search element in array
    void search(int key) {

        for (int i = 0; i < n; i++) {

            if (arr[i] == key) {
                System.out.println("Element found at position: " + (i + 1));
                return;
            }
        }

        System.out.println("Element not found");
    }
}

// Main class
public class Program1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Creating object of ArrayOperations class
        ArrayOperations obj = new ArrayOperations();

        // Calling methods
        obj.input();
        obj.reverse();
        obj.sort();
        obj.average();
        obj.maximum();

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        obj.search(key);

        sc.close(); // Close scanner
    }
}