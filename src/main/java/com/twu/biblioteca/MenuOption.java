package com.twu.biblioteca;

// Represent a menu option.
public interface MenuOption {
    void execute(Library library);

    String description();
}
