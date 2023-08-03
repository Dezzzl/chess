package main.java;

import main.java.board.Board;
import main.java.board.Move;

import java.util.Collections;
import java.util.List;

public class Game {
    private final Board board;

    private  final List<GameStateChecker>checkers= List.of(
            new StalemateGameStateChecker(),
            new CheckmateGameStateChecker()
    );
    private BoardConsoleRenderer renderer=new BoardConsoleRenderer();
    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop(){
        Color colorToMove=Color.WHITE;
        GameState state=determineGameState(board, colorToMove);
     while(state==GameState.ONGOING){
         renderer.render(board);
         Move move=InputCoordinates.inputMove(board, colorToMove, renderer);
         board.makeMove(move);
         colorToMove=colorToMove.opposite();
        state= determineGameState(board, colorToMove);
     }
        renderer.render(board);
        System.out.println("Game ended with state ="+ state);
    }

    private GameState determineGameState(Board board, Color color) {
        for(GameStateChecker checker: checkers){
           GameState state= checker.check(board, color);

           if(state!=GameState.ONGOING){
               return state;
           }
        }
        return  GameState.ONGOING;
    }
}
