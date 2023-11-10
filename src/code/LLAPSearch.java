package code;
import java.util.*;
public class LLAPSearch{
    static BFS bfs;
    DFS dfs;
    
    

    public static String solve(String initialState, String strategy, boolean visualize)
    {
       String result="";
        switch(strategy){
            case "BF":  BFS bfs = new BFS();result = bfs.Search(initialState,new ArrayDeque<Node>()); break;
            case "DF":  DFS dfs = new DFS(); result = dfs.Search(initialState, new Stack<Node>());break;
            case "ID":
            case "UC":
            case "GR1":
            case "GR2":
            case "AS1":
            case "AS2":
        }
        return result;
    }
    public static void main(String[]args){
        
    }

}
