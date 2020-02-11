package com.twu.biblioteca.logic.menu;

import com.twu.biblioteca.logic.Library;

// Represent a menu option.
public interface MenuOption {
    void execute(Library library);

    String description();
}
