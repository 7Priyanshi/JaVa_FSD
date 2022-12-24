package com.phase1.lockedme.screen;
import com.phase1.lockedme.services.DirectoryService;
import com.phase1.lockedme.services.ScreenService;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class WelcomeScreen implements Screen {
    private String upperBorder = "              ~~~~~~~~~~~~~~~~~~~~~~~~";
    private String welcomeText = "             | Welcome to LockedMe.com |" ;
    private String lowerBorder = "              ~~~~~~~~~~~~~~~~~~~~~~~~";
    private String developerText = "       *| Developed by ~ Priyanshi Sharma |*";

    private ArrayList<String> options = new ArrayList<>();

    public WelcomeScreen() {
        options.add("  Select from the following:- ");
        options.add("1 - Display All The Files");
        options.add("2 - Show File Operations Menu");
        options.add("3 - Quit");
    }
    public void introWS() {
        System.out.println(upperBorder);
        System.out.println(welcomeText);
        System.out.println(lowerBorder);
        System.out.println(developerText);
        System.out.println("\n");
        Show();
    }
    @Override
    public void Show() {
        System.out.println("    ***| MAIN MENU |*** ");
        for (String s : options)  {
            System.out.println(s);
        }
    }
    public void GetUserInput() {
        int selectedOption  = 0;
        while ((selectedOption = this.getOption()) != 3) {
            this.NavigateOption(selectedOption);
        }
    }
    @Override
    public void NavigateOption(int option) {
        switch(option) {

            case 1:
                this.ShowFiles();

                this.Show();

                break;
            case 2:
                ScreenService.setCurrentScreen(ScreenService.FileOperations);
                ScreenService.getCurrentScreen().Show();
                ScreenService.getCurrentScreen().GetUserInput();
                this.Show();
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    }
    public void ShowFiles() {
        System.out.println(" ***| List of Files Created by You |*** ");
        DirectoryService.PrintFiles();
    }
    private int getOption() {
        Scanner in = new Scanner(System.in);
        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {
        }
        return returnOption;
    }
}
