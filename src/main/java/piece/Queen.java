package main.java.piece;

import main.java.Color;
import main.java.Coordinates;
import main.java.piece.Piece;

import java.util.Set;

public class Queen extends Piece {
    public Queen(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinateShift> getPieceMove() {
        return null;
    }
}
