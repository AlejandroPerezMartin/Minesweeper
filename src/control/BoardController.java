package control;

import java.util.Scanner;
import model.Board;
import model.Point;

public class BoardController {

    public void execute() {
        Board game = new Board(10);
        game.buildBoard();
        game.placeMines();
        game.placeNumbers();
        game.showBoard();

        // Test 1
        System.out.println("");
        Scanner reader = new Scanner(System.in);
        System.out.println("> Introduzca la primera coordenada (eje vertical):");
        int a = reader.nextInt();
        Scanner reader2 = new Scanner(System.in);
        System.out.println("> Introduzca la segunda coordenada (eje horizontal:");
        int b = reader2.nextInt();

        game.unhideCell(new Point(a, b));
        game.showBoard();
        
        // Test 2
        System.out.println("");
        Scanner reader3 = new Scanner(System.in);
        System.out.println("> Introduzca la primera coordenada (eje vertical):");
        int c = reader3.nextInt();
        Scanner reader4 = new Scanner(System.in);
        System.out.println("> Introduzca la segunda coordenada (eje horizontal:");
        int d = reader4.nextInt();
        
        game.unhideCell(new Point(c, d));
        game.showBoard();
    }

}
