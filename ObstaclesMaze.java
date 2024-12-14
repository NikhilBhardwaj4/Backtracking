package Backtracking;

public class ObstaclesMaze {
    public static void main(String[] args) {
        Boolean[][] maze ={
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        obstacles(maze,"",0,0);
    }
    static void obstacles(Boolean[][] maze , String p , int r ,int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }

        if(r<maze.length-1){
            obstacles(maze,p+'D',r+1,c);
        }
        if(c<maze[0].length-1){
            obstacles(maze,p+'R',r,c+1);
        }
    }
}
