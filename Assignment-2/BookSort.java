//Problem Statement:
//4 Sort Book objects using Comparable and Comparator interfaces 
import java.util.*;

// Book class implementing Comparable
class Book implements Comparable<Book> {

    int id;
    String title;
    double price;

    Book(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    // Comparable method (sort by title)
    public int compareTo(Book b) {
        return this.title.compareTo(b.title);
    }

    public String toString() {
        return id + " " + title + " " + price;
    }
}

// Comparator class (sort by price)
class PriceComparator implements Comparator<Book> {

    public int compare(Book b1, Book b2) {
        if (b1.price > b2.price)
            return 1;
        else if (b1.price < b2.price)
            return -1;
        else
            return 0;
    }
}

public class BookSort {

    public static void main(String[] args) {

        ArrayList<Book> list = new ArrayList<>();

        list.add(new Book(101, "APTITUDE", 500));
        list.add(new Book(102, "DATA-INTERPRETATION", 450));
        list.add(new Book(103, "LOGICAL REASONINING", 400));

        System.out.println("Sorting using Comparable (Title):");
        Collections.sort(list);

        for (Book b : list) {
            System.out.println(b);
        }

        System.out.println("\nSorting using Comparator (Price):");
        Collections.sort(list, new PriceComparator());

        for (Book b : list) {
            System.out.println(b);
        }
    }
}