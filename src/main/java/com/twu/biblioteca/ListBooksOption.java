package com.twu.biblioteca;

public class ListBooksOption implements Command {
    private final UserInterface userInterface;
    private final Library library;

    public ListBooksOption(UserInterface userInterface, Library library) {
        this.userInterface = userInterface;
        this.library = library;
    }

    @Override
    public void execute(Library library) {
        userInterface.displayListOfBooks(library.listBooks());
    }
}
