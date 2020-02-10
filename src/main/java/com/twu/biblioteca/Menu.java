package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {
    private final ArrayList<Command> options;
    private final Library library;
    private final UserInterface userInterface;

    public Menu(UserInterface userInterface, Library library) {
        this.userInterface = userInterface;
        options = new ArrayList<>() {{
            add(new ListBooksOption(userInterface));
            add(new CheckOutBookOption(userInterface));
            add(new QuitApplicationOption(userInterface));
        }};
        this.library = library;
    }

    public void selectOption(int optionNumber) {
        if (optionNumber >= options.size()) {
            userInterface.displayMessage(Message.INVALID_OPTION.getValue());
            return;
        }
        options.get(optionNumber).execute(library);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nMENU:\n");
        for (Command command : options) {
            sb.append(options.indexOf(command) + 1)
                    .append(". ")
                    .append(command.description())
                    .append("\n");
        }
        sb.append("\nSelect an option:");
        return sb.toString();
    }
}
