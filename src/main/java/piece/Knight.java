package main.java.piece;

import main.java.Color;
import main.java.Coordinates;
import main.java.piece.Piece;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece {
    public Knight(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinateShift> getPieceMove() {
        return new HashSet<>(Arrays.asList(
                new CoordinateShift(1,2),
                new CoordinateShift(2,1),

                new CoordinateShift(2,-1),
                new CoordinateShift(1,-2),

                new CoordinateShift(-1,-2),
                new CoordinateShift(-2,-1),

                new CoordinateShift(-1,2),
                new CoordinateShift(-2,1)
        ));
    }
}
