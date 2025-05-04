package TicTacToe;

public class Board {

    private int SIZE;
    private PlayingPiece[][] board;

    public Board(int SIZE) {
        this.SIZE = SIZE;
        this.board = new PlayingPiece[SIZE][SIZE];
    }

    public PlayingPiece[][] getBoard() {
        return board;
    }

    public boolean checkIfMoveIsValid(int row, int col, int size) {
        if (row >= size || col >= size) {
            return false;
        }
        if (row < 0 || col < 0) {
            return false;
        }

        if (board[row][col] != null) {
            return false;
        }

        return true;
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean checkIfGameIsFinishedForPiece(int row, int col, PlayingPiece piece) {
        boolean isRowFinished = true;
        boolean isColumnFinished = true;
        boolean isDiagnoalFinished = true;
        boolean isAntiDiagnoalFinished = true;


        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == null || board[row][i] != piece) {
                isRowFinished = false;
                break;
            }
        }
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == null || board[i][col] != piece) {
                isColumnFinished = false;
                break;
            }
        }


        //need to check diagonals
        for(int i=0, j=0; i<SIZE;i++,j++) {
            if (board[i][j] == null || board[i][j] != piece) {
                isDiagnoalFinished = false;
                break;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=SIZE-1; i<SIZE;i++,j--) {
            if (board[i][j] == null || board[i][j] != piece) {
                isAntiDiagnoalFinished = false;
                break;
            }
        }

        return isColumnFinished || isDiagnoalFinished || isAntiDiagnoalFinished || isRowFinished;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }
}
