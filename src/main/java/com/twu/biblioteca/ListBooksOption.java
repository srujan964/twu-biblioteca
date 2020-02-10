package com.twu.biblioteca;

// Job: Represent a menu option to list all the books.
public class ListBooksOption implements MenuOption {
    private final UserInterface userInterface;

    public ListBooksOption(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public void execute(Library library) {
        userInterface.displayListOfBooks(library.listBooks());
    }

    @Override
    public String description() {
        return "List of Books";
    }
}
