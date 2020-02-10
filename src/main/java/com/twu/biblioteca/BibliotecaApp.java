package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

import static com.twu.biblioteca.Message.WELCOME_GREETING;

public class BibliotecaApp implements UserInterface {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }

    public void start() {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        System.out.println(WELCOME_GREETING.getValue() + "\n");

        Menu menu = new Menu(this, library);
        do {
            System.out.println(menu);
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println(Message.INVALID_OPTION.getValue());
                System.out.println(menu);
            }
            int option = scanner.nextInt();
            menu.selectOption(option - 1);
        } while (true);
    }

    public void quit() {
        System.exit(0);
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
