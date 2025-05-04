package TicTacToe;

import java.util.Deque;
import java.util.Scanner;

public class TicTacToe {

    private final Deque<Player> listOfPlayers= new java.util.ArrayDeque<>();
    private Board board;

    public void initializeGame() {
        Player player1 = new Player("Niteesh", new PlayingPieceX());
        Player player2 = new Player("Niteesh2", new PlayingPieceY());
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        this.board = new Board(3);
    }


    public void startGame() {
        boolean hasGameFinished = false;
        Scanner sc = new Scanner(System.in);
        while (!hasGameFinished) {
            Player player = listOfPlayers.removeFirst();

            if(board.isBoardFull()){
                System.out.println("Game is draw");
                board.printBoard();
                break;
            }

            System.out.println("Player with name:{} " + player.getName() + " is playing");
            System.out.println("Please enter row for your turn");
            int row = sc.nextInt();
            System.out.println("Please enter column for your turn");
            int col = sc.nextInt();
            boolean isValidMove = board.checkIfMoveIsValid(row, col, board.getBoard().length);
            System.out.println(isValidMove);
            if (!isValidMove) {
                System.out.println("Invalid move, please try again");
                board.printBoard();
                listOfPlayers.addFirst(player);
            } else {
                var playerPiece = player.getPlayingPiece();
                board.getBoard()[row][col] = playerPiece;
                board.printBoard();
                boolean isGameFinished = board.checkIfGameIsFinishedForPiece(row, col, playerPiece);
                if (isGameFinished) {
                    System.out.println("Player with name:{} " + player.getName() + " has won the game");
                    board.printBoard();
                    hasGameFinished = true;
                } else {
                    listOfPlayers.addLast(player);
                }
            }

        }
    }


}
