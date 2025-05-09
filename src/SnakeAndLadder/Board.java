package SnakeAndLadder;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private Cell[][] arr;


    public Cell[][] getArr(){
        return this.arr;
    }


    public Board(int boardSize, int noOfSnakes, int noOfLadders) {
        initializeBoard(boardSize);
        addSnakesAndLadders(10,10);
    }

    private void initializeBoard(int boardSize) {
        arr = new Cell[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            Arrays.fill(arr[i], new Cell());
        }
    }

    private void addSnakesAndLadders(int noOfSnakes, int noOfLadders) {
        while (noOfSnakes > 0) {
            int snakeStart = ThreadLocalRandom.current().nextInt(1, arr.length * arr.length - 1);
            int snakeEnd = ThreadLocalRandom.current().nextInt(1, arr.length * arr.length - 1);
            if(snakeEnd >= snakeStart){
                continue;
            }
            Jump jump = new Jump(snakeStart, snakeEnd);
            Cell cell = getCell(snakeStart);
            cell.setJump(jump);
            noOfSnakes--;
        }

        while(noOfLadders > 0){
            int ladderStart = ThreadLocalRandom.current().nextInt(1, arr.length * arr.length - 1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1, arr.length * arr.length - 1);;
            if(ladderEnd <= ladderStart){
                continue;
            }

            Jump jump = new Jump(ladderStart,ladderEnd);
            Cell cell = getCell(ladderStart);
            cell.setJump(jump);
            noOfLadders--;
        }
    }

    public Cell getCell(int n) {
        int row = n / arr.length;
        int col = n % arr.length;
        return arr[row][col];
    }
}
