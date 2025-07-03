import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int playerWinns = 0;
        int computerWinns = 0;
        System.out.println("tic tac toe game  ");


        char [][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        while (true){
            printBoard(board);
            playerMove(board, 'x');
            if(checkWinner(board, 'x')){
                printBoard(board);
                System.out.println("The player X wins !");
                break;
            }
            computerMove(board,'O');
             if(checkWinner(board, 'o')){
                printBoard(board);
                System.out.println("The player 0 wins !");
                break;
            }

        }
    } // out of the main
    public static void printBoard(char [][] arr){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }
    public static void playerMove(char[][] board , char player){
        Scanner scanner = new Scanner(System.in);
        int row ;
        int col;
        while (true){
            System.out.println("Enter row (0, 1, 2): ");
            row = scanner.nextInt();
            System.out.println("Enter column (0, 1, 2): ");
            col = scanner.nextInt();
            if(row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ' ){
                board [row][col] = player;
                break;
            }
            else {
                System.out.println("the place was chosen !");
            }

        }
    }

    public static void computerMove(char[][] board , char computer){
        Random random = new Random();
        int row ;
        int col;
        while (true){
            row = random.nextInt(3);
            col = random.nextInt(3);

            if(board[row][col] == ' ' ){
                board [row][col] = computer;
                break;
            }
            else {
                System.out.println("the place was chosen !");
            }

        }
    }

    public static boolean checkWinner(char[][] board , char check){
        for (int i = 0; i < 3; i++){
            if (board[i][0] == check && board[i][1] == check && board[i][2]== check){
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == check && board[1][i] == check && board[2][i] == check) {
                return true;
            }
        }
        if (board[0][0] == check && board[1][1] == check && board[2][2] == check) {
            return true;
        }

        if (board[0][2] == check && board[1][1] == check && board[2][0] == check) {
            return true;
        }

        return false;
    }

}