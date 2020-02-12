package com.twu.biblioteca;

import com.twu.biblioteca.logic.Library;
import com.twu.biblioteca.logic.menu.ListBooksOption;
import com.twu.biblioteca.logic.UserInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class ListBooksOptionTest {

    private Library library;
    private ListBooksOption listBooksOption;

    @BeforeEach
    void setUp() {
        library = mock(Library.class);
        UserInterface userInterface = mock(UserInterface.class);
        listBooksOption = new ListBooksOption("List Books", userInterface);
    }

    @Test
    public void shouldListBooks() {
        listBooksOption.execute(library);

        verify(library, times(1)).listBooks();
    }

    @Test
    public void shouldReturnDescription() {
        String expectedDescription = "List Books";

        String actualDescription = listBooksOption.description();

        assertThat(actualDescription, is(equalTo(expectedDescription)));
    }
}