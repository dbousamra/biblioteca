package com.twu.biblioteca.menus;

import com.twu.biblioteca.Library;
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
    /*
    Handy for redirecting Sysout to something testable.
    */
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
        MenuItem newMenu = menu.requestInput().handleInput("3");
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
    public void testUserShouldSeeBrowseMoviesMenuOption() throws Exception {
        MenuItem menu = new MainMenu(new Library());
        assertThat(menu.output(), containsString("Browse Movies"));
    }

    @Test
    public void testUserShouldSeeListOfMoviesWhenSelectBrowseMovies() throws Exception {
        MenuItem menu = new MainMenu(new Library());
        MenuItem browseMovies = menu.requestInput().handleInput("2");
        assertThat(browseMovies.output(), containsString("movies found"));
    }
}
