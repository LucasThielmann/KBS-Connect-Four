package de.dualshower;

import de.dualshower.Main.PIECE;
import de.dualshower.IllegalMoveException;

public class GameCube {
    private PIECE[][][] pieces = new PIECE[4][4][4]; //column, row, height

    public GameCube() {
        for(int a = 0; a < 4; a++) {
            for(int b = 0; b < 4; b++) {
                for(int c = 0; c < 4; c++) {
                    pieces[a][b][c] = PIECE.EMPTY;
                }
            }
        }
    }

    public void setPiece(PIECE piece, int column, int row) throws IllegalMoveException {
        int height;
        for(height = 0; height < 4; height++) {
            if(pieces[column][row][height] == PIECE.EMPTY) {
                pieces[column][row][height] = piece;
            }
        }

        if(height == 4) {
            throw new IllegalMoveException("Piece could not be placed in pillar: <" + column +"," + row + ">");
        }
    }
}