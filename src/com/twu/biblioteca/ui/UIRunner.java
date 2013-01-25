package com.twu.biblioteca.ui;

import com.twu.biblioteca.ui.menus.InvalidInputMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class UIRunner {

    private final MenuItem startingMenu;

    public UIRunner(MenuItem startingMenu) {
        this.startingMenu = startingMenu;
    }

    public void run() {
        Stack<MenuItem> uiStack = new Stack<MenuItem>();
        uiStack.push(this.startingMenu);

        displayWelcome();
        while(true) {
            if (uiStack.isEmpty()) {
                break;
            }
            MenuItem currentMenu = uiStack.pop();

            System.out.println("=======================================");
            System.out.println(currentMenu.output());
            System.out.println("=======================================");
            System.out.println(currentMenu.requestInput().promptUser());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                String input = requestInput(br);
//                if () {
//                    uiStack.push(currentMenu);
//                } else {
                    MenuItem nextMenu = currentMenu.requestInput().handleInput(input);
                    if (nextMenu != null) {
                        uiStack.push(nextMenu);
                    }
//                }
//
            } catch (IOException e) {
                throw new RuntimeException("Unable to read input from user");
            }
            clearConsole();
        }
    }

    public void displayWelcome() {
        System.out.println("---------------------------------------");
        System.out.println("Welcome to Biblioteca v0.1");
        System.out.println("---------------------------------------");
    }

    private String requestInput(BufferedReader br) throws IOException {
        String input = "";
        while (input.isEmpty()) {
            input = br.readLine();
        }
        return input;
    }

    private void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
}
