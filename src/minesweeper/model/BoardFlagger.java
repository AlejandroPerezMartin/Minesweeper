package minesweeper.model;

public class BoardFlagger {

    public static void setFlag(BoardModel boardModel, Point point) {
        Cell currentCell = boardModel.getBoard()[point.getPosX()][point.getPosY()];

        if (boardModel.getNumberOfFlags() > 0 && !currentCell.isFlagged()) {
            currentCell.setFlagged(true);
            boardModel.setNumberOfFlags(boardModel.getNumberOfFlags() - 1);
        }
    }

    public static void unsetFlag(BoardModel boardModel, Point point) {
        Cell currentCell = boardModel.getBoard()[point.getPosX()][point.getPosY()];

        if (boardModel.getNumberOfFlags() < boardModel.getNumberOfMines() && currentCell.isFlagged()) {
            currentCell.setFlagged(false);
            boardModel.setNumberOfFlags(boardModel.getNumberOfFlags() + 1);
        }
    }
}
