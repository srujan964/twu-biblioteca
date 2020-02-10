package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp.start();
    }

    public static void start() {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        System.out.println(library.greet() + "\n");

        Menu menu = new Menu();
        do {
            System.out.println("\nMENU");
            System.out.println("1. List Books.");
            System.out.println("\nSelect an option: ");

            int option = scanner.nextInt();
            if (option == 1) {
                ListBooksOption listBooksOption = new ListBooksOption(library);
                menu.selectOption(listBooksOption);
                ArrayList<Book> books = listBooksOption.getResult();
                System.out.println("\nList of Books:\n");
                System.out.printf("\t%20s\t|\t%20s\t|\t%10s\n\n", "Title", "Author", "Year Published");
                for (Book book : books) {
                    System.out.printf("\t%20s\t|\t%20s\t|\t\t%10d\n",
                            book.getTitle(), book.getAuthor(), book.getYearPublished());
                }
            }
        } while (true);
    }
}
