package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MenuTest {

    @Test
    public void shouldSelectListBooksMenuOption() {
        UserInterface userInterface = mock(UserInterface.class);
        Library library = mock(Library.class);
        Menu menu = new Menu(userInterface, library);

        menu.selectOption(0);

        verify(library, times(1)).listBooks();
    }

    @Test
    public void shouldQuitApplication() {
        UserInterface userInterface = mock(UserInterface.class);
        Library library = mock(Library.class);
        Menu menu = new Menu(userInterface, library);

        menu.selectOption(1);

        verify(userInterface, times(1)).quit();
    }
}