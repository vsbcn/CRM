package com.ironhack.Ironhack_Homework03.utils;

import com.ironhack.Ironhack_Homework03.view.menu.UserInput;

import java.util.List;
import java.util.Scanner;

public class Utils {

    public static UserInput captureOptions(){
        System.out.println("Choose action to be performed: ");
        Scanner scanner = new Scanner(System.in);
        String capturedOption = scanner.nextLine().toLowerCase();
        UserInput userResponse = interpretUserInput(capturedOption);
        return userResponse;
    }

    public static String captureUserInput(String question){
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }

    public static Integer captureUserIntInput(String question){
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static Integer captureUserLongInput(String question){
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static UserInput interpretUserInput(String option){
        String[] options = option.split(" ");
        UserInput userInput = new UserInput();

        switch (options.length) {
            case 0 -> {}
            case 1 -> userInput.setOrder(options[0]);
            case 2 -> {
                switch (options[0]){
                    case "convert" -> {
                        userInput.setOrder(options[0]);
                        userInput.setId(captureOrderId(options[1], userInput));
                    }
                    case "create", "new", "show", "go" -> {
                        userInput.setOrder(options[0]+" "+options[1]);
                    }
                    default -> userInput.setOrder("");
                }
            }
            case 3 -> userInput.setOrder(options[0]+" "+options[1]+" "+options[2]);
            case 4 -> userInput.setOrder(options[0]+" "+options[1]+" "+options[2]+" "+options[3]);
            case 5 -> userInput.setOrder(options[0]+" "+options[1]+" "+options[2]+" "+options[3]+" "+options[4]);
            default -> {
                userInput.setOrder(options[0]+" "+options[1]);
                userInput.setId(captureOrderId(options[2], userInput));
            }
        }
        return userInput;
    }

    public static Integer captureOrderId(String option, UserInput userInput){
        Integer capturedInt = 0;
        try{
            capturedInt = Integer.valueOf(option);
        }catch (NumberFormatException e){
            userInput.setOrder("");
            System.err.println("[invalid ID] That's not a valid command!");
        }
        return capturedInt;
    }

    public static void printReport(List<Object[]> reportResult, String col1, String col2){
        String leftAlignFormat = "|| %-4s | %-22s ||%n";

        System.out.format("||--------+------------------------||%n");
        System.out.format("||"+col1+"| "+col2+"   ||%n");
        System.out.format("||--------+------------------------||%n");

        for (Object[] object : reportResult) {
            System.out.format(leftAlignFormat, object[0], object[1]);
            System.out.format("||--------+------------------------||%n");
        }
    }

}
