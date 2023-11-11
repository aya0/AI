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
            case "GR1": GR gr1 = new GR(0); gr1.visualize = visualize; result = gr1.Search(initialState, new PriorityQueue<Node>()); break;
            case "GR2": GR gr2 = new GR(1); gr2.visualize = visualize; result = gr2.Search(initialState, new PriorityQueue<Node>()); break; 
            case "AS1": AS as1 = new AS(0); as1.visualize = visualize; result = as1.Search(initialState, new PriorityQueue<Node>()); break;
            case "AS2": AS as2 = new AS(1); as2.visualize = visualize; result = as2.Search(initialState, new PriorityQueue<Node>()); break;
            default:break;
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