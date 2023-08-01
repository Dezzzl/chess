package main.java;

public class Main {
    public static void main(String[] args){
      Board board=new Board();
      board.setupDefaultPiecesPositions();

      Game game=new Game(board);
      game.gemeLoop();
    }
}
