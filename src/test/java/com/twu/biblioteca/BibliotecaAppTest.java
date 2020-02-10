package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class BibliotecaAppTest {

    @Test
    public void shouldSelectListBooksMenuOption() {
        UserInterface userInterface = mock(UserInterface.class);
        Library library = mock(Library.class);
        Menu menu = new Menu(userInterface, library);

        menu.selectOption(0);

        verify(library, times(1)).listBooks();
    }
}