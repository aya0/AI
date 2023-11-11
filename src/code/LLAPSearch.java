package code;
import java.util.*;
public class LLAPSearch{

    
    

    public static String solve(String initialState, String strategy, boolean visualize)
    {
       String result="";
        switch(strategy){
            case "BF":  BFS bfs = new BFS(); bfs.visualize = visualize;result = bfs.Search(initialState,new ArrayDeque<Node>()); break;
            case "DF":  DFS dfs = new DFS(); dfs.visualize = visualize; result = dfs.Search(initialState, new Stack<Node>());break;
            case "ID":  IDS ids = new IDS(); ids.visualize = visualize; result = ids.Search(initialState, new Stack<Node>());break;
            case "UC":  UC uc = new UC(); uc.visualize = visualize; result = uc.Search(initialState,  new PriorityQueue<Node>());break;
            case "GR1":
            case "GR2":
            case "AS1":
            case "AS2":
        }
        return result;
    }
    public static void main(String[]args){
        System.out.println(solve("17;" +
        "49,30,46;" +
        "7,57,6;" +
        "7,1;20,2;29,2;" +
        "350,10,9,8,28;" +
        "408,8,12,13,34;","BF", false));
    }

}
