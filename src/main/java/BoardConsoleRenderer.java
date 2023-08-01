package main.java;
import main.java.piece.Piece;
public class BoardConsoleRenderer {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";

    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";

    public static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";

    public static final String ANSI_HIGHLIGHTED_SQUARE_BACKGROUND = "\u001B[45m";

    public void render(Board board) {
        for (int rank = 8; rank >= 1; rank--) {
            String line="";
            for (File file : File.values()) {
                Coordinates coordinates=new Coordinates(file, rank);
                if(board.isSquareEmpty(coordinates)) {
                    line += getSpriteForEmptySquare(coordinates);
                }
                else{
                    line+=getPiecesSprite(board.getPiece(coordinates));
                }
            }
            line+=ANSI_RESET;
            System.out.println(line);
        }
    }

    private String colorizeSprites(String sprite, Color pieceColor, boolean isSquareDark ){
        String result=sprite;
        if(pieceColor==Color.WHITE){
            result=ANSI_WHITE_PIECE_COLOR+result;
        }
        else{
            result=ANSI_BLACK_PIECE_COLOR+ result;
        }
        if(isSquareDark){
            result=ANSI_BLACK_SQUARE_BACKGROUND+result;
        }
        else{
            result=ANSI_WHITE_SQUARE_BACKGROUND+result;
        }
        return result;
    }
    private String getPiecesSprite(Piece piece){
        return colorizeSprites(" "+selectUnicodeSpriteForPieces(piece)+" ",piece.color, Board.isSquareDark(piece.coordinates) );
    }
    private String getSpriteForEmptySquare(Coordinates coordinates){
        return colorizeSprites("   ",Color.WHITE, Board.isSquareDark(coordinates) );
    }
    private String selectUnicodeSpriteForPieces(Piece piece) {
        switch (piece.getClass().getSimpleName()) {
            case "Pawn":
                return "♟︎";

            case "Knight":
                return "♞";

            case "Bishop":
                return "♝";

            case "Rook":
                return "♜";

            case "Queen":
                return "♛";

            case "King":
                return "♚";
        }
        return "";
    }
}