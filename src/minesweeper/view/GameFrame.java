package minesweeper.view;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

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
        JMenu gameMenu = menuBar.createMenu("Game");
        JMenu difficultySubmenu = menuBar.createMenu("Difficulty");
        JMenu helpMenu = menuBar.createMenu("Help");

        JMenuItem newGameItem = menuBar.createMenuItem("New game...");
        JMenuItem easyDifficultyItem = menuBar.createMenuItem("Easy");
        JMenuItem mediumDifficultyItem = menuBar.createMenuItem("Medium");
        JMenuItem hardDifficultyItem = menuBar.createMenuItem("Hard");
        JMenuItem exitItem = menuBar.createMenuItem("Exit");
        JMenuItem howToPlayItem = menuBar.createMenuItem("How to play?");
        JMenuItem aboutItem = createAboutButton();

        // Game menu
        gameMenu.add(newGameItem);
        difficultySubmenu.add(easyDifficultyItem);
        difficultySubmenu.add(mediumDifficultyItem);
        difficultySubmenu.add(hardDifficultyItem);
        gameMenu.add(difficultySubmenu);
        gameMenu.add(exitItem);

        // Help menu
        helpMenu.add(howToPlayItem);
        helpMenu.add(aboutItem);

        menuBar.add(gameMenu);
        menuBar.add(helpMenu);

        frame.add(menuBar);

    }

    public JMenuItem createAboutButton() {
        JMenuItem button = new JMenuItem("About...");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,
                        "This game was created by Alejandro Perez Martin.\n" + "(GitHub @alejandroperezmartin)\n" + "\nVersion 1.0.1",
                        "About Minesweeper...",
                        JOptionPane.PLAIN_MESSAGE);
            }
        });
        return button;
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
