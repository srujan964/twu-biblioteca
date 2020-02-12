package com.twu.biblioteca.consoleui;

import com.twu.biblioteca.logic.Book;
import com.twu.biblioteca.logic.Message;
import com.twu.biblioteca.logic.UserInterface;
import com.twu.biblioteca.logic.menu.Menu;

import java.util.ArrayList;
import java.util.Scanner;

import static com.twu.biblioteca.logic.Message.*;

public class Console implements UserInterface {
    private Scanner scanner;

    public Console(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void handleInvalidOption() {
        System.out.println(INVALID_OPTION);
    }

    @Override
    public void handleSuccessfulCheckout() {
        System.out.println(Message.SUCCESSFUL_CHECKOUT);
    }

    @Override
    public void handleUnsuccessfulCheckout() {
        System.out.println(Message.UNSUCCESSFUL_CHECKOUT);
    }

    @Override
    public void handleSuccessfulReturn() {
        System.out.println(Message.SUCCESSFUL_RETURN);
    }

    @Override
    public void handleUnsuccessfulReturn() {
        System.out.println(UNSUCCESSFUL_RETURN);
    }

    @Override
    public int getOption(Menu menu) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println(INVALID_OPTION);
            System.out.println(menu);
        }
        return scanner.nextInt();
    }

    @Override
    public String promptForBookName() {
        System.out.println("\nEnter the name of the book:");
        scanner.nextLine();
        return scanner.nextLine();
    }

    @Override
    public void quit() {
        scanner.close();
        System.exit(0);
    }

    @Override
    public void displayWelcomeGreeting() {
        System.out.println(WELCOME_GREETING);
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

    @Override
    public void displayMenu(Menu menu) {
        System.out.println(menu);
    }
}
