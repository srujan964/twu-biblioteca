package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

import static com.twu.biblioteca.Message.WELCOME_GREETING;

// Job: Represent the command-line interface of Biblioteca.
public class BibliotecaApp implements UserInterface {
    Scanner scanner;

    public BibliotecaApp() {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }

    public void start() {
        Library library = new Library();
        System.out.println(WELCOME_GREETING.getValue());

        Menu menu = new Menu(this, library);
        do {
            System.out.println(menu);
            int option = getOption(menu);
            menu.selectOption(option - 1);
        } while (true);
    }

    public void quit() {
        scanner.close();
        System.exit(0);
    }

    private int getOption(Menu menu) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println(Message.INVALID_OPTION.getValue());
            System.out.println(menu);
        }
        return scanner.nextInt();
    }

    @Override
    public String promptForBookName() {
        System.out.println("\nEnter the name of the book to checkout:");
        scanner.nextLine();
        return scanner.nextLine();
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayListOfBooks(ArrayList<Book> books) {
        System.out.println("\nList Of Books:\n");
        System.out.printf("\t%20s\t|\t%20s\t|\t%10s\n\n", "Title", "Author", "Year Published");
        for (Book book : books) {
            System.out.printf("\t%20s\t|\t%20s\t|\t\t%10d\n",
                    book.getTitle(), book.getAuthor(), book.getYearPublished());
        }
    }
}
