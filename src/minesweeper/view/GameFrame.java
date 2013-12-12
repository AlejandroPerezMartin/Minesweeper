package minesweeper.view;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public final class GameFrame extends JFrame {

    private final JFrame frame;

    public GameFrame() throws HeadlessException {
        this.frame = new JFrame("Minesweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 350);
        frame.getContentPane().setLayout(new GridLayout(9, 9));
        //frame.pack();
        createComponents();
        frame.setVisible(true);
    }

    public void createComponents() {
        GameFrameMenuBar menuBar = new GameFrameMenuBar();
        frame.add(menuBar.getMenuBar());
    }

    public void createMenuBar() {

    }

    public void createPopUp() {

    }

    /*
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

     frame.getContentPane().setLayout(new GridLayout(9, 9));

     for (int i = 0; i < 9; i++) {
     for (int j = 0; j < 9; j++) {
     Button aux = new Button(Integer.toString(i));
     aux.setSize(1, 1);
     frame.add(aux);
     }
     }
     */
}
