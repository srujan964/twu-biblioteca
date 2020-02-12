package com.twu.biblioteca;

import com.twu.biblioteca.logic.exceptions.UnknownBookException;
import com.twu.biblioteca.logic.Book;
import com.twu.biblioteca.logic.Library;
import com.twu.biblioteca.logic.menu.ReturnBookOption;
import com.twu.biblioteca.logic.UserInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class ReturnBookOptionTest {

    private Library library;
    private UserInterface userInterface;
    private ReturnBookOption returnBookOption;

    @BeforeEach
    void setUp() {
        library = mock(Library.class);
        userInterface = mock(UserInterface.class);
        returnBookOption = new ReturnBookOption("Return a book", userInterface);
    }

    @Test
    public void shouldReturnBook() throws UnknownBookException {
        Book book = mock(Book.class);
        when(userInterface.promptForBookName()).thenReturn("Pet Sematary");
        when(library.findInCheckedOut(
                userInterface.promptForBookName()
        )).thenReturn(book);

        returnBookOption.execute(library);

        verify(library, times(1)).returnBook(book);
    }

    @Test
    public void shouldReturnDescription() {
        String expectedDescription = "Return a book";

        String actualDescription = returnBookOption.description();

        assertThat(actualDescription, is(equalTo(expectedDescription)));
    }
}