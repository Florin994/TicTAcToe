import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = {{' ', ' ', ' '},
                          {' ', ' ', ' '},
                          {' ', ' ', ' '}};
        printBoard(board);

        while (!isTheGameFinished(board)) {
            playerMove(board, sc);
            if (isTheGameFinished(board)) {
                break;
            }
            computerMove(board);
            if (isTheGameFinished(board)) {
                break;
            }
        }
        printBoard(board);
        sc.close();
    }

    private static boolean isTheGameFinished(char[][] board) {
        if (hasTheWinner(board, 'X')) {
            System.out.println("Player Wins!");
            return true;
        }
        if (hasTheWinner(board, 'O')) {
            System.out.println("Computer Wins!");
            return true;
        }
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == ' ') {
                    return false;
                }
            }
        }
        System.out.println("The game ended in a tie.");
        return true;
    }

    private static boolean hasTheWinner(char[][] board, char playerIndicator) {
        return board[0][0] == playerIndicator && board[0][1] == playerIndicator && board[0][2] == playerIndicator ||
                board[1][0] == playerIndicator && board[1][1] == playerIndicator && board[1][2] == playerIndicator ||
                board[2][0] == playerIndicator && board[2][1] == playerIndicator && board[2][2] == playerIndicator ||

                board[0][0] == playerIndicator && board[1][0] == playerIndicator && board[2][0] == playerIndicator ||
                board[0][1] == playerIndicator && board[1][1] == playerIndicator && board[2][1] == playerIndicator ||
                board[0][2] == playerIndicator && board[1][2] == playerIndicator && board[2][2] == playerIndicator ||

                board[0][0] == playerIndicator && board[1][1] == playerIndicator && board[2][2] == playerIndicator ||
                board[0][2] == playerIndicator && board[1][1] == playerIndicator && board[2][0] == playerIndicator;
    }

    private static void computerMove(char[][] board) {
        Random rnd = new Random();
        int computerMove;
        do {
            computerMove = rnd.nextInt(9) + 1;
        } while (!isValidMove(board, Integer.toString(computerMove)));

        System.out.println("Computer chose: " + computerMove);
        placeMove(board, Integer.toString(computerMove), 'O');
        printBoard(board);
    }

    private static void playerMove(char[][] board, Scanner sc) {
        String userInput;
        while (true) {
            System.out.println("Where do you want to put your 'X'? (1-9)");
            userInput = sc.nextLine();
            if (isValidMove(board, userInput)) {
                break;
            } else {
                System.out.println(userInput + " is not a valid move!");
            }
        }
        placeMove(board, userInput, 'X');
        printBoard(board);
    }

    private static boolean isValidMove(char[][] board, String input) {
        return switch (input) {
            case "1" -> (board[0][0] == ' ');
            case "2" -> (board[0][1] == ' ');
            case "3" -> (board[0][2] == ' ');
            case "4" -> (board[1][0] == ' ');
            case "5" -> (board[1][1] == ' ');
            case "6" -> (board[1][2] == ' ');
            case "7" -> (board[2][0] == ' ');
            case "8" -> (board[2][1] == ' ');
            case "9" -> (board[2][2] == ' ');
            default -> false;
        };
    }

    private static void placeMove(char[][] board, String userInput, char playerIndicator) {
        switch (userInput) {
            case "1":
                board[0][0] = playerIndicator;
                break;
            case "2":
                board[0][1] = playerIndicator;
                break;
            case "3":
                board[0][2] = playerIndicator;
                break;
            case "4":
                board[1][0] = playerIndicator;
                break;
            case "5":
                board[1][1] = playerIndicator;
                break;
            case "6":
                board[1][2] = playerIndicator;
                break;
            case "7":
                board[2][0] = playerIndicator;
                break;
            case "8":
                board[2][1] = playerIndicator;
                break;
            case "9":
                board[2][2] = playerIndicator;
                break;
            default:
                System.out.println("Not a valid move! :(");
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println("\t" + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("\t-+-+-");
        System.out.println("\t" + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("\t-+-+-");
        System.out.println("\t" + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }
}
