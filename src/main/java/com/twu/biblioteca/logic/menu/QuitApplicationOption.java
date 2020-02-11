package com.twu.biblioteca.logic.menu;

import com.twu.biblioteca.logic.UserInterface;
import com.twu.biblioteca.logic.Library;

public class QuitApplicationOption implements MenuOption {
    private final UserInterface userInterface;

    public QuitApplicationOption(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public void execute(Library library) {
        userInterface.quit();
    }

    @Override
    public String description() {
        return "Quit Application";
    }
}
