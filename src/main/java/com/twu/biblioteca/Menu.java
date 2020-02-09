package com.twu.biblioteca;

public class Menu {

    public Object selectOption(Command command) {
        return command.execute();
    }
}
