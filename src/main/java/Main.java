package main.java;

public class Main {
    public static void main(String[] args){
//      Board board=new Board();
//      board.setupDefaultPiecesPositions();
      Board board=  (new BoardFactory()).fromFEN("8/4b1P1/1p6/8/1R3P2/8/5Q2/8 w - - 0 1");
        BoardConsoleRenderer renderer =new BoardConsoleRenderer();
//
      Game game=new Game(board);
      game.gemeLoop();
    }
}
