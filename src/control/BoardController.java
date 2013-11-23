package control;

import model.Board;

public class BoardController {

    public void execute() {
        Board game = new Board(10);
        game.buildBoard();
        game.placeMines();
        game.placeNumbers();
        game.showBoard();
    }
}
