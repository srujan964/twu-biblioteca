package com.twu.biblioteca;

import java.util.ArrayList;

public class ListBooksOption implements Command {
    private final Library library;
    private ArrayList<Book> result;

    public ListBooksOption(Library library) {
        this.library = library;
        result = new ArrayList<>();
    }

    public ArrayList<Book> getResult() {
        return result;
    }

    @Override
    public void execute() {
        result = library.listBooks();
    }
}
