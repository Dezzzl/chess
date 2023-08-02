package main.java.piece;

import main.java.Color;
import main.java.Coordinates;
import main.java.piece.Piece;

import java.util.Set;

public class Queen extends LongRangePiece implements IBishop, IRook{
    public Queen(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinateShift> getPieceMove() {

        Set<CoordinateShift> moves = getBishopMove();
        moves.addAll(getRookMove());
        return moves;
    }
}
