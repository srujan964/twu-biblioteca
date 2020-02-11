package com.twu.biblioteca;

import com.twu.biblioteca.logic.exceptions.UnknownBookException;
import com.twu.biblioteca.logic.Book;
import com.twu.biblioteca.logic.menu.CheckOutBookOption;
import com.twu.biblioteca.logic.Library;
import com.twu.biblioteca.logic.UserInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class CheckOutBookOptionTest {

    private Library library;
    private UserInterface userInterface;
    private CheckOutBookOption checkOutBookOption;

    @BeforeEach
    void setUp() {
        library = mock(Library.class);
        userInterface = mock(UserInterface.class);
        checkOutBookOption = new CheckOutBookOption(userInterface);
    }

    @Test
    public void shouldCheckoutBook() throws UnknownBookException {
        Book book = mock(Book.class);
        when(userInterface.promptForBookName()).thenReturn("Pet Sematary");
        when(library.findInAvailable(
                userInterface.promptForBookName()
        )).thenReturn(book);

        checkOutBookOption.execute(library);

        verify(library, times(1)).checkout(book);
    }

    @Test
    public void shouldReturnDescription() {
        String expectedDescription = "Checkout a book";

        String actualDescription = checkOutBookOption.description();

        assertThat(actualDescription, is(equalTo(expectedDescription)));
    }
}