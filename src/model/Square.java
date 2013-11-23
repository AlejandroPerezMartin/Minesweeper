package model;

public class Square {

    private Point position;
    private String content;
    private boolean visible = false;

    public Square(Point position) {
        this.position = position;
    }

    public Square(int positionX, int positionY) {
        this.position = new Point(positionX, positionY);
    }

    public Point getPosition() {
        return position;
    }

    public int getPositionX() {
        return position.getPosX();
    }

    public int getPositionY() {
        return position.getPosY();
    }

    public String getContent() {
        return content;
    }

    public void setPositionX(int positionX) {
        this.position.setPosX(positionX);
    }

    public void setPositionY(int positionY) {
        this.position.setPosY(positionY);
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setVisible(boolean value) {
        this.visible = value;
    }

    public boolean isVisible() {
        return visible;
    }
    
    public boolean isMine() {
        return this.content.equals("#");
    }

}
