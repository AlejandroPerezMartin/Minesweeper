package model;

public class Square {

    private int positionX;
    private int positionY;
    private String content;
    private boolean visible;

    public Square(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.visible = false;
    }

    public Point getPosition(){
        return new Point(positionX, positionY);
    }
    
    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public String getContent() {
        return content;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setVisible(boolean value) {
        this.visible = value;
    }
    
    public boolean isMine(){
        return this.content.equals("#");
    }
    
}
