package main.java.piece;

import main.java.Color;
import main.java.Coordinates;

import java.util.Set;

public class Rook extends LongRangePiece implements  IRook{
    public Rook(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinateShift> getPieceMove() {
       return getRookMove();
    }

}
