/**
 * Created by Desktop on 30-Mar-17.
 */

import java.util.*;

public class GameBoard {
    private char[][] gameBoard;
    private boolean gameOnGoing = true;

    /**
     * This is the constructor for the GameBoard Class
     */
    public GameBoard() {
        gameBoard = new char[3][3];
        for (int row = 0; row < gameBoard.length; row++) {
            Arrays.fill(gameBoard[row], ' ');
        }
    } // end of the GameBoard constructor

    /**
     * This method will display the GameBoard to the screen
     */
    public void displayBoard() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[row].length; col++) {
                System.out.print("\t" + gameBoard[row][col]);
                if (col == 0 || col == 1) {
                    System.out.print(" | ");
                }
            }
            if (row == 0 || row == 1) {
                System.out.print("\n----------------------\n");
            }
        }
        System.out.println("\n\n");
    } // end of displayBoard method

    /**
     * This method will return true if the game is still active.
     */
    public boolean gameActive() {
        return gameOnGoing;
    }

    /**
     * This method will ask the user to pick a row and column, validate inputs and
     * call the method makeMove()
     */
    public void askPlayer(char player) {
        Scanner keyboard = new Scanner(System.in);
        int row, col;
        do {
            System.out.printf("Player %s, plaese enter a row (1-3): ", player);
            row = keyboard.nextInt();

            System.out.printf("Player %s, please enter a column (1-3): ", player);
            col = keyboard.nextInt();
        } while (notValid(row, col));
        makeMove(player, row - 1, col - 1);
    }   //end of askPlayer method.

    /**
     * This method will validate if the row and coloumn are between 1-3
     * and if the position is currently empty.
     */
    public boolean notValid(int row, int col) {
        if (row > 3 || row < 1 || col > 3 || col < 1 || !isEmpty(row, col)) {
            System.out.println("Invalid move!");
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method will check if a position is empty.
     * return true if the position is empty, false otherwise.
     */
    public boolean isEmpty(int row, int col) {
        if (gameBoard[row - 1][col - 1] == ' ') {
            return true;
        } else {
            System.out.println("That position is taken.\n");
            return false;
        }
    }   //  end of method isEmpty.

    /**
     * This method will validate if a player's move is allowed or not and return true
     * if the method is completed.
     */
    public boolean makeMove(char player, int row, int col) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            if (gameBoard[row][col] != ' ') {
                return false;
            } else {
                gameBoard[row][col] = player;
                return true;
            }
        } else {
            return false;
        }   // end of makeMove method
    }

    /**
     * This method will check to see if there are 3 X's or 3 O's is a single row or column.
     * return true if there is a winner, false otherwise.
     */
    public boolean checkForWinner() {
        //Loop over each row and check for a winner
        for (int row = 0; row < gameBoard.length; row++) {
            if (gameBoard[row][0] ==
                    gameBoard[row][1] && gameBoard[row][1] == gameBoard[row][2] && gameBoard[row][0] != ' ') {
                System.out.print("The winner is " + gameBoard[row][0]);
                gameOnGoing = false;
            }
        }
        //  loop over each coloumn and check for a winner
        for (int col = 0; col < gameBoard.length; col++) {
            if (gameBoard[0][col] ==
                    gameBoard[1][col] && gameBoard[1][col] == gameBoard[2][col] && gameBoard[0][col] != ' ') {
                System.out.print("The winner is " + gameBoard[0][col]);
                gameOnGoing = false;
            }
        }
        if (gameBoard[0][0] ==
                gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[0][0] != ' ') {
            System.out.print("The winner is " + gameBoard[0][0]);
            gameOnGoing = false;
        }
        if (gameBoard[2][0] ==
                gameBoard[1][1] && gameBoard[1][1] == gameBoard[0][2] && gameBoard[0][2] != ' ') {
            System.out.print("The winner is " + gameBoard[1][1]);
            gameOnGoing = false;
        }
        return false;
    }
}
