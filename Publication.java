package oop;

import java.util.Scanner;

// Parent Class
class PublicationMain {

    String title;
    double price;
    int copies;

    PublicationMain(String title, double price, int copies) {
        this.title = title;
        this.price = price;
        this.copies = copies;
    }

    // Common method to calculate sales
    double saleCopy() {
        return price * copies;
    }

    void display() {
        System.out.println("Title: " + title);
        System.out.println("Price: " + price);
        System.out.println("Copies Sold: " + copies);
    }
}


// Child Class - Book
class Book extends PublicationMain {

    String author;

    Book(String title, double price, int copies, String author) {
        super(title, price, copies);
        this.author = author;
    }

    // Method to order additional book copies
    void orderCopies(int quantity) {
        copies = copies + quantity;
        System.out.println(quantity + " copies ordered successfully.");
    }

    void displayBook() {
        display();
        System.out.println("Author: " + author);
    }
}


// Child Class - Magazine
class Magazine extends PublicationMain {

    int orderQty;
    String currentIssue;

    Magazine(String title, double price, int copies,
             int orderQty, String currentIssue) {

        super(title, price, copies);
        this.orderQty = orderQty;
        this.currentIssue = currentIssue;
    }

    // Method to receive a new issue
    void receiveIssue(String issue) {
        currentIssue = issue;
        System.out.println("New issue received: " + currentIssue);
    }

    void displayMagazine() {
        display();
        System.out.println("Order Quantity: " + orderQty);
        System.out.println("Current Issue: " + currentIssue);
    }
}


// Main Class
public class Publication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create Book object
        Book book = new Book(
                "Java Programming",
                500,
                10,
                "Herbert Schildt"
        );

        // Create Magazine object
        Magazine magazine = new Magazine(
                "Technology Today",
                100,
                20,
                30,
                "August 2026"
        );

        System.out.println("BOOK DETAILS");
        book.displayBook();

        // Order book copies
        System.out.print("\nEnter number of book copies to order: ");
        int quantity = sc.nextInt();

        book.orderCopies(quantity);

        System.out.println("\nUpdated Book Details:");
        book.displayBook();

        // Display magazine details
        System.out.println("\nMAGAZINE DETAILS");
        magazine.displayMagazine();

        // Calculate total publication sales
        double totalSales =
                book.saleCopy() + magazine.saleCopy();

        System.out.println("\nBook Sales: Rs. " + book.saleCopy());
        System.out.println("Magazine Sales: Rs. " + magazine.saleCopy());
        System.out.println("Total Publication Sales: Rs. " + totalSales);

        sc.close();
    }
}
