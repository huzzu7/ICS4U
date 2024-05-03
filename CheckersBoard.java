/* CheckersBoard.java
 * Huzaifa Mohammed
 * Class that allows a user to play checkers with added utility
 */

public class CheckersBoard {
    
    // constants representing colors
    public static final int BLACK = 1;
    public static final int RED   = 2;

    //string representing path of the move
    private String path ="";

    //flag indicating if the move is valid
    private boolean validPath = false;

    //2D array represnting the checkerboard
    private int board[][] = {
        {2,0,2,0,2,0,2,0},
        {0,2,0,2,0,2,0,2},
        {2,0,2,0,2,0,2,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,1,0,1,0,1,0,1},
        {1,0,1,0,1,0,1,0},
        {0,1,0,1,0,1,0,1}
    };
        
    //method to get the value at a given position on the board
    public int get(int x, int y){
        return board[y][x];
    }

    //method to check if the move is valid
    private boolean isValidMove(int x, int y) {
        return x >= 0 && x <= 7 && y >= 0 && y <= 7;
    }

    //method to perform a move
    public boolean move(int x1, int y1, int x2, int y2){
        
        //define user piece and opponent piece
        int piece = board[y1][x1];
        int opponentPiece = piece == BLACK ? RED : BLACK;

        //specify direction of the piece
        int direction = piece == BLACK ? -1 : 1;

        //net displacement of the move
        int dx = x2-x1;
        int dy = y2-y1;
        
        //check if the specified piece and the destination is valid
        if (board[y1][x1] == 0 || board[y2][x2] != 0){
            return false;
        }

        //check if the piece is at the destination
        if (x1 == x2 && y1 == y2){
            return true;
        }

        //check if the move is valid (in the domain of the board)
        if (isValidMove(dx>0?x1+1:x1-1, y1+direction)){

            //move the piece one square
            if (Math.abs(dx)==1 && Math.abs(dy)==1 ){
                board[y1+direction][dx>0?x1+1:x1-1] = board[y1][x1];
                board[y1][x1] = 0;
                return true;
            }

            //otherwise begin sequence to recursively capture to get to destination

            //if valid, move right to capture
            if (board[y1+direction][x1+1] == opponentPiece){
                move(x1+2, y1+(2*direction), x2, y2, direction, "R");
            }

            //if valid, move left to capture
            if (board[y1+direction][x1-1] == opponentPiece){
                move(x1-2, y1+(2*direction), x2, y2, direction, "L");
            }

        }

        //execute if valid path found
        if (validPath) {

            //reset valid path flag
            validPath = false;

            //move the piece
            board[y2][x2] = board[y1][x1];
            board[y1][x1] = 0;

            //sequence to follow path and remove opponent pieces
            for (int i = 0; i < path.length(); i++) {
                if (path.charAt(i) == 'R') {
                    board[y1+direction][x1+1] = 0;
                    x1+=2;
                    y1+=2*direction;
                }
                else {
                    board[y1+direction][x1-1] = 0;
                    x1-=2;
                    y1+=2*direction;
                }
            }

            //reset path
            path = "";
            return true;
        }
        return false;

    }
    
    private void move(int x1, int y1, int x2, int y2, int direction, String pathMove) {

        //specify opponent piece
        int opponentPiece = direction == 1 ? BLACK : RED;

        //check validity of move
        if (!isValidMove(x1, y1)||board[y1][x1]!=0){
            return;
        }

        //check if found path is already valid
        if (!validPath){

            //if valid, save the path and flag it
            if(x1==x2 && y1 ==y2){
                path = pathMove;
                validPath = true;
                return;
            }

            //otherwise recursively move the piece left and right

            if (isValidMove(x1+1, y1+direction)&&board[y1+direction][x1+1]==opponentPiece){
                move(x1+2, y1+2*direction, x2, y2, direction, pathMove+"R");
            }
            if (isValidMove(x1-1, y2+direction)&&board[y1+direction][x1-1]==opponentPiece){
                move(x1-2, y1+2*direction, x2, y2, direction, pathMove+"L");
            }
        }
    }
    
    //method to count the number of specified pieces
    public int count (int color){
        int counter = 0;
            //iterate through the board
            for (int[] row : board)
                for(int num : row)
                    if (num == color){
                        //update counter if it matches specified color
                        counter++;
                    }
        return counter;
        
    }
    
    //display method to draw a crude ASCII version of the board
    public void display(){
        System.out.println("\n+-----+-----+-----+-----+-----+-----+-----+-----+");
        for (int[] row: board){
            for(int num : row){
                if (num == 0) System.out.print("|     ");
                else if (num == 1) System.out.print("|  B  ");
                else if (num == 2) System.out.print("|  R  ");
            }
            System.out.println("|\n+-----+-----+-----+-----+-----+-----+-----+-----+");
        }
    }
}


