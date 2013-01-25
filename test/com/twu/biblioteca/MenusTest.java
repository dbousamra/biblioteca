package com.twu.biblioteca;

import com.twu.biblioteca.ui.MenuItem;
import com.twu.biblioteca.ui.UIRunner;
import com.twu.biblioteca.ui.menus.MainMenu;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MenusTest {

//    final ByteArrayOutputStream s

    public ByteArrayOutputStream directOutputStream(){
        ByteArrayOutputStream screenOutput = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(screenOutput);
        System.setOut(ps);
        return screenOutput;
    }
    
    private UIRunner getMockUI() {
        return new UIRunner(new MainMenu(new Library()));
    }

    @Test
    public void canSeeMainMenuOptions() throws Exception {
        MenuItem menu = new MainMenu(new Library());
        String output = menu.output();
        assertThat(output, containsString("Browse Books"));
        assertThat(output, containsString("Exit"));
    }

    @Test
    public void userIsPromptedToSelectOption() throws Exception {
        MenuItem menu = new MainMenu(new Library());
        String prompt = menu.requestInput().promptUser();
        assertThat(prompt, containsString("select an option"));
    }

    @Test
    public void canSelectAMenuOption() throws Exception {
        MenuItem menu = new MainMenu(new Library());
        MenuItem newMenu = menu.requestInput().handleInput("2");
        assertTrue(newMenu.output().length() > 0);
    }

    @Test
    public void testErrorThrownIfInvalidInputEntered() throws Exception {
        MenuItem menu = new MainMenu(new Library());
        MenuItem newMenu = menu.requestInput().handleInput("invalid string");
        assertThat(newMenu.output(), containsString("valid option"));
    }

    @Test
    public void testWelcomeMessage() throws Exception {
        ByteArrayOutputStream screenOutput = directOutputStream();
        UIRunner uiRunner = getMockUI();
        uiRunner.displayWelcome();
        assertThat(screenOutput.toString(), containsString("Welcome to Biblioteca"));
    }

    @Test
    public void testUserCanBrowseBooks() throws Exception {
        MenuItem menu = new MainMenu(new Library());
        MenuItem browseBooks = menu.requestInput().handleInput("1");
        assertThat(browseBooks.output(), containsString("books found"));
    }

    @Test
    public void testUserCanBeginReservingBook() throws Exception {
        MenuItem menu = new MainMenu(new Library());
        MenuItem browseBooks = menu.requestInput().handleInput("1");
        MenuItem reserveBookMenu = browseBooks.requestInput().handleInput("1");
        assertThat(reserveBookMenu.requestInput().promptUser(), containsString("Please enter"));
    }

    @Test
    public void testUserCanReserveBookSuccessfully() throws Exception {
        MenuItem menu = new MainMenu(new Library());
        MenuItem browseBooks = menu.requestInput().handleInput("1");
        MenuItem reserveBookMenu = browseBooks.requestInput().handleInput("1");
        MenuItem bookReservedSuccessfully = reserveBookMenu.requestInput().handleInput("9780684801520");
        assertThat(bookReservedSuccessfully.output(), containsString("Thank You!"));
    }

    @Test
    public void testUserCanReserveBookUnsuccessfully() throws Exception {
        String isbn = "9780684801520";
        Library library = new Library();
        library.getRegistrationManager().reserveBook(isbn);
        MenuItem menu = new MainMenu(library);
        MenuItem browseBooks = menu.requestInput().handleInput("1");
        MenuItem reserveBookMenu = browseBooks.requestInput().handleInput("1");
        MenuItem bookReservedUnsuccessfully = reserveBookMenu.requestInput().handleInput("9780684801520");
        assertThat(bookReservedUnsuccessfully.output(), containsString("Sorry"));
    }

    @Test
    public void testUserCantReserveInvalidBook() throws Exception {
        MenuItem menu = new MainMenu(new Library());
        MenuItem browseBooks = menu.requestInput().handleInput("1");
        MenuItem reserveBookMenu = browseBooks.requestInput().handleInput("1");
        MenuItem bookReservedSuccessfully = reserveBookMenu.requestInput().handleInput("randomStringIsbn");
        assertThat(bookReservedSuccessfully.output(), containsString("Sorry, the ISBN: " + "randomStringIsbn" + " did not correspond"));
    }

    @Test
    public void testUserCanCheckCredentials() throws Exception {
        MenuItem menu = new MainMenu(new Library());
        MenuItem userCreds = menu.requestInput().handleInput("2");
        assertThat(userCreds.output(), containsString("Please talk to a Librarian. Thank you"));
    }
}
