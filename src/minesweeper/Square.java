
package minesweeper;

import java.awt.Point;

public class Square {
    
    private Point position;
    private String content = "";
    private boolean revealed = false;

    public Square() {
        this.position = new Point(0,0);
        this.content = content;
        this.revealed = revealed;
    }

    public Point getPosition() {
        return position;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = true;
    }
    
    public boolean isEmpty() {
        return this.getContent().equals("");
    }
    
    public boolean isEmpty(Point position) {
        return this.getContent().equals("");
    }
    
    public boolean isMine() {
        return this.getContent().equals(" x ");
    }
    
    public boolean isRevealed() {
        return revealed;
    }
    
}