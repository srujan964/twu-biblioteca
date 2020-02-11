package com.twu.biblioteca;

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
        returnBookOption = new ReturnBookOption(userInterface);
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