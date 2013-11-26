package model;

public class Board {

    private int boardSize;
    private int numberOfMines;
    private final Cell[][] board;

    public Board(int boardSize) {
        this.numberOfMines = Math.round((boardSize * boardSize) / 4);
        this.boardSize = boardSize;
        this.board = new Cell[boardSize][boardSize];
    }

    public void buildBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = new Cell(i, j);
                board[i][j].setContent("x");
            }
        }
    }

    public void placeMines() {
        int addedMines = 0;
        while (addedMines < numberOfMines) {
            int x = getRandomInt(boardSize);
            int y = getRandomInt(boardSize);
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

        if (currentCell.isEmpty()) {
            unHideEmptyCell(currentCell);
        }
        else if (currentCell.isMine()) {
            gameOver();
        }
        else {
            // Change content
            currentCell.setVisible(true);
        }
    }

    public void unHideEmptyCell(Cell currentCell) {
        currentCell.setContent(".");
        currentCell.setVisible(true);

        for (int i = currentCell.getPositionX() - 1; i <= currentCell.getPositionX() + 1; i++) {
            for (int j = currentCell.getPositionY() - 1; j <= currentCell.getPositionY() + 1; j++) {
                if (checkLimits(i, j) && board[i][j].isEmpty()) {
                    unhideCell(new Point(i, j));
                }
            }
        }
    }

    public void gameOver() {

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
        return (x >= 0 && x < boardSize && y >= 0 && y < boardSize);
    }

    public int getRandomInt(int range) {
        return (int) Math.round(Math.random() * (range - 1));
    }

    public void showBoard() {
        System.out.print("   ");
        for (int i = 0; i < boardSize; i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
        System.out.println("  -----------------------");
        for (int i = 0; i < boardSize; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j].getContent() + " ");
            }
            System.out.println("| " + i);
        }
        System.out.println("  -----------------------");
        System.out.print("   ");
        for (int i = 0; i < boardSize; i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
    }

    public int getBoardSize() {
        return boardSize;
    }

    public int getNumberOfMines() {
        return numberOfMines;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public void setNumberOfMines(int mines) {
        this.numberOfMines = mines;
    }

}
