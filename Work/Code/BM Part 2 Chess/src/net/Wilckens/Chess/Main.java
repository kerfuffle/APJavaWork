/**
 * Ryan Davis
 * Period 8
 * BM Part 2
 */


package net.Wilckens.Chess;

public class Main {    
    public static final int
        EMPTY = 0,
        WHITE_PAWN =  1, WHITE_KNIGHT = 2, WHITE_BISHOP = 3,
        WHITE_ROOK =  4, WHITE_QUEEN =  5, WHITE_KING =   6,
        BLACK_PAWN =  7, BLACK_KNIGHT = 8, BLACK_BISHOP = 9,
        BLACK_ROOK = 10, BLACK_QUEEN = 11, BLACK_KING =  12;
    /* an array of chars makes getting the appropriate character quick & easy: */
    public static final char[] pieceChars =
        {' ', 'p', 'n', 'b', 'r', 'q', 'k', 'P', 'N', 'B', 'R', 'Q', 'K'};
    /* this is used in printBoard: */
    public static final String rowMarker = "+---+---+---+---+---+---+---+---+";
    
    public static void printBoard(int[][] board) {
        for (int row = 0; row < 8; row++) {
            System.out.println(rowMarker);
            System.out.print("| ");
            for (int col = 0; col < 8; col++) {
                int piece = board[row][col];
                char pieceCharacter = pieceChars[piece];
                System.out.print(pieceCharacter + " | ");
            }
            System.out.println("");
        }
        System.out.println(rowMarker);
    }
    /* PLACEHOLDERS:  These methods need to get written as you work through
     * the problems.
     */
    public static int countPiece(int[][] board, int pieceCode) 
    {
    	int count = 0;
    	for (int i = 0; i < 8; i++)
    	{
    		for (int j = 0; j < 8; j++)
    		{
    			if (board[i][j] == pieceCode)
    			{
    				count++;
    			}
    		}
    	}
    	
        return count;
    }
    
    public static int getWhiteScore(int[][] board) 
    {
    	int score = 0;
    	for (int i = 0; i < 8; i++)
    	{
    		for (int j = 0; j < 8; j++)
    		{
    			if (board[i][j] == WHITE_PAWN)
    			{
    				score += 1;
    			}
    			if (board[i][j] == WHITE_BISHOP || board[i][j] == WHITE_KNIGHT)
    			{
    				score += 3;
    			}
    			if (board[i][j] == WHITE_ROOK)
    			{
    				score += 5;
    			}
    			if (board[i][j] == WHITE_QUEEN)
    			{
    				score += 9;
    			}
    		}
    	}
    	return score;
    }
    
    public static int getBlackScore(int[][] board)
    {
    	int score = 0;
    	for (int i = 0; i < 8; i++)
    	{
    		for (int j = 0; j < 8; j++)
    		{
    			if (board[i][j] == BLACK_PAWN)
    			{
    				score += 1;
    			}
    			if (board[i][j] == BLACK_BISHOP || board[i][j] == BLACK_KNIGHT)
    			{
    				score += 3;
    			}
    			if (board[i][j] == BLACK_ROOK)
    			{
    				score += 5;
    			}
    			if (board[i][j] == BLACK_QUEEN)
    			{
    				score += 9;
    			}
    		}
    	}
    	return score;
    }
    
    public static String whoWinning(int[][] board)
    {
    	if (getWhiteScore(board) > getBlackScore(board))
    	{
    		return "White is winning";
    	}
    	else if (getBlackScore(board) > getWhiteScore(board))
    	{
    		return "Black is winning.";
    	}
    	else
    	{
    		return "It's tied";
    	}
    }
    
    public static void printStats(int[][] board) 
    {
    	
    	System.out.println("*** GAME STATS ***");
    	System.out.println("\t\t\tWhite\tBlack");
    	System.out.println("Number of Pawns: \t" + countPiece(board, WHITE_PAWN) + "\t" + countPiece(board, BLACK_PAWN));
    	System.out.println("Number of Knights: \t" + countPiece(board, WHITE_KNIGHT) + "\t" + countPiece(board, BLACK_KNIGHT));
    	System.out.println("Number of Bishops: \t" + countPiece(board, WHITE_BISHOP) + "\t" + countPiece(board, BLACK_BISHOP));
    	System.out.println("Number of Rooks: \t" + countPiece(board, WHITE_ROOK) + "\t" + countPiece(board, BLACK_ROOK));
    	System.out.println("Number of Queens: \t" + countPiece(board, WHITE_QUEEN) + "\t" + countPiece(board, BLACK_QUEEN));
    	System.out.println("Number of Kings: \t" + countPiece(board, WHITE_KING) + "\t" + countPiece(board, BLACK_KING));
    	System.out.println("Player scores: \t\t" + getWhiteScore(board) + "\t" + getBlackScore(board));
    	System.out.println();
    	System.out.println(whoWinning(board));
    }    
    
    public static int[][] initBoard(int[][] board)
    {
    	int blackOrder[] = {BLACK_ROOK, BLACK_KNIGHT, BLACK_BISHOP, BLACK_QUEEN, BLACK_KING, BLACK_BISHOP, BLACK_KNIGHT, BLACK_ROOK};
    	int whiteOrder[] = {WHITE_ROOK, WHITE_KNIGHT, WHITE_BISHOP, WHITE_QUEEN, WHITE_KING, WHITE_BISHOP, WHITE_KNIGHT, WHITE_ROOK};
    	
    	for (int a = 0; a < 8; a++)
    	{
    		board[0][a] = blackOrder[a];
    		board[7][a] = whiteOrder[a];
    		board[1][a] = BLACK_PAWN;
    		board[6][a] = WHITE_PAWN;
    	}
    
    	for (int i = 2; i <= 5; i++)
    	{
    		for (int j = 0; j < 8; j++)
    		{
    			board[i][j] = EMPTY;
    		}
    	}
    	
    	return board;
    }
    
    public static void main(String[] args) {
        // This is where the action starts (e.g. declare and construct your board here)
        // ...what happens first???...


    	//int chessBoard[][] = new int[8][8];
    	//initBoard(chessBoard);
    	//printBoard(chessBoard);
    	
        // final problem (#5) test code:
       int[][] testBoard =
          {{0, 0, 0, BLACK_ROOK, 0, 0, BLACK_KING, 0},
           {BLACK_PAWN, 0, 0, 0, 0, BLACK_PAWN, BLACK_PAWN, 0},
           {0, 0, 0, 0, BLACK_PAWN, 0, 0, BLACK_PAWN},
           {0, 0, WHITE_ROOK, 0, 0, 0, 0, 0},
           {0, WHITE_PAWN, 0, BLACK_ROOK, 0, 0, 0, 0},
           {0, 0, 0, 0, 0, 0, WHITE_PAWN, WHITE_PAWN},
           {WHITE_PAWN, 0, 0, 0, WHITE_QUEEN, WHITE_PAWN, 0, 0},
           {0, BLACK_QUEEN, 0, 0, WHITE_BISHOP, 0, WHITE_KING, 0}};
        printBoard(testBoard);
        printStats(testBoard);
    }
}