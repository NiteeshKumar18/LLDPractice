package TicTacToe;

public class Main {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.initializeGame();
        ticTacToe.startGame();
    }
}


/*

Key take aways:

1) Interface doesnt need access modifier, they are always public
2)An instance field (also called an instance variable) is a non-static variable declared inside a class.
Each object (instance) of the class gets its own copy of this field.
3) If we declare a var in interface, its by default static final.Its not instance field
 */
