package main.java.piece;

import main.java.Board;
import main.java.BoardUtils;
import main.java.Color;
import main.java.Coordinates;
import main.java.piece.Piece;

import java.util.HashSet;
import java.util.List;
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
