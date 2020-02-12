package com.twu.biblioteca.logic.menu;

import com.twu.biblioteca.logic.Library;

// Represent a menu option.
public abstract class MenuOption {
    private final String description;

    public MenuOption(String description) {
        this.description = description;
    }

    abstract void execute(Library library);

    public final String description() {
        return this.description;
    }
}
