public class Node {
    
private Node Parent;
private State currState;
private Action Action;
private int PathCost;
private int Depth;



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

public Action getAction() {
    return Action;
}

public void setAction(Action action) {
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



}
