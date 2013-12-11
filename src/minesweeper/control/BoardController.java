package minesweeper.control;

import minesweeper.model.BoardFlagger;
import minesweeper.model.BoardLoader;
import minesweeper.model.BoardModel;
import minesweeper.model.BoardUnhider;
import minesweeper.model.Difficulty;
import minesweeper.model.Point;
import minesweeper.view.BoardViewer;

public class BoardController {

    private final BoardModel boardModel;

    public BoardController(String diff) {
        Difficulty difficulty = new Difficulty(diff);
        boardModel = new BoardModel(difficulty);

        BoardLoader.getInstance().execute(boardModel);
    }

    public void actionShowBoard() {
        BoardViewer.showBoard(boardModel);
    }

    public void actionShowRevealedBoard() {
        BoardViewer.showRevealedBoard(boardModel);
    }

    public void actionUnhideCell(int x, int y) {
        BoardUnhider.unhideCell(boardModel, new Point(x, y));
    }

    public void actionFlagCell(int x, int y) {
        BoardFlagger.setFlag(boardModel, new Point(x, y));
    }

    public void actionUnflagCell(int x, int y) {
        BoardFlagger.unsetFlag(boardModel, new Point(x, y));
    }

}
