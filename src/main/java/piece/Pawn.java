package main.java.piece;

import main.java.board.Board;
import main.java.Color;
import main.java.Coordinates;
import main.java.board.BoardUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pawn extends Piece {
    public Pawn(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinateShift> getPieceMove() {
        Set<CoordinateShift> result =new HashSet<>();
        if(color==Color.WHITE){
            result.add(new CoordinateShift(0,1));
            if(coordinates.rank==2){
                result.add(new CoordinateShift(0,2));
            }
            result.add(new CoordinateShift(1,1));
            result.add(new CoordinateShift(-1,1));
        }else {
            result.add(new CoordinateShift(0,-1));
            if(coordinates.rank==7){
                result.add(new CoordinateShift(0,-2));
            }
            result.add(new CoordinateShift(1,1));
            result.add(new CoordinateShift(-1,1));
        }
        return result;
    }

    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
        if(this.coordinates.file== coordinates.file){
            int rankShift = Math.abs(this.coordinates.rank - coordinates.rank);

            if (rankShift == 2) {
                List<Coordinates> between = BoardUtils.getVerticalCoordinatesBetween(this.coordinates, coordinates);

                return (board.isSquareEmpty(between.get(0))) && board.isSquareEmpty(coordinates);
            } else {
                return board.isSquareEmpty(coordinates);
            }
        }
        else {
            if(board.isSquareEmpty(coordinates)){
                return false;
            }
            else {
                return board.getPiece(coordinates).color != color;
            }
        }
    }

    @Override
    protected Set<CoordinateShift> getPieceAttacks() {
        Set<CoordinateShift> result =new HashSet<>();
        if(color==Color.WHITE){
            result.add(new CoordinateShift(1,1));
            result.add(new CoordinateShift(-1,1));
        }
        else{
            result.add(new CoordinateShift(1,-1));
            result.add(new CoordinateShift(-1,-1));
        }
        return result;
    }
}
