package Chess;

import comp124graphics.*;
import comp124graphics.Image;
import comp124graphics.Rectangle;


import java.awt.*;

public class Chess {
    private static Rectangle[][] tiles = new Rectangle[8][8];
    private static Image[] bPieces = new Image[16];
    private static Image[] wPieces = new Image[16];


    public static void main(String[] args) {
        Thread newGame = new Thread(new Runnable() {
            @Override
            public void run(){
                CanvasWindow canvas = new CanvasWindow("Chess", 800, 800);
                BoardSetup board = new BoardSetup();
                board.initializePieces();
                board.GUIBoard(canvas);
                board.setUpBoard(canvas, bPieces, wPieces);
            }
        });

        newGame.start();


    }

    public static class BoardSetup {

        public void GUIBoard(CanvasWindow canvas) {
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    int x = col * 80;
                    int y = row * 80;
                    Rectangle rect = new Rectangle(x, y, 80, 80);
                    if ((row % 2) == (col % 2)) {
                        rect.setFillColor(Color.GRAY);
                    }
                    else {
                        Color cream = new Color(255, 253, 208);
                        rect.setFillColor(cream);
                    }
                    rect.setFilled(true);
                    canvas.add(rect);
                    tiles[row][col] = rect;
                }
            }
        }

        public void initializePieces() {
            bPieces[0] = new Image(0, 0, "image/bR.png");
            bPieces[1] = new Image(0, 0, "image/bN.png");
            bPieces[2] = new Image(0, 0, "image/bB.png");
            bPieces[3] = new Image(0, 0, "image/bQ.png");
            bPieces[4] = new Image(0, 0, "image/bK.png");
            bPieces[5] = new Image(0, 0, "image/bB.png");
            bPieces[6] = new Image(0, 0, "image/bN.png");
            bPieces[7] = new Image(0, 0, "image/bR.png");
            bPieces[8] = new Image(0, 0, "image/bP.png");
            bPieces[9] = new Image(0, 0, "image/bP.png");
            bPieces[10] = new Image(0, 0, "image/bP.png");
            bPieces[11] = new Image(0, 0, "image/bP.png");
            bPieces[12] = new Image(0, 0, "image/bP.png");
            bPieces[13] = new Image(0, 0, "image/bP.png");
            bPieces[14] = new Image(0, 0, "image/bP.png");
            bPieces[15] = new Image(0, 0, "image/bP.png");

            wPieces[0] = new Image(0, 0, "image/wR.png");
            wPieces[1] = new Image(0, 0, "image/wN.png");
            wPieces[2] = new Image(0, 0, "image/wB.png");
            wPieces[3] = new Image(0, 0, "image/wQ.png");
            wPieces[4] = new Image(0, 0, "image/wK.png");
            wPieces[5] = new Image(0, 0, "image/wB.png");
            wPieces[6] = new Image(0, 0, "image/wN.png");
            wPieces[7] = new Image(0, 0, "image/wR.png");
            wPieces[8] = new Image(0, 0, "image/wP.png");
            wPieces[9] = new Image(0, 0, "image/wP.png");
            wPieces[10] = new Image(0, 0, "image/wP.png");
            wPieces[11] = new Image(0, 0, "image/wP.png");
            wPieces[12] = new Image(0, 0, "image/wP.png");
            wPieces[13] = new Image(0, 0, "image/wP.png");
            wPieces[14] = new Image(0, 0, "image/wP.png");
            wPieces[15] = new Image(0, 0, "image/wP.png");
        }

        public void setUpBoard(CanvasWindow canvas, Image[] bPieces, Image[] wPieces) {
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    int x = col * 80 + 8;
                    int y = row * 80 + 8;
                    if(row == 0){
                        Image img = bPieces[col];
                        img.setPosition(x, y);
                        canvas.add(img);
                    }

                    else if(row == 1){
                        Image img = bPieces[col + 8];
                        img.setPosition(x, y);
                        canvas.add(img);
                    }

                    else if(row == 6){
                        Image img = wPieces[col + 8];
                        img.setPosition(x, y);
                        canvas.add(img);
                    }

                    else if(row == 7){
                        Image img = wPieces[col];
                        img.setPosition(x, y);
                        canvas.add(img);
                    }

                }
            }
        }

    }

}

