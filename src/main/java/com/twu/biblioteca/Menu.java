package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {
    private final ArrayList<MenuOption> options;
    private final Library library;
    private final UserInterface userInterface;

    public Menu(UserInterface userInterface, Library library) {
        this.userInterface = userInterface;
        options = new ArrayList<>() {{
            add(new ListBooksOption(userInterface));
            add(new CheckOutBookOption(userInterface));
            add(new ReturnBookOption(userInterface));
            add(new QuitApplicationOption(userInterface));
        }};
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
