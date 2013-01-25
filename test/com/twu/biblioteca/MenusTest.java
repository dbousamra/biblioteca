package com.twu.biblioteca;

import com.twu.biblioteca.ui.MenuItem;
import com.twu.biblioteca.ui.UIRunner;
import com.twu.biblioteca.ui.menus.MainMenu;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MenusTest {

    final ByteArrayOutputStream screenOutput = new ByteArrayOutputStream();

//    @Before
//    public void directOutputStream(){
//        PrintStream ps = new PrintStream(screenOutput);
//        System.setOut(ps);
//    }
    
    private UIRunner getMockUI() {
        return new UIRunner(new MainMenu(new Library()));
    }
    
    @Test
    public void canSeeMainMenuOptions() throws Exception {
        MainMenu menu = new MainMenu(new Library());
        String output = menu.output();
        assertThat(output, containsString("Browse Books"));
        assertThat(output, containsString("Exit"));
    }

    @Test
    public void userIsPromptedToSelectOption() throws Exception {
        MainMenu menu = new MainMenu(new Library());
        String prompt = menu.requestInput().promptUser();
        assertThat(prompt, containsString("select an option"));
    }

    @Test
    public void canSelectAMenuOption() throws Exception {
        MainMenu menu = new MainMenu(new Library());
        MenuItem newMenu = menu.requestInput().handleInput("2");
        assertTrue(newMenu.output().length() > 0);
    }

    @Test
    public void testErrorThrownIfInvalidInputEntered() throws Exception {
        MainMenu menu = new MainMenu(new Library());
//        MenuItem newMenu = menu.requestInput().handleInput();
//        System.out.println(newMenu.output());
    }
}
