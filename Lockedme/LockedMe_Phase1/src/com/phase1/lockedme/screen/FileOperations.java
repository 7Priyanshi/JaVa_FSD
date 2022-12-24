package com.phase1.lockedme.screen;

import com.phase1.lockedme.virtual.Directory;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileOperations implements Screen {
    private Directory dir = new Directory();

    private ArrayList<String> options = new ArrayList<>();

    public FileOperations() {

        options.add("1. Create a new File");
        options.add("2. Delete a File");
        options.add("3. Search a File");
        options.add("4. Return to Main Menu");

    }

    @Override
    public void Show() {
        System.out.println("\n   *| File Operations Menu |*\n");
        for (String s : options) {
            System.out.println(s);
        }

    }

    public void GetUserInput() {
        int selectedOption;
        while ((selectedOption = this.getOption()) != 4) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {

        switch(option) {

            case 1: // Add File
                this.AddFile();

                this.Show();
                break;
            case 2: // Delete File
                this.DeleteFile();

                this.Show();
                break;
            case 3: // Search File
                this.SearchFile();
                this.Show();
                break;

            default:
                System.out.println("Invalid Input");
                break;
        }
    }
    public void AddFile() {
        System.out.println(" -> Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are adding a file named - " + fileName);

        try {
            Path path = FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
            File file = new File(dir.getName() + fileName);

            if (file.createNewFile()) {
                System.out.println(" :) File created: " + file.getName());
                dir.getFiles().add(file);

            } else {
                System.out.println(" This File Already Exits, no need to add another");
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
    public void DeleteFile() {

        System.out.println(" -> Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println(" -> You are deleting a file named: " + fileName);

        Path path = FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
        File file = path.toFile();
        if (file.delete()) {
            System.out.println(" File Deleted Successfully : " + file.getName());
            dir.getFiles().remove(file);
        } else {
            System.out.println(" Failed to delete file : " + fileName + ", was not found.");
        }
    }
    public void SearchFile() {

        Boolean found = false;

        System.out.println(" -> Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println(" You are searching for a file : " + fileName + "");

        ArrayList<File> files = dir.getFiles();

        for(int i = 0; i < files.size(); i++) {
            if(files.get(i).getName().equals(fileName)) {
                System.out.println("  :) File Found :- " + fileName);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("  :( Oops, File not found");
        }
    }
    private String getInputString() {

        Scanner in = new Scanner(System.in);
        return(in.nextLine());
    }
    private int getOption() {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {
            System.out.println("Invalid Input!");
        }
        return returnOption;

    }

}
