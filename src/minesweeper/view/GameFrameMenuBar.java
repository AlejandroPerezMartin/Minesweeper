package minesweeper.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameFrameMenuBar extends JMenuBar {

    public JMenuBar GameFrameMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        return menuBar;
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

}
