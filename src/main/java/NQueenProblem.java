/**
 * We have to place N queens on a NXN chessboard.
 */
public class NQueenProblem {

    static int numberOfQueensInProblem;
    static char[][] chessBoard;
    private static final char QUEEN_SYMBOL = 'Q';
    private static final char BLANK_SYMBOL = '*';
    private static int count = 0;

    public static void main(String[] args) {
        NQueenProblem problem = new NQueenProblem(4);
        placeQueens(0, 0);

        if (count == 0) {
            System.out.println("Unfortunately no solutions exists!!");
        }
    }

    public NQueenProblem(int numberOfQueensInProblem) {
        this.numberOfQueensInProblem = numberOfQueensInProblem;
        this.chessBoard = new char[numberOfQueensInProblem][numberOfQueensInProblem];

        //Initialize the chess board with blank symbols.
        for (int i=0; i<numberOfQueensInProblem; i++) {
            for (int j=0; j<numberOfQueensInProblem; j++) {
                chessBoard[i][j] = BLANK_SYMBOL;
            }
        }

    }

    /**
     *
     * @param row Row num for which we need to set the next queens position.
     * @param queensPlaced
     */
    private static void placeQueens(int row, int queensPlaced) {

        if (numberOfQueensInProblem == 0) {
            System.out.println("Invalid input!!");
            return;
        }

        //Base condition if a solution is available.
        if (queensPlaced == numberOfQueensInProblem) {
            System.out.println("We have a solution number : " + ++count);
            for (int i=0; i<numberOfQueensInProblem; i++) {
                for (int j=0; j<numberOfQueensInProblem; j++) {
                    System.out.printf("%5c", chessBoard[i][j]);
                }
                System.out.println("");
            }
            return;
        }

        //Base condition if we reached the row after the last row in che chess board.
        if (row > chessBoard.length - 1) {
            return;
        }

        //Go through each column for the current row.
        for (int column=0; column<chessBoard.length; column++) {

            //Check if we can place queen here.
            if (isValidQueenPosition(row, column)) {
                chessBoard[row][column] = QUEEN_SYMBOL;

                //Increment the count of queens we placed so far.
                queensPlaced++;
                //If we placed queen for current row, move on the next row.
                int pickNextRow = row + 1;

                //Recurse the logic for next row.
                placeQueens(pickNextRow, queensPlaced);

                //We reached which means that last path was not leading to a solution
                // or it was a valid solution.
                //Which means we are now backtracking.
                chessBoard[row][column] = BLANK_SYMBOL;
                queensPlaced--;
            }
        }

        return;
    }

    //Check if the new queen's position is it at an attacking position.
    //We only need to the position for the above rows only since there will be no queens
    // in the below rows yet.
    private static boolean isValidQueenPosition(int row, int column) {

        //check above rows;
        for (int i=row; i>=0; i--) {
            if (chessBoard[i][column] == QUEEN_SYMBOL) {
                return false;
            }
        }

        //check above left diagonal.
        for (int i=row,j = column ; i>=0 && j>=0 ; i--,j--) {
            if (chessBoard[i][j] == QUEEN_SYMBOL) {
                return false;
            }
        }

        //check above right diagonal.
        for (int i=row,j = column ; i>=0 && j<chessBoard.length ; i--,j++) {
            if (chessBoard[i][j] == QUEEN_SYMBOL) {
                return false;
            }
        }

        return true;
    }

}
