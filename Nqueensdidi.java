package Backtracking;

public class Nqueensdidi {
    public static void main(String[] args) {
        int n=5;
        char board[][]=new char[n][n];
        //initialize the board------->
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]='X';
            }
        }
        System.out.println(Nqueens(board,0));
    }
    static int Nqueens(char[][] board,int row){
        if(row== board.length){
            System.out.println("--------chess board---------");
            printBoard(board);
            return 1;
        }
        int count =0;
        for (int j = 0; j < board.length; j++) {
            if(isSafe(board,row,j)) {
                board[row][j] = 'Q';
                count+=Nqueens(board, row + 1);
                board[row][j] = 'X';
            }
        }
        return count;
    }
    static void printBoard(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    static boolean isSafe(char[][] board,int row, int col){
        //vertically---------------->
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //diagonally right------------->
        for(int i=row-1, j=col+1;i>=0&&j< board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //diagonally left ---------------->
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
}
