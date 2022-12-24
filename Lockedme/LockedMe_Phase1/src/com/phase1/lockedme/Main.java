package com.phase1.lockedme;

import com.phase1.lockedme.screen.WelcomeScreen;

public class Main {

    public static void main(String[] args) {

        WelcomeScreen welcome = new WelcomeScreen();
        welcome.introWS();
        welcome.GetUserInput();
    }
}
