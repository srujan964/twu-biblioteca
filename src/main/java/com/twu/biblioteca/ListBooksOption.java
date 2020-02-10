package com.twu.biblioteca;

public class ListBooksOption implements Command {
    private final UserInterface userInterface;

    public ListBooksOption(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public void execute(Library library) {
        userInterface.displayListOfBooks(library.listBooks());
    }
}
