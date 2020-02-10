package com.twu.biblioteca;

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
