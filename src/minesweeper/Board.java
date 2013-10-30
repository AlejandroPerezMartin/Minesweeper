
package minesweeper;

import java.awt.Point;

public class Board {
    
    private int columns = 10;
    private int rows = 10;
    private int mines = 10;
    private final Square[][] board;

    public Board() {
        this.board = new Square[rows][columns];

        createBoard(columns, rows, mines);
    }
    
    public void createBoard(int columns, int rows, int mines){
        buildSquares();
        placeMines();
        placeNumbers();
    }
    
    public void buildSquares() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                board[i][j] = new Square();
                board[i][j].setPosition(new Point(i,j));
                board[i][j].setContent(" # ");
            }
        }
    }
    
    public void placeMines() {
        Point[] minesPositions = new Point[mines];
        
        for (Point point : minesPositions) {
            point = new Point( (int) Math.round(Math.random()*(rows-1)), (int) Math.round(Math.random()*(rows-1)) );
            board[(int) point.getX()][(int) point.getY()].setPosition(point);
            board[(int) point.getX()][(int) point.getY()].setContent(" x ");            
        }
    }
    
    public void placeNumbers(){
        for (Square[] square : board) {
            for (Square square1 : square) {
                square1.setContent( checkAdjacentBox( square1.getPosition() ) );
            }
        }
    }
    
    public String checkAdjacentBox(Point position) {
        
        int minesNearToBox = 0;
        
        if( board[(int) position.getX()][(int) position.getY()].isMine() ) return " x ";
        
        for (int i = (int)(position.getX()-1); i < (int)(position.getX()+1); i++) {
            for (int j = (int)(position.getY()-1); j < (int)(position.getY()+1); j++) {
                
                if ( i == (int)(position.getX()) && j == (int)(position.getY()) )
                    continue;
                
                if ( checkLimits(i,j) && board[i][j].getContent().equals(" x ") )
                    minesNearToBox++;
                    //System.out.println(i+"-"+j+" : "+minesNearToBox);
                
            }
        }
        return " "+Integer.toString(minesNearToBox)+" ";
    }
    
    public boolean checkLimits(int x, int y){
        if ( x >= 0 && x < rows && y >= 0 && y < columns )
            return true;
        return false;
    }
    
    public void showBoard() {
         for (int i = 0; i < this.rows; i++) {
            System.out.print(i+" | ");
            for (int j = 0; j < this.columns; j++) {
                System.out.print(board[i][j].getContent());
            }
            System.out.println(""+ " |");
        }
    }
    
    public void emptyBoard() {
        for (Square[] square : board) {
            for (Square square1 : square) {
                square1.setContent(" # ");
                square1.setRevealed(false);
            }
        }
    }
    
    public void revealBox() {
    }
    
    public void revealAdjacentBoxes() {
    }
    
    public void revealAllBoxes() {
    }
    
}
