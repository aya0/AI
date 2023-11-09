package code;
public class Node {
    

private Node Parent;
private State currState;
private ActionType Action;
private int PathCost;
private int Depth;
// private Node[] Children;
private int Heuristic;


public int getHeuristic() {
    return Heuristic;
}


public void setHeuristic(int heuristic) {
    Heuristic = heuristic;
}


public Node(Node parent, State currState, ActionType action, int pathCost, int depth) {
        Parent = parent;
        this.currState = currState;
        Action = action;
        PathCost = pathCost;
        Depth = depth;
        // Children = new Node[6];
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
