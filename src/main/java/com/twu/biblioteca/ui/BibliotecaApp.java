package com.twu.biblioteca.ui;

import com.twu.biblioteca.logic.Book;
import com.twu.biblioteca.logic.Library;
import com.twu.biblioteca.menu.Menu;
import com.twu.biblioteca.logic.Message;

import java.util.ArrayList;
import java.util.Scanner;

import static com.twu.biblioteca.logic.Message.WELCOME_GREETING;

// Job: Represent the command-line interface of Biblioteca.
public class BibliotecaApp implements UserInterface {
    private Scanner scanner;

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
    public void handleInvalidOption() {
        System.out.println(Message.INVALID_OPTION.getValue());
    }

    @Override
    public void handleSuccessfulCheckout() {
        System.out.println(Message.SUCCESSFUL_CHECKOUT.getValue());
    }

    @Override
    public void handleUnsuccessfulCheckout() {
        System.out.println(Message.UNSUCCESSFUL_CHECKOUT.getValue());
    }

    @Override
    public void handleSuccessfulReturn() {
        System.out.println(Message.SUCCESSFUL_RETURN.getValue());
    }

    @Override
    public void handleUnsuccessfulReturn() {
        System.out.println(Message.UNSUCCESSFUL_RETURN.getValue());
    }

    @Override
    public String promptForBookName() {
        System.out.println("\nEnter the name of the book:");
        scanner.nextLine();
        return scanner.nextLine();
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
