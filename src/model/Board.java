package model;

public class Board {

    private int boardWidth;
    private int boardHeight;
    private int numberOfMines;
    private final Cell[][] board;
    private Point[] flaggedMines;
    private final String difficulty;

    public Board(String difficulty) {
        if (difficulty.equals("medium")) {
            this.numberOfMines = 40;
            this.boardWidth = 16;
            this.boardHeight = boardWidth;
            this.difficulty = difficulty;
        }
        else if (difficulty.equals("hard")) {
            this.numberOfMines = 99;
            this.boardWidth = 16;
            this.boardHeight = 40;
            this.difficulty = difficulty;
        }
        else {
            this.numberOfMines = 10;
            this.boardWidth = 8;
            this.boardHeight = boardWidth;
            this.difficulty = "easy";
        }
        this.board = new Cell[boardWidth][boardHeight];
    }

    public void buildBoard() {
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                board[i][j] = new Cell(i, j);
                board[i][j].setContent("0");
            }
        }
    }

    public void placeMines() {
        int addedMines = 0;
        while (addedMines < numberOfMines) {
            int x = getRandomInt(boardWidth);
            int y = getRandomInt(boardHeight);
            if (!board[x][y].isMine()) {
                board[x][y].setContent("#");
                addedMines++;
            }
        }
    }

    public void placeNumbers() {
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                cell.setContent(checkNeighborsForMines(cell.getPosition()));
            }
        }
    }

    public void unhideCell(Point position) {
        Cell currentCell = board[position.getPosX()][position.getPosY()];

        if (currentCell.isMine()) {
            gameOver();
        }
        else if (currentCell.isEmpty()) {
            unhideNeighborEmptyCells(currentCell);
        }

        currentCell.setVisible(true);
    }

    public void unhideNeighborEmptyCells(Cell currentCell) {
        currentCell.setVisible(true);

        for (int i = currentCell.getPositionX() - 1; i <= currentCell.getPositionX() + 1; i++) {
            for (int j = currentCell.getPositionY() - 1; j <= currentCell.getPositionY() + 1; j++) {

                if (i == currentCell.getPositionX() && j == currentCell.getPositionY()) {
                    continue;
                }

                if (!checkLimits(i, j) || board[i][j].isVisible()) {
                    continue;
                }

                if (board[i][j].isEmpty() || board[i][j].isNumber()) {
                    board[i][j].setVisible(true);
                    unhideCell(new Point(i, j));
                }
            }
        }
    }

    public void gameOver() {
        System.out.println("GAME OVER :(");
    }

    public String checkNeighborsForEmptyCells(Point position) {
        int minesNearToCell = 0;

        if (board[position.getPosX()][position.getPosY()].isMine()) {
            return "#";
        }

        for (int i = position.getPosX() - 1; i <= position.getPosX() + 1; i++) {
            for (int j = position.getPosY() - 1; j <= position.getPosY() + 1; j++) {
                if (i == position.getPosX() && j == position.getPosY()) {
                    continue;
                }
                if (checkLimits(i, j) && board[i][j].isMine()) {
                    minesNearToCell += 1;
                }
            }
        }
        return Integer.toString(minesNearToCell);
    }

    public String checkNeighborsForMines(Point position) {
        int minesNearToCell = 0;

        if (board[position.getPosX()][position.getPosY()].isMine()) {
            return "#";
        }

        for (int i = position.getPosX() - 1; i <= position.getPosX() + 1; i++) {
            for (int j = position.getPosY() - 1; j <= position.getPosY() + 1; j++) {
                if (i == position.getPosX() && j == position.getPosY()) {
                    continue;
                }
                if (checkLimits(i, j) && board[i][j].isMine()) {
                    minesNearToCell += 1;
                }
            }
        }
        return Integer.toString(minesNearToCell);
    }

    public boolean checkLimits(int x, int y) {
        return (x >= 0 && x < boardWidth && y >= 0 && y < boardHeight);
    }

    public int getRandomInt(int range) {
        return (int) Math.round(Math.random() * (range - 1));
    }

    public void showBoard() {
        System.out.print("   ");
        for (int i = 0; i < boardWidth; i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
        System.out.println("  -----------------------");
        for (int i = 0; i < boardWidth; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < boardHeight; j++) {
                if (board[i][j].isVisible()) {
                    System.out.print(board[i][j].getContent() + " ");
                }
                else {
                    System.out.print("· ");
                }
            }
            System.out.println("| " + i);
        }
        System.out.println("  -----------------------");
        System.out.print("   ");
        for (int i = 0; i < boardWidth; i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
    }

    public void showRevealedBoard() {
        System.out.print("   ");
        for (int i = 0; i < boardWidth; i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
        System.out.println("  -----------------------");
        for (int i = 0; i < boardWidth; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < boardHeight; j++) {
                System.out.print(board[i][j].getContent() + " ");
            }
            System.out.println("| " + i);
        }
        System.out.println("  -----------------------");
        System.out.print("   ");
        for (int i = 0; i < boardWidth; i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
    }

    public int getBoardSize() {
        return boardWidth;
    }

    public int getNumberOfMines() {
        return numberOfMines;
    }

    public void setBoardSize(int boardSize) {
        this.boardWidth = boardSize;
    }

    public void setNumberOfMines(int mines) {
        this.numberOfMines = mines;
    }

    public void markFlag(Point point) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
