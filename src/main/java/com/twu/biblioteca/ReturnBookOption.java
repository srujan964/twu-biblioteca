package com.twu.biblioteca;

import static com.twu.biblioteca.Message.*;

// Job: Represent a menu option to return a book.
public class ReturnBookOption implements MenuOption {
    private final UserInterface userInterface;

    public ReturnBookOption(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public void execute(Library library) {
        String bookTitle = userInterface.promptForBookName();
        Book book = null;
        try {
            book = library.findInCheckedOut(bookTitle);
        } catch (UnknownBookException e) {
            userInterface.displayMessage(UNSUCCESSFUL_RETURN.getValue());
            return;
        }
        library.returnBook(book);
        userInterface.displayMessage(SUCCESSFUL_RETURN.getValue());
    }

    @Override
    public String description() {
        return "Return a book";
    }
}
