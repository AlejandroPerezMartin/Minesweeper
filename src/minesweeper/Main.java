package minesweeper;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import minesweeper.control.BoardController;
import minesweeper.control.GameController;
import minesweeper.model.BoardModel;
import minesweeper.model.DifficultyModel;
import minesweeper.model.PointModel;
import minesweeper.view.BoardViewer;

public class Main {

    public static void main(String[] args) {
        
        Scanner reader0 = new Scanner(System.in);
        System.out.println("> SELECT DIFFICULTY BY TYPING: EASY, MEDIUM OR HARD:");
        String diff = reader0.nextLine();
        
        DifficultyModel difficulty = new DifficultyModel(diff.toString());
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
        
        /*
        // Main frame
        JFrame frame = new JFrame("Minesweeper 1.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
        // Menu
        JMenuBar menu = new JMenuBar();
        
        // Add menu to frame
        frame.setJMenuBar(menu);
        
        // Menu items
        JMenuItem newGameItem = new JMenuItem("New Game");
        JMenuItem easyDifficultyItem = new JMenuItem("Easy");
        JMenuItem mediumDifficultyItem = new JMenuItem("Medium");
        JMenuItem hardDifficultyItem = new JMenuItem("Hard");
        JMenuItem customDifficultyItem = new JMenuItem("Custom...");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem helpItem = new JMenuItem("How to play");
        JMenuItem aboutItem = new JMenuItem("About...");
        
        // Submenus
        JMenu gameSubmenu = new JMenu("Game");
        JMenu difficultySubmenu = new JMenu("Difficulty");
        JMenu helpSubmenu = new JMenu("Help");
        
        // Sumenus items
        gameSubmenu.add(newGameItem);
        gameSubmenu.add(difficultySubmenu);
        gameSubmenu.add(exitItem);
        
        difficultySubmenu.add(easyDifficultyItem);
        difficultySubmenu.add(mediumDifficultyItem);
        difficultySubmenu.add(hardDifficultyItem);
        difficultySubmenu.add(customDifficultyItem);

        helpSubmenu.add(helpItem);
        helpSubmenu.add(aboutItem);
        
        // Adding submenus to menu
        menu.add(gameSubmenu);
        menu.add(helpSubmenu);

        frame.getContentPane().setLayout(new GridLayout(9,9));
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Button aux = new Button(Integer.toString(i));
                aux.setSize(1, 1);
                frame.add(aux);
            }
        }
        
        */
        
    }

}
