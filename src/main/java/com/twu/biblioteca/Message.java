package com.twu.biblioteca;

public enum Message {
    WELCOME_GREETING("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"),
    INVALID_OPTION("Please select a valid option!");
    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
