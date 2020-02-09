package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        System.out.println(library.greet() + "\n");

        ArrayList<Book> books = library.listBooks();
        System.out.println("List of Books:\n");
        System.out.printf("\t%20s\t|\t%20s\t|\t%10s\n\n", "Title", "Author", "Year Published");
        for (Book book : books) {
            System.out.printf("\t%20s\t|\t%20s\t|\t\t%10d\n",
                    book.getTitle(), book.getAuthor(), book.getYearPublished());
        }
    }
}
