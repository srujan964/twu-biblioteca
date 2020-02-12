package com.twu.biblioteca;

import com.twu.biblioteca.logic.Library;
import com.twu.biblioteca.logic.UserInterface;
import com.twu.biblioteca.logic.menu.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

class MenuTest {

    private UserInterface userInterface;
    private Library library;
    private Menu menu;
    ListBooksOption listBooksOption;
    CheckOutBookOption checkOutBookOption;
    ReturnBookOption returnBookOption;
    QuitApplicationOption quitApplicationOption;
    ArrayList<MenuOption> options;

    @BeforeEach
    void setUp() {
        userInterface = mock(UserInterface.class);
        library = mock(Library.class);
        listBooksOption = mock(ListBooksOption.class);
        checkOutBookOption = mock(CheckOutBookOption.class);
        returnBookOption = mock(ReturnBookOption.class);
        quitApplicationOption = mock(QuitApplicationOption.class);
        options = mock(ArrayList.class);
        menu = new Menu(options, userInterface, library);
    }

    @Test
    public void shouldSelectListBooksMenuOption() {
        when(options.size()).thenReturn(4);
        when(options.get(0)).thenReturn(listBooksOption);
        menu.selectOption(0);

        verify(listBooksOption, times(1)).execute(library);
    }

    @Test
    public void shouldExecuteCheckoutMenuOption() {
        when(options.size()).thenReturn(4);
        when(options.get(1)).thenReturn(checkOutBookOption);
        menu.selectOption(1);

        verify(checkOutBookOption, times(1)).execute(library);
    }

    @Test
    public void shouldExecuteReturnMenuOption() {
        when(options.size()).thenReturn(4);
        when(options.get(2)).thenReturn(returnBookOption);
        menu.selectOption(2);

        verify(returnBookOption, times(1)).execute(library);
    }


    @Test
    public void shouldQuitApplication() {
        when(options.size()).thenReturn(4);
        when(options.get(3)).thenReturn(quitApplicationOption);
        menu.selectOption(3);

        verify(quitApplicationOption, times(1)).execute(library);
    }
}
