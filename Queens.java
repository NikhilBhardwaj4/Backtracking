package Backtracking;

public class Queens {
    public static void main(String[] args) {
        int n =5;
        boolean [][] board= new boolean[n][n];
        System.out.println(queens(board,0));

    }
    static boolean isSafe(boolean[][] board,int r,int c){
        //for vertical-------------->>
        for (int i = 0; i < board.length; i++) {
            if(board[i][c]){
                return false;
            }
        }
        //for left ------------->>
        int left = Math.min(r,c);
        for (int i = 0; i <= left; i++) {
            if(board[r-i][c-i]){
                return false;
            }
        }
        //for rigth -------------->>
        int right = Math.min(r, board.length-c-1);
        for (int i = 0; i <= right; i++) {
            if(board[r-i][c+i]){
                return false;
            }
        }
        return true;
    }
    private static void display(boolean[][] board){
        for(boolean[] arr:board){
            for(boolean element : arr){
                if(element){
                    System.out.print("Q ");
                }else System.out.print("X ");
            }
            System.out.println();
        }
    }
    static int queens(boolean[][] board, int n){
        int count =0 ;
        if(n== board.length){
            display(board);
            System.out.println();
            return 1;
        }
        for (int col = 0; col < board.length; col++) {
            if(isSafe(board,n,col)){
                board[n][col]=true;
                count+=queens(board,n+1);
                board[n][col]=false;
            }
        }
        return count;
    }
}
