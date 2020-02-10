package com.twu.biblioteca;

import static com.twu.biblioteca.Message.*;

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
        userInterface.displayMessage(SUCCESSFUL_CHECKOUT.getValue());
    }

    @Override
    public String description() {
        return "Checkout a book";
    }
}
