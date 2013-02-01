package com.twu.biblioteca.menus;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.ui.MenuItem;
import com.twu.biblioteca.ui.menus.MainMenu;
import com.twu.biblioteca.users.User;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class AuthenticatedMenusTest {

    private Library getMockLibraryWithLoggedInUser() {
        User user = new User("111-1111", "somePassword", "Sample User", "s@s.com", "55338008");
        Library library = new Library();
        library.getUserManager().addUser(user);
        library.getUserManager().authenticateUser("111-1111", "somePassword");
        return library;
    }

    @Test
    public void testShouldTellUserToTalkToLibrarianForUserCreds() throws Exception {
        MenuItem menu = new MainMenu(new Library());
        MenuItem userCreds = menu.requestInput().handleInput("3");
        assertThat(userCreds.output(), containsString("Please talk to a Librarian. Thank you"));
    }

    @Test
    public void testUserCanBeginReservingBook() throws Exception {
        MenuItem menu = new MainMenu(getMockLibraryWithLoggedInUser());
        MenuItem browseBooks = menu.requestInput().handleInput("1");
        MenuItem reserveBookMenu = browseBooks.requestInput().handleInput("1");
        assertThat(reserveBookMenu.requestInput().promptUser(), containsString("Please enter"));
    }

    @Test
    public void testUserCanReserveBookSuccessfully() throws Exception {
        MenuItem menu = new MainMenu(getMockLibraryWithLoggedInUser());
        MenuItem browseBooks = menu.requestInput().handleInput("1");
        MenuItem reserveBookMenu = browseBooks.requestInput().handleInput("1");
        MenuItem bookReservedSuccessfully = reserveBookMenu.requestInput().handleInput("9780684801520");
        assertThat(bookReservedSuccessfully.output(), containsString("Thank You!"));
    }

    @Test
    public void testUserCanReserveBookUnsuccessfully() throws Exception {
        String isbn = "9780684801520";
        Library library = getMockLibraryWithLoggedInUser();
        library.getBookManager().reserveBook(isbn);
        MenuItem menu = new MainMenu(library);
        MenuItem browseBooks = menu.requestInput().handleInput("1");
        MenuItem reserveBookMenu = browseBooks.requestInput().handleInput("1");
        MenuItem bookReservedUnsuccessfully = reserveBookMenu.requestInput().handleInput("9780684801520");
        assertThat(bookReservedUnsuccessfully.output(), containsString("Sorry"));
    }

    @Test
    public void testUserCantReserveInvalidBook() throws Exception {
        MenuItem menu = new MainMenu(getMockLibraryWithLoggedInUser());
        MenuItem browseBooks = menu.requestInput().handleInput("1");
        MenuItem reserveBookMenu = browseBooks.requestInput().handleInput("1");
        MenuItem bookReservedSuccessfully = reserveBookMenu.requestInput().handleInput("randomStringIsbn");
        assertThat(bookReservedSuccessfully.output(), containsString("Sorry, the ISBN: " + "randomStringIsbn" + " did not correspond"));
    }

    @Test
    public void testUserCannotAccessMenuOptionsWithoutLoggingIn() throws Exception {
        MenuItem menu = new MainMenu(new Library());
        MenuItem browseBooks = menu.requestInput().handleInput("1");
        MenuItem invalidMenu = browseBooks.requestInput().handleInput("1");
        assertThat(invalidMenu.output(), containsString("You are not logged in. Please return to the main menu and log in"));
    }

    @Test
    public void testCanLogUserInSuccessfully() throws Exception {
        MenuItem menu = new MainMenu(new Library());
        MenuItem loginMenu = menu.requestInput().handleInput("4");
        MenuItem passwordMenu = loginMenu.requestInput().handleInput("111-1111");
        MenuItem success = passwordMenu.requestInput().handleInput("somePassword");
        assertThat(success.output(), containsString("Thank you for logging in"));
    }

    @Test
    public void testCanLogUserInUnSuccessfully() throws Exception {
        MenuItem menu = new MainMenu(new Library());
        MenuItem loginMenu = menu.requestInput().handleInput("4");
        MenuItem passwordMenu = loginMenu.requestInput().handleInput("111-1111");
        MenuItem success = passwordMenu.requestInput().handleInput("wrong password");
        assertThat(success.output(), containsString("Sorry. The username and password you supplied did not match"));
    }
}
