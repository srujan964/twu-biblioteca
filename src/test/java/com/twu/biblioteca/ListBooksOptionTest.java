package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class ListBooksOptionTest {

    private Library library;
    private UserInterface userInterface;
    private ListBooksOption listBooksOption;

    @BeforeEach
    void setUp() {
        library = mock(Library.class);
        userInterface = mock(UserInterface.class);
        listBooksOption = new ListBooksOption(userInterface);
    }

    @Test
    public void shouldListBooks() {
        listBooksOption.execute(library);

        verify(library, times(1)).listBooks();
    }

    @Test
    public void shouldReturnDescription() {
        String expectedDescription = "List of Books";

        String actualDescription = listBooksOption.description();

        assertThat(actualDescription, is(equalTo(expectedDescription)));
    }
}