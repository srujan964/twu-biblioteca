package com.twu.biblioteca.logic.menu;

import com.twu.biblioteca.logic.*;
import com.twu.biblioteca.logic.UserInterface;

import java.util.ArrayList;

public class Menu {
    private final ArrayList<MenuOption> options;
    private final Library library;
    private final UserInterface userInterface;

    public Menu(ArrayList<MenuOption> options, UserInterface userInterface, Library library) {
        this.options = options;
        this.userInterface = userInterface;
        this.library = library;
    }

    public void selectOption(int optionNumber) {
        if (optionNumber >= options.size()) {
            userInterface.handleInvalidOption();
            return;
        }
        options.get(optionNumber).execute(library);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nMENU:\n");
        for (MenuOption menuOption : options) {
            sb.append(options.indexOf(menuOption) + 1)
                    .append(". ")
                    .append(menuOption.description())
                    .append("\n");
        }
        sb.append("\nSelect an option:");
        return sb.toString();
    }
}
