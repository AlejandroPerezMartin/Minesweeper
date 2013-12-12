package minesweeper.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public final class GameFrameMenuBar extends JMenuBar {

    private final JMenuBar menuBar;

    public GameFrameMenuBar() {
        this.menuBar = new JMenuBar();
        createComponens();
    }

    public void createComponens() {
        JMenu gameMenu = createMenu("Game");
        JMenu difficultySubmenu = createMenu("Difficulty");
        JMenu helpMenu = createMenu("Help");

        JMenuItem newGameItem = createMenuItem("New game...");
        JMenuItem easyDifficultyItem = createMenuItem("Easy");
        JMenuItem mediumDifficultyItem = createMenuItem("Medium");
        JMenuItem hardDifficultyItem = createMenuItem("Hard");
        JMenuItem exitItem = createMenuItem("Exit");
        JMenuItem howToPlayItem = createMenuItem("How to play?");
        JMenuItem aboutItem = createAboutItem();

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
    }

    public JMenuItem createAboutItem() {
        final JMenuItem aboutItem = new JMenuItem("About...");
        aboutItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(aboutItem,
                        "This game was created by Alejandro Perez Martin.\n" + "(GitHub @alejandroperezmartin)\n" + "\nVersion 1.0.1",
                        "About Minesweeper...",
                        JOptionPane.PLAIN_MESSAGE);
            }
        });
        return aboutItem;
    }

    public JMenuItem createMenuItem(String title) {
        JMenuItem menuItem = new JMenuItem(title);
        menuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // action
            }
        });
        return menuItem;
    }

    public JMenu createMenu(String title) {
        return new JMenu(title);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

}
