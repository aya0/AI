package code;

public class Node {
    

private Node Parent;
private State currState;
private ActionType Action;
private int PathCost;
private int Depth;
// private Node[] Children;
private int Heuristic1;
private int Heuristic2;

public Node(Node parent, State currState, ActionType action, int pathCost, int depth, int heuristic1, int heuristic2) {
    Parent = parent;
    this.currState = currState;
    Action = action;
    PathCost = pathCost;
    Depth = depth;
    Heuristic1 = heuristic1;
    Heuristic2 = heuristic2;
}

public int getHeuristic1() {
    return Heuristic1;
}

public void setHeuristic1(int heuristic1) {
    Heuristic1 = heuristic1;
}

public int getHeuristic2() {
    return Heuristic2;
}

public void setHeuristic2(int heuristic2) {
    Heuristic2 = heuristic2;
}

public int getAS1(){
    return Heuristic1+PathCost;
}

public int getAS2(){
    return Heuristic2 +PathCost;
}





// public Node[] getChildren() {
//     return Children;
// }

// public void setChildren(Node[] children) {
//     Children = children;
// }

public int getDepth() {
    return Depth;
}

public void setDepth(int depth) {
    Depth = depth;
}

public int getPathCost() {
    return PathCost;
}

public void setPathCost(int pathCost) {
    PathCost = pathCost;
}

public ActionType getAction() {
    return Action;
}

public void setAction(ActionType action) {
    Action = action;
}

public State getCurrState() {
    return currState;
}

public void setCurrState(State currState) {
    this.currState = currState;
}

public Node getParent() {
    return Parent;
}

public void setParent(Node parent) {
    Parent = parent;
}

public int getPriority(){
    return PathCost;
}



}
