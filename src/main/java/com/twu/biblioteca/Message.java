package com.twu.biblioteca;

// Job: Represent a message to be displayed to the user.
enum Message {
    WELCOME_GREETING("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"),
    INVALID_OPTION("Please select a valid option!"),
    SUCCESSFUL_CHECKOUT("Thank you! Enjoy the book"),
    UNSUCCESSFUL_CHECKOUT("Sorry, that book is not available"),
    SUCCESSFUL_RETURN("Thank you for returning the book"),
    UNSUCCESSFUL_RETURN("That is not a valid book to return");

    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
