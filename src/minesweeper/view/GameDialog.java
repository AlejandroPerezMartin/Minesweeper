package minesweeper.view;

import java.util.Scanner;

public class GameDialog {

    public static String askDifficulty() {
        Scanner reader0 = new Scanner(System.in);
        System.out.println("> SELECT DIFFICULTY BY TYPING: EASY, MEDIUM OR HARD:");
        String diff = reader0.next();
        return diff.toString();
    }

    public static int askMove() {
        System.out.println("");
        Scanner reader = new Scanner(System.in);
        System.out.println("> TYPE A COMMAND: (1) UNHIDE ; (2) FLAG; (3) UNFLAG:");
        int option = reader.nextInt();

        return option;
    }

    public static int askFirstParameter() {
        System.out.println("");
        Scanner reader = new Scanner(System.in);
        System.out.println("Type first coordinate (horizontal):");
        int param = reader.nextInt();
        return param;
    }

    public static int askSecondParameter() {
        System.out.println("");
        Scanner reader = new Scanner(System.in);
        System.out.println("Type second coordinate (vertical):");
        int param = reader.nextInt();
        return param;
    }

}
