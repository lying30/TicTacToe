import javax.swing.*;
import java.awt.*;
/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {
    TicTacToeViewer a;
    TicTacToe b;
    private String marker;
    private int row;
    private int col;

    private static final int    SQUARE_WIDTH = 100,
            SQUARE_HEIGHT = 100;
    private int x ;
    private int y;
    private Image Ximage;
    private Image Oimage;
    private boolean isWinningSquare;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer a, TicTacToe b) {
        this.row = row;
        this.col = col;
        //call the variables from the viewer to access the variable
        this.a = a;
        this.b = b;
        x = (col*SQUARE_WIDTH) + 350;
        y = (row*SQUARE_HEIGHT) + 225;


        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }
    public void draw(Graphics g, Image X, Image O){
        g.drawRect(x,y,SQUARE_WIDTH,SQUARE_HEIGHT);
        if(this.isWinningSquare == true){
            g.setColor(Color.green);
            g.fillRect(x,y,100,100);
        }
        if(marker.equals("X"))
        {
            g.drawImage(X,x,y, 100, 100, a);

        }
        else if(marker.equals("O"))
        {
            g.drawImage(O,x,y, 100, 100, a);
        }
        if(b.getGameOver() == true && b.getWinner().equals("X")){
            g.setColor(Color.black);
            g.drawString("X Wins!", 400, 600);
        }
        else if(b.getGameOver() == true && b.getWinner().equals("O")){
            g.setColor(Color.black);
            g.drawString("O Wins!", 400, 600);
        }
        else if (b.getGameOver() == true && b.checkTie() == true) {
            g.setColor(Color.black);
            g.drawString("Game ends in a tie!", 400,600);
        }

        //draw the image there on top of the square

    }
}
