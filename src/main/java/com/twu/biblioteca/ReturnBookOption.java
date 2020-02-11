package com.twu.biblioteca;

// Job: Represent a menu option to return a book.
public class ReturnBookOption implements MenuOption {
    private final UserInterface userInterface;

    public ReturnBookOption(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public void execute(Library library) {
        String bookTitle = userInterface.promptForBookName();
        Book book = library.findInCheckedOut(bookTitle);
        library.returnBook(book);
    }

    @Override
    public String description() {
        return "Return a book";
    }
}
