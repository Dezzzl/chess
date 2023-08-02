package main.java.piece;

import main.java.Board;
import main.java.BoardUtils;
import main.java.Color;
import main.java.Coordinates;

import java.util.List;

public abstract class LongRangePiece extends Piece{
    public LongRangePiece(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }


    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
        boolean result = super.isSquareAvailableForMove(coordinates, board);
        if (result) {
            List<Coordinates> coordinatesBetween;
            if (this.coordinates.file == coordinates.file) {
                coordinatesBetween = BoardUtils.getVerticalCoordinatesBetween(this.coordinates, coordinates);
            } else if (this.coordinates.rank.equals(coordinates.rank)) {
                coordinatesBetween = BoardUtils.getHorizontalCoordinatesBetween(this.coordinates, coordinates);
            } else {
                coordinatesBetween = BoardUtils.getDiagonalCoordinatesBetween(this.coordinates, coordinates);
            }

            for (Coordinates c : coordinatesBetween) {
                if (!board.isSquareEmpty(c)) {
                    return false;
                }
            }

            return true;
        }
        else {
            return false;
        }
    }
}
