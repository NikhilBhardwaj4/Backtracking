package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    //counting no ways------------->>
    public static void main(String[] args) {
        System.out.println(countWays(3,3));
        path("",3,3);
        System.out.println(pathret("",3,3));
        System.out.println(pathDiagonal("",3,3));
    }
    static int countWays(int c, int r){
        if(c==1 || r==1){
            return 1;
        }
        int down = countWays(c,r-1);
        int right = countWays(c-1,r);
        return down+right;
    }
    // Finding paths-------------------------------------->>
    static void path(String p , int r, int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
        if(r>1){
            path(p+'D',r-1,c);
        }
        if(c>1){
            path(p+'R',r,c-1);
        }
    }

    //with arrayList--------------------------------------->>
    static List<String> pathret(String str , int r,int c){
        if(r==1 && c==1){
            List<String> list = new ArrayList<>();
            list.add(str);
            return list;
        }
        List<String> li = new ArrayList<>();
        if(r>1){
            li.addAll(pathret(str+'D',r-1,c));
        }
        if(c>1){
            li.addAll(pathret(str+'R',r,c-1));
        }
        return li;
    }


    // Going diagonally also--------------------------------->>

    static List<String> pathDiagonal(String str , int r,int c){
        if(r==1 && c==1){
            List<String> list = new ArrayList<>();
            list.add(str);
            return list;
        }
        List<String> li = new ArrayList<>();
        if(r>1){
            li.addAll(pathDiagonal(str+'V',r-1,c));
        }
        if(r>1 && c>1){
            li.addAll(pathDiagonal(str+'D',r-1,c-1));
        }
        if(c>1){
            li.addAll(pathDiagonal(str+'H',r,c-1));
        }
        return li;
    }
}
