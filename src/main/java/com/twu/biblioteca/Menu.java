package com.twu.biblioteca;

public class Menu {

    public void selectOption(Command command) {
        command.execute();
    }
}
