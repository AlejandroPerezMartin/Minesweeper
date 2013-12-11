package minesweeper.model;

public class BoardUnhider {

    public static void unhideCell(BoardModel boardModel, Point position) {
        Cell currentCell = boardModel.getBoard()[position.getPosX()][position.getPosY()];

        if (currentCell.isMine()) {
            boardModel.gameOver();
        }
        else if (currentCell.isEmpty()) {
            unhideNeighborEmptyCells(boardModel, currentCell);
        }

        currentCell.setVisible(true);
    }

    public static void unhideNeighborEmptyCells(BoardModel boardModel, Cell currentCell) {
        currentCell.setVisible(true);

        for (int i = currentCell.getPositionX() - 1; i <= currentCell.getPositionX() + 1; i++) {
            for (int j = currentCell.getPositionY() - 1; j <= currentCell.getPositionY() + 1; j++) {

                if (i == currentCell.getPositionX() && j == currentCell.getPositionY()) {
                    continue;
                }

                if (!checkLimits(i, j, boardModel) || boardModel.getBoard()[i][j].isVisible()) {
                    continue;
                }

                if (boardModel.getBoard()[i][j].isEmpty() || boardModel.getBoard()[i][j].isNumber()) {
                    boardModel.getBoard()[i][j].setVisible(true);
                    unhideCell(boardModel, new Point(i, j));
                }
            }
        }
    }

    public static boolean checkLimits(int x, int y, BoardModel boardModel) {
        return (x >= 0 && x < boardModel.getBoardWidth() && y >= 0 && y < boardModel.getBoardHeight());
    }
}
