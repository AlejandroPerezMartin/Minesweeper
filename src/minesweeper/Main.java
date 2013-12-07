package minesweeper;

import java.util.Scanner;
import minesweeper.control.BoardController;
import minesweeper.control.GameController;
import minesweeper.model.BoardModel;
import minesweeper.model.Difficulty;
import minesweeper.model.PointModel;
import minesweeper.view.BoardViewer;

public class Main {

    public static void main(String[] args) {

        Scanner reader0 = new Scanner(System.in);
        System.out.println("> SELECT DIFFICULTY BY TYPING: EASY, MEDIUM OR HARD:");
        String diff = reader0.nextLine();
        
        Difficulty difficulty = new Difficulty(diff.toString());
        BoardModel boardModel = new BoardModel(difficulty);

        boardModel.buildBoard();
        boardModel.placeMines();
        boardModel.placeNumbers();

        BoardViewer boardViewer = new BoardViewer(boardModel);

        boardViewer.showBoard();

        BoardController game = new BoardController(boardModel);

        while (true) {
            System.out.println("");
            Scanner reader = new Scanner(System.in);
            System.out.println("> TYPE A COMMAND: (1) UNHIDE ; (2) FLAG; (3) UNFLAG:");
            int option = reader.nextInt();

            switch (option) {
                case 1:
                    System.out.println("");
                    Scanner readera = new Scanner(System.in);
                    System.out.println("[[UNHIDE BOX]]\n> Type first coordinate (horizontal):");
                    int a = readera.nextInt();
                    Scanner readerb = new Scanner(System.in);
                    System.out.println("> Type second coordinate (vertical):");
                    int b = readerb.nextInt();
                    boardModel.unhideCell(new PointModel(a, b));
                    break;
                case 2:
                    System.out.println("");
                    Scanner readerc = new Scanner(System.in);
                    System.out.println("[[FLAG BOX]]\n> Type first coordinate (horizontal):");
                    int c = readerc.nextInt();
                    Scanner readerd = new Scanner(System.in);
                    System.out.println("> Type second coordinate (vertical):");
                    int d = readerd.nextInt();
                    boardModel.setFlag(new PointModel(c, d));
                    break;
                case 3:
                    System.out.println("");
                    Scanner readere = new Scanner(System.in);
                    System.out.println("[[UNFLAG BOX]]\n> Type first coordinate (horizontal):");
                    int e = readere.nextInt();
                    Scanner readerf = new Scanner(System.in);
                    System.out.println("> Type second coordinate (vertical):");
                    int f = readerf.nextInt();
                    boardModel.unsetFlag(new PointModel(e, f));
                    break;
                default:
                    System.out.println("(ERROR) Comando no reconocido...");
                    break;
            }
            boardViewer.showRevealedBoard();
            boardViewer.showBoard();
        }

    }

}
