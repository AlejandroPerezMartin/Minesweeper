package minesweeper.view;

import minesweeper.model.*;

public class BoardViewer {

    private final BoardModel board;

    public BoardViewer(BoardModel board) {
        this.board = board;
    }

    public void showBoard() {
        System.out.print("   ");
        for (int i = 0; i < board.getBoardWidth(); i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
        System.out.println("  -----------------------");
        for (int i = 0; i < board.getBoardWidth(); i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < board.getBoardHeight(); j++) {
                if (board.getPosition(i, j).isVisible()) {
                    System.out.print(board.getPosition(i, j).getContent() + " ");
                }
                else if (board.getPosition(i, j).isFlagged()) {
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
        for (int i = 0; i < board.getBoardWidth(); i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
    }

    public void showRevealedBoard() {
        System.out.print("   ");
        for (int i = 0; i < board.getBoardWidth(); i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
        System.out.println("  -----------------------");
        for (int i = 0; i < board.getBoardWidth(); i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < board.getBoardHeight(); j++) {
                System.out.print(board.getPosition(i, j).getContent() + " ");
            }
            System.out.println("| " + i);
        }
        System.out.println("  -----------------------");
        System.out.print("   ");
        for (int i = 0; i < board.getBoardWidth(); i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
    }

}
