package Backtracking;

public class AlldirectionMaze {
    public static void main(String[] args) {
        Boolean[][] maze ={
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        alldirection(maze,"",0,0);
    }

    private static void alldirection(Boolean[][] maze, String p, int r, int c) {
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c]=false;

        if(r<maze.length-1){
            alldirection(maze,p+'D',r+1,c);
        }
        if(c<maze[0].length-1){
            alldirection(maze,p+'R',r,c+1);
        }
        if(r>0){
            alldirection(maze,p+'U',r-1,c);
        }
        if(c>0){
            alldirection(maze,p+'L',r,c-1);
        }
        maze[r][c]=true;
    }
}
