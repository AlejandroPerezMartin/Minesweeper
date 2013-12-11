package minesweeper.model;

public class BoardLoader {

    private static BoardLoader instance;

    private BoardLoader() {
    }

    public static BoardLoader getInstance() {
        if (instance == null) {
            instance = new BoardLoader();
        }
        return instance;
    }

    public void execute(BoardModel boardModel) {
        buildBoard(boardModel);
        placeMines(boardModel);
        placeNumbers(boardModel);
    }

    public void buildBoard(BoardModel boardModel) {
        for (int i = 0; i < boardModel.getBoardWidth(); i++) {
            for (int j = 0; j < boardModel.getBoardHeight(); j++) {
                boardModel.getBoard()[i][j] = new Cell(i, j);
                boardModel.getBoard()[i][j].setContent("0");
            }
        }
    }

    public void placeMines(BoardModel boardModel) {
        int addedMines = 0;
        while (addedMines < boardModel.getNumberOfMines()) {
            int x = getRandomInt(boardModel.getBoardWidth());
            int y = getRandomInt(boardModel.getBoardHeight());
            if (!boardModel.getBoard()[x][y].isMine()) {
                boardModel.getBoard()[x][y].setContent("#");
                addedMines++;
            }
        }
    }

    public void placeNumbers(BoardModel boardModel) {
        for (Cell[] cells : boardModel.getBoard()) {
            for (Cell cell : cells) {
                cell.setContent(checkNeighborsForMines(boardModel, cell.getPosition()));
            }
        }
    }

    public String checkNeighborsForMines(BoardModel boardModel, Point position) {
        int minesNearToCell = 0;

        if (boardModel.getBoard()[position.getPosX()][position.getPosY()].isMine()) {
            return "#";
        }

        for (int i = position.getPosX() - 1; i <= position.getPosX() + 1; i++) {
            for (int j = position.getPosY() - 1; j <= position.getPosY() + 1; j++) {
                if (i == position.getPosX() && j == position.getPosY()) {
                    continue;
                }
                if (checkLimits(i, j, boardModel) && boardModel.getBoard()[i][j].isMine()) {
                    minesNearToCell += 1;
                }
            }
        }
        return Integer.toString(minesNearToCell);
    }

    public boolean checkLimits(int x, int y, BoardModel boardModel) {
        return (x >= 0 && x < boardModel.getBoardWidth() && y >= 0 && y < boardModel.getBoardHeight());
    }

    public int getRandomInt(int range) {
        return (int) Math.round(Math.random() * (range - 1));
    }

}
