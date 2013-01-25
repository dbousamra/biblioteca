package com.twu.biblioteca.ui;

/**
 * An interface responsible for defining how to handle input from the user.
 */
public interface InputHandler {

    /**
     * Output to display when requesting input from user.
     */
    public String promptUser();

    /**
     * Responsible for handling input from user.
     * @param input The input case to perform logic on. Delegates to a new MenuItem
     */
    public MenuItem handleInput(String input);

}
