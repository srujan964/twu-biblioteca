package com.twu.biblioteca;

public class CheckOutBookOption implements Command {
    private final UserInterface userInterface;

    public CheckOutBookOption(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public void execute(Library library) {
        String bookTitle = userInterface.promptForBookName();
        Book book = library.find(bookTitle);
        library.checkout(book);
    }

    @Override
    public String description() {
        return "Checkout a book";
    }
}
