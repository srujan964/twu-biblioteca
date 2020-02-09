package com.twu.biblioteca;

public class ListBooksOption implements Command {
    private final Library library;

    public ListBooksOption(Library library) {
        this.library = library;
    }

    @Override
    public Object execute() {
        return library.listBooks();
    }
}
