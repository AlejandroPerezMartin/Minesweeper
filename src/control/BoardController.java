package control;

import java.util.Scanner;
import model.Board;
import model.Point;

public class BoardController {

    public void execute() {
        Board game = new Board("easy");
        game.buildBoard();
        game.placeMines();
        game.placeNumbers();
        game.showRevealedBoard();
        game.showBoard();

        while (true) {

            System.out.println("");
            Scanner reader = new Scanner(System.in);
            System.out.println("TYPE A COMMAND: (1) UNHIDE BOX ; (2) MARK AS FLAG.");
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
                    game.unhideCell(new Point(a, b));
                    break;
                case 2:
                    System.out.println("");
                    Scanner readerc = new Scanner(System.in);
                    System.out.println("[[FLAG BOX]]\n> Type first coordinate (horizontal):");
                    int c = readerc.nextInt();
                    Scanner readerd = new Scanner(System.in);
                    System.out.println("> Type second coordinate (vertical):");
                    int d = readerd.nextInt();
                    game.markFlag(new Point(c, d));
                    break;
                default:
                    System.out.println("(ERROR) Comando no reconocido...");
                    break;
            }
            game.showRevealedBoard();
            game.showBoard();
        }

    }

}
