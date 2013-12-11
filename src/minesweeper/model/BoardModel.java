package minesweeper.model;

public final class BoardModel {

    private int boardWidth;
    private int boardHeight;
    private int numberOfMines;
    private int numberOfFlags;

    private Cell[][] board;
    private Difficulty difficulty;

    public BoardModel(Difficulty difficulty) {
        setDifficulty(difficulty);
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;

        switch (difficulty.getDifficulty()) {
            case "medium":
                this.numberOfMines = 40;
                this.boardWidth = 16;
                this.boardHeight = boardWidth;
                break;
            case "hard":
                this.numberOfMines = 99;
                this.boardWidth = 16;
                this.boardHeight = 40;
                break;
            default:
                this.numberOfMines = 10;
                this.boardWidth = 8;
                this.boardHeight = boardWidth;
                break;
        }
        this.numberOfFlags = this.numberOfMines;
        this.board = new Cell[boardWidth][boardHeight];
    }

    public void gameOver() {
        System.out.println("GAME OVER :(");
    }

    public Cell getPosition(int positionX, int positionY) {
        return board[positionX][positionY];
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public int getBoardSize() {
        return boardWidth * boardHeight;
    }

    public int getNumberOfMines() {
        return numberOfMines;
    }

    public int getNumberOfFlags() {
        return numberOfFlags;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoardWidth(int boardWidth) {
        this.boardWidth = boardWidth;
    }

    public void setBoardHeight(int boardHeight) {
        this.boardHeight = boardHeight;
    }

    public void setNumberOfMines(int numberOfMines) {
        this.numberOfMines = numberOfMines;
    }

    public void setNumberOfFlags(int numberOfFlags) {
        this.numberOfFlags = numberOfFlags;
    }

}
