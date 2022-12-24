package com.phase1.lockedme.services;

import com.phase1.lockedme.screen.FileOperations;
import com.phase1.lockedme.screen.WelcomeScreen;
import com.phase1.lockedme.screen.Screen;

public class ScreenService {
    public static WelcomeScreen WelcomeScreen = new WelcomeScreen();
    public static com.phase1.lockedme.screen.FileOperations FileOperations = new FileOperations();

    public static Screen CurrentScreen = WelcomeScreen;

    public static Screen getCurrentScreen() {
        return CurrentScreen;
    }

    public static void setCurrentScreen(Screen currentScreen) {
        CurrentScreen = currentScreen;
    }

}
