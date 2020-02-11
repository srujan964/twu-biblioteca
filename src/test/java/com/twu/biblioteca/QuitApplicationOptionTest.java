package com.twu.biblioteca;

import com.twu.biblioteca.logic.Library;
import com.twu.biblioteca.menu.QuitApplicationOption;
import com.twu.biblioteca.ui.UserInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

class QuitApplicationOptionTest {

    private Library library;
    private UserInterface userInterface;
    private QuitApplicationOption quitApplicationOption;

    @BeforeEach
    void setUp() {
        library = mock(Library.class);
        userInterface = mock(UserInterface.class);
        quitApplicationOption = new QuitApplicationOption(userInterface);
    }

    @Test
    public void shouldQuitTheApplication() {
        quitApplicationOption.execute(library);

        verify(userInterface, times(1)).quit();
    }

    @Test
    public void shouldReturnDescription() {
        String expectedDescription = "Quit Application";

        String actualDescription = quitApplicationOption.description();

        assertThat(actualDescription, is(equalTo(expectedDescription)));
    }
}