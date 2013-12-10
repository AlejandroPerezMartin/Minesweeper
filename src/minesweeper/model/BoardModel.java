package minesweeper.model;

public final class BoardModel {

    private int boardWidth;
    private int boardHeight;
    private int numberOfMines;
    private int numberOfFlags;

    private CellModel[][] board;
    private DifficultyModel difficulty;

    public BoardModel(DifficultyModel difficulty) {
        setDifficulty(difficulty);
    }

    public void setDifficulty(DifficultyModel difficulty) {
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
        this.board = new CellModel[boardWidth][boardHeight];
    }

    public void buildBoard() {
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                board[i][j] = new CellModel(i, j);
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
        for (CellModel[] cells : board) {
            for (CellModel cell : cells) {
                cell.setContent(checkNeighborsForMines(cell.getPosition()));
            }
        }
    }

    public void unhideCell(PointModel position) {
        CellModel currentCell = board[position.getPosX()][position.getPosY()];

        if (currentCell.isMine()) {
            gameOver();
        }
        else if (currentCell.isEmpty()) {
            unhideNeighborEmptyCells(currentCell);
        }

        currentCell.setVisible(true);
    }

    public void unhideNeighborEmptyCells(CellModel currentCell) {
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
                    unhideCell(new PointModel(i, j));
                }
            }
        }
    }

    public void gameOver() {
        System.out.println("GAME OVER :(");
    }

    public String checkNeighborsForEmptyCells(PointModel position) {
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

    public String checkNeighborsForMines(PointModel position) {
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

    public CellModel getPosition(int positionX, int positionY) {
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

    public DifficultyModel getDifficulty() {
        return difficulty;
    }

    public CellModel[][] getBoard() {
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

    public void setFlag(PointModel point) {
        CellModel currentCell = board[point.getPosX()][point.getPosY()];
        
        if (numberOfFlags > 0 && !currentCell.isFlagged()) {
            currentCell.setFlagged(true);
            numberOfFlags--;
        }
    }

    public void unsetFlag(PointModel point) {
        CellModel currentCell = board[point.getPosX()][point.getPosY()];

        if (numberOfFlags < numberOfMines && currentCell.isFlagged()) {
            currentCell.setFlagged(false);
            numberOfFlags++;
        }
    }

}
