package main.java;

import main.java.piece.Piece;

import java.util.Set;

public class Game {
    private final Board board;
    private BoardConsoleRenderer renderer=new BoardConsoleRenderer();
    public Game(Board board) {
        this.board = board;
    }

    public void gemeLoop(){
        boolean isWhiteToMove=true;
     while(true){
         renderer.render(board);
         Coordinates sourceCoordinates= InputCoordinates.inputPieceCoordinatesForColor(
                 isWhiteToMove?Color.WHITE:Color.BLACK, board
         );
         Piece piece =board.getPiece(sourceCoordinates);
         Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);

         renderer.render(board, piece);
         Coordinates targetCoordinates = InputCoordinates.inputAvailableSquare(availableMoveSquares);
         board.movePiece(sourceCoordinates, targetCoordinates);
         isWhiteToMove=!isWhiteToMove;
     }
    }
}
