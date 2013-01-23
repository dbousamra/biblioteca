package com.twu.biblioteca.ui.menus;
import com.twu.biblioteca.ui.*;

public class MainMenu implements MenuItem {

    public String output() {
        return "1.) Browse Books\n" +
               "2.) View membership details\n" +
               "3.) Exit";
    }

    public InputHandler requestInput() {
        return new InputHandler() {
            public String promptUser() {
                return "Please select an option:";
            }

            public MenuItem handleInput(String input) {
                int menuItem = Integer.parseInt(input);
                if (menuItem == 1) {
                    return new BrowseBooks();
                } else if (menuItem == 2) {
                    return new ViewUserDetails();
                } else {
                    return new MainMenu();
                }
            }
        };
    }
}
