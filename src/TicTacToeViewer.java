import javax.swing.*;
import java.awt.*;
public class TicTacToeViewer extends JFrame{
    // TODO: Complete this class
    //instance variable
    private TicTacToe a;
    private Square[][] squares;
    private Image X;
    private Image O;
    private static final int    WINDOW_WIDTH = 900,
                                WINDOW_HEIGHT = 700;

    public TicTacToeViewer(TicTacToe a){
        this.a = a;
        this.squares = a.getBoard();
        X = new ImageIcon("Resources/X.png").getImage();
        O = new ImageIcon("Resources/O.png").getImage();
        //array of images
        //pass the images when i call draw for square
        //draw it if the marker is x or o and draw corresponding image

        this.setTitle("TicTacToe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image getXImage(){
        return X;
    }
    public Image getOImage(){
        return O;
    }
    public void paint(Graphics g){
        int x = 300;
        int y = 300;
        for(int i = 0; i<3; i++){
            String numbers = String.valueOf(i);
            g.setFont(new Font("Serif", Font.PLAIN, 30));
            g.drawString(numbers, x, y);
            y += 100;
        }

        x = 400;
        y = 200;
        for(int j = 0; j<3; j++){
            String numbers = String.valueOf(j);
            g.setFont(new Font("Serif", Font.PLAIN, 30));
            g.drawString(numbers, x, y);
            x += 100;

        }
//fix
        squares = a.getBoard();
        if(squares != null){
            for(int i = 0; i< squares.length; i++){
                for(int j = 0; j<squares[0].length; j++){
                    this.squares[i][j].draw(g, X, O);
                }
            }
        }
    }

}
