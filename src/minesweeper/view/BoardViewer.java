package minesweeper.view;

import minesweeper.model.*;

public class BoardViewer {

    public static void showBoard(BoardModel boardModel) {
        System.out.print("   ");
        for (int i = 0; i < boardModel.getBoardWidth(); i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
        System.out.println("  -----------------------");
        for (int i = 0; i < boardModel.getBoardWidth(); i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < boardModel.getBoardHeight(); j++) {
                if (boardModel.getPosition(i, j).isVisible()) {
                    System.out.print(boardModel.getPosition(i, j).getContent() + " ");
                }
                else if (boardModel.getPosition(i, j).isFlagged()) {
                    System.out.print("P ");
                }
                else {
                    System.out.print("· ");
                }
            }
            System.out.println("| " + i);
        }
        System.out.println("  -----------------------");
        System.out.print("   ");
        for (int i = 0; i < boardModel.getBoardWidth(); i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
    }

    public static void showRevealedBoard(BoardModel boardModel) {
        System.out.print("   ");
        for (int i = 0; i < boardModel.getBoardWidth(); i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
        System.out.println("  -----------------------");
        for (int i = 0; i < boardModel.getBoardWidth(); i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < boardModel.getBoardHeight(); j++) {
                System.out.print(boardModel.getPosition(i, j).getContent() + " ");
            }
            System.out.println("| " + i);
        }
        System.out.println("  -----------------------");
        System.out.print("   ");
        for (int i = 0; i < boardModel.getBoardWidth(); i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
    }

}
