package main.java.piece;

import main.java.board.Board;
import main.java.Color;
import main.java.Coordinates;

import java.util.HashSet;
import java.util.Set;

abstract public class Piece {
    public final Color color;
    public Coordinates coordinates;

    public Piece(Color  color, Coordinates coordinates) {
        this.color = color;
        this.coordinates = coordinates;
    }
   public Set<Coordinates> getAvailableMoveSquares(Board board){
       Set<Coordinates> result = new HashSet<>();
        for(CoordinateShift shift : getPieceMove()){
            if(coordinates.canShift(shift)){
                Coordinates newCoordinates = coordinates.shift(shift);
                if(isSquareAvailableForMove(newCoordinates, board)){
                    result.add(newCoordinates);
                }
            }
        }
        return result;
    }

protected  boolean isSquareAvailableForMove(Coordinates coordinates, Board board){
    return board.isSquareEmpty(coordinates)||board.getPiece(coordinates).color!=color;
}


    protected abstract Set<CoordinateShift>getPieceMove();

    public Set<Coordinates> getAttackedSquares(Board board) {

        Set<CoordinateShift> pieceAttacks = getPieceAttacks();
      Set<Coordinates>  result=new HashSet<>();
        for (CoordinateShift pieceAttack : pieceAttacks) {
            if(coordinates.canShift(pieceAttack)){
                Coordinates shiftedCoordinates=coordinates.shift(pieceAttack);

                if(isSquareAvailableForAttack(shiftedCoordinates, board)){
                    result.add(shiftedCoordinates);
                }
            }
        }
        return  result;

    }

    protected boolean isSquareAvailableForAttack(Coordinates coordinates, Board board) {
        return  true;
    }

    protected  Set<CoordinateShift> getPieceAttacks() {
        return getPieceMove();
    }
}

