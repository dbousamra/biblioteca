package com.twu.biblioteca.ui;
/**
 * Interface responsible for defining a Menu Item.
 * For example MainMenu, InvalidInputMenu etc.
 */
public interface MenuItem {
    /**
     * Defines what the menu displays to the screen
     */
    public String output();
    /**
     * Defines how this menu requests and handles input from the user.
     */
    public InputHandler requestInput();

}
