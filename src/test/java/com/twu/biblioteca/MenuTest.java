package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MenuTest {

    private UserInterface userInterface;
    private Library library;
    private Menu menu;

    @BeforeEach
    void setUp() {
        userInterface = mock(UserInterface.class);
        library = mock(Library.class);
        menu = new Menu(userInterface, library);
    }

    @Test
    public void shouldSelectListBooksMenuOption() {
        menu.selectOption(0);

        verify(library, times(1)).listBooks();
    }

    @Test
    public void shouldQuitApplication() {
        menu.selectOption(2);

        verify(userInterface, times(1)).quit();
    }

    @Test
    public void shouldExecuteCheckoutMenuOption() {
        menu.selectOption(1);
        when(userInterface.promptForBookName()).thenReturn("Pet Sematary");

        verify(library, times(1))
                .checkout(null);
    }
}