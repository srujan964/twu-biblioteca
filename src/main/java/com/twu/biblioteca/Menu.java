package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {
    private final ArrayList<Command> options;
    private final Library library;

    public Menu(UserInterface userInterface ,Library library) {
        options = new ArrayList<>() {{
            add(new ListBooksOption(userInterface, library));
        }};
        this.library = library;
    }

    public void selectOption(int optionNumber) {
        options.get(optionNumber).execute(library);
    }
}
