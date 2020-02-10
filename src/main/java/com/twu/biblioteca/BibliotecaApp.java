package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp implements UserInterface {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }

    public void start() {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        System.out.println(library.greet() + "\n");

        Menu menu = new Menu(this, library);
        do {
            printMenu();
            while (!scanner.hasNextInt()) {
                scanner.next();
                printMenu();
            }
            int option = scanner.nextInt();
            if (option == 1) {
                menu.selectOption(option - 1);
            }
        } while (true);
    }

    private static void printMenu() {
        System.out.println("\nMENU");
        System.out.println("1. List Books.");
        System.out.println("\nSelect an option: ");
    }

    @Override
    public void displayListOfBooks(ArrayList<Book> books) {
        System.out.println("\nList Of Books:\n");
        System.out.printf("\t%20s\t|\t%20s\t|%10s\n\n", "Title", "Author", "Year Published");
        for (Book book : books) {
            System.out.printf("\t%20s\t|\t%20s\t|\t\t%10d\n",
                    book.getTitle(), book.getAuthor(), book.getYearPublished());
        }
    }
}
