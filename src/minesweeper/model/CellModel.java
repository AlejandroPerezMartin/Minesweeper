package minesweeper.model;

public class CellModel {

    private PointModel position;
    private String content;
    private boolean visible = false;
    private boolean flagged = false;

    public CellModel(PointModel position) {
        this.position = position;
    }

    public CellModel(int positionX, int positionY) {
        this.position = new PointModel(positionX, positionY);
    }

    public PointModel getPosition() {
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

    public void setPosition(PointModel position) {
        this.position = position;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public boolean isEmpty() {
        return this.getContent().equals("0");
    }

    public boolean isNumber() {
        return !this.getContent().equals("#") || !this.getContent().equals("0");
    }

    public boolean isNotEmpty() {
        return !this.getContent().equals("0");
    }

    public boolean isMine() {
        return this.content.equals("#");
    }
}
