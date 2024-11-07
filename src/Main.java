import java.util.Scanner;

public class Main {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String[][] board = new String[ROWS][COLS];
    private static String currentPlayer = "X";

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain)
        {
            clearBoard();
            showBoard();

            while (true)
            {
                int row = safeinput.getRangedInt(in, "Enter the row (1-3) ", 1, 3) - 1;
                int col = safeinput.getRangedInt(in, "Enter the column (1-3) ", 1, 3) - 1;

                if (isValidMove(row, col))
                {
                    board[row][col] = currentPlayer;
                    if (isWin(currentPlayer))
                    {
                        showBoard();
                        System.out.println("Player " + currentPlayer + " wins!");
                        break;
                    }
                    else if (isTie())
                    {
                        showBoard();
                        System.out.println("It's a tie!");
                        break;
                    }

                    currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
                    showBoard();
                }
                else
                {
                    System.out.println("Invalid move! Try again.");
                }
            }


            playAgain = safeinput.getYNConfirm(in, "Play again? (Y/N): ");
            currentPlayer = "X";
        }

    }


    private static void clearBoard()
    {
        for (int r = 0; r < ROWS; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
                board[r][c] = " ";
            }
        }
    }

    private static void showBoard()
    {
        System.out.println("    1    2    3");
        for (int r = 0; r < ROWS; r++)
        {
            System.out.print((r + 1) + " ");
            for (int c = 0; c < COLS; c++)
            {
                System.out.print("| " + board[r][c] + " |");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(int row, int col)
    {
        return board[row][col].equals(" ");
    }


    private static boolean isWin(String player)
    {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }


    private static boolean isColWin(String player)
    {
        for (int c = 0; c < COLS; c++)
        {
            if (board[0][c].equals(player) && board[1][c].equals(player)
                    && board[2][c].equals(player))
            {
                return true;
            }
        }
        return false;
    }
    private static boolean isRowWin(String player)
    {
        for (int r = 0; r < ROWS; r++)
        {
            if (board[r][0].equals(player) && board[r][1].equals(player)
                    && board[r][2].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player)
    {
        return (board[0][0].equals(player) && board[1][1].equals(player)
                && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player)
                        && board[2][0].equals(player));
    }


    private static boolean isTie()
    {
        for (int r = 0; r < ROWS; r++)
        {
            for (int j = 0; j < COLS; j++)
            {
                if (board[r][j].equals(" "))
                {
                    return false;
                }
            }
        }
        return true;
    }
}
