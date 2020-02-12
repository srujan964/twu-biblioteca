package com.twu.biblioteca.logic;

import com.twu.biblioteca.consoleui.Console;
import com.twu.biblioteca.logic.menu.*;

import java.util.ArrayList;
import java.util.Scanner;

// Job: Represent the command-line interface of Biblioteca.
public class BibliotecaApp {
    private UserInterface userInterface;
    private final Menu menu;

    public BibliotecaApp(UserInterface userInterface, Menu menu) {
        this.userInterface = userInterface;
        this.menu = menu;
    }

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        Console console = new Console(scanner);

        ArrayList<MenuOption> options = new ArrayList<>();
        options.add(new ListBooksOption("List Books", console));
        options.add(new CheckOutBookOption("Checkout a book", console));
        options.add(new ReturnBookOption("Return a book", console));
        options.add(new QuitApplicationOption("Quit Application", console));

        Menu menu = new Menu(options, console, library);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(console, menu);
        bibliotecaApp.start();
    }

    public void start() {
        userInterface.displayWelcomeGreeting();

        //noinspection InfiniteLoopStatement
        do {
            userInterface.displayMenu(menu);
            int option = userInterface.getOption(menu);
            menu.selectOption(option - 1);
        } while (true);
    }
}
