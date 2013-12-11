package minesweeper.control;

import minesweeper.view.GameDialog;

public class GameController {

    public GameController() {

        BoardController boardController = new BoardController(GameDialog.askDifficulty());

        while (true) {
            boardController.actionShowBoard();
            switch (GameDialog.askMove()) {
                case 1:
                    int a = GameDialog.askFirstParameter();
                    int b = GameDialog.askSecondParameter();
                    boardController.actionUnhideCell(a, b);
                    break;
                case 2:
                    int c = GameDialog.askFirstParameter();
                    int d = GameDialog.askSecondParameter();
                    boardController.actionFlagCell(c, d);
                    break;
                case 3:
                    int e = GameDialog.askFirstParameter();
                    int f = GameDialog.askSecondParameter();
                    boardController.actionUnflagCell(e, f);
                    break;
                default:
                    System.out.println("(ERROR) Comando no reconocido...");
                    break;
            }
            boardController.actionShowRevealedBoard();
        }
    }

}
