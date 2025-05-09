package SnakeAndLadder;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Game {

    private Board board;
    private Dice dice;

    private final Deque<Player> players = new ConcurrentLinkedDeque<>();


    public void initializeGame() {
        board = new Board(10, 10, 10);
        dice = new Dice(2);
        Player player1 = new Player("Niteesh");
        Player player2 = new Player("Niteesh2");
        players.add(player1);
        players.add(player2);
    }

    public void startGame() {
        boolean gameFinished = false;
        while (!gameFinished) {
            Player player = players.removeFirst();
            int movePositionBy = dice.rollDice();
            int playerNewPosition = player.getPosition() + movePositionBy;
            playerNewPosition = jumpCheck(playerNewPosition);
            player.setPosition(playerNewPosition);
            System.out.println("Player playing is " + player.getName() + " and moving to " + playerNewPosition);
            if (playerNewPosition >= 99) {
                System.out.println("Yahoo we have a winner " + player.getName());
                gameFinished = true;
            }
            ;
            players.addLast(player);
        }
    }

    private int jumpCheck(int playerNewPosition) {

        if (playerNewPosition > board.getArr().length * board.getArr().length - 1) {
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if (cell.getJump() != null && cell.getJump().getStart() == playerNewPosition) {
            String jumpBy = (cell.getJump().getStart() < cell.getJump().getEnd()) ? "ladder" : "snake";
            System.out.println("jump done by: " + jumpBy);
            return cell.getJump().getEnd();
        }
        return playerNewPosition;
    }


}
