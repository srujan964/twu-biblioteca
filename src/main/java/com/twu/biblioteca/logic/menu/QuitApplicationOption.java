package com.twu.biblioteca.logic.menu;

import com.twu.biblioteca.logic.UserInterface;
import com.twu.biblioteca.logic.Library;

public class QuitApplicationOption extends MenuOption {
    private final UserInterface userInterface;

    public QuitApplicationOption(String description, UserInterface userInterface) {
        super(description);
        this.userInterface = userInterface;
    }

    @Override
    public void execute(Library library) {
        userInterface.quit();
    }
}
