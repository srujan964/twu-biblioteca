package com.twu.biblioteca.logic.menu;

import com.twu.biblioteca.logic.UserInterface;
import com.twu.biblioteca.logic.Library;

// Job: Represent a menu option to list all the books.
public class ListBooksOption extends MenuOption {
    private final UserInterface userInterface;

    public ListBooksOption(String description, UserInterface userInterface) {
        super(description);
        this.userInterface = userInterface;
    }

    @Override
    public void execute(Library library) {
        userInterface.displayListOfBooks(library.listBooks());
    }
}
