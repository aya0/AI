public class Action {
    //aa[0]=> energy
    //aa[1]=> food
    //aa[2]=> materials
    //aa[3]=> wair
    //aa[4]=> build1
    //aa[5]=> build2

    public class ActionAttributes{
        int Amount;
        int[] ResourceConsumption;
        int Delay;
        int IncreaseInProsperity;
        int Price;
    }
    private ActionAttributes[] ActionsAttributes;


    public Node DoAction(ActionType Type, Node node){
        Node n=node;
        switch(Type){
        case REQFOOD: n = RequestEnergyAction(node); break;
        case REQENERGY:n = RequestFoodAction(node); break;
        case REQMATERIALS: n = RequestMaterialAction(node);break;
        case WAIT:break;
        case BUILD1:break;
        case BUILD2:break;
            default:
                break;
        }
        return n;
    }

    public Node RequestEnergyAction(Node n)
    {
        State state = n.getCurrState();
        int food = state.getFoodCount()-1;
        int energy = state.getEnergyCount()-1;
        int materials = state.getMaterialsCount()-1;
        int depth = n.getDepth()+1;
        int pathCost = n.getPathCost()+ ActionsAttributes[0].Price;
        int moneySpent = state.getMoneySpent() + ActionsAttributes[0].Price;
        boolean wait = ActionsAttributes[0].Delay==0?true:false;
        int prosperity = state.getProsperity();
        State newState = new State(prosperity, food, energy, materials, moneySpent,wait);
    return new Node(n, newState, ActionType.REQENERGY , pathCost, depth);
    }

     public Node RequestFoodAction(Node n)
    {
        State state = n.getCurrState();
        int food = state.getFoodCount()-1;
        int energy = state.getEnergyCount()-1;
        int materials = state.getMaterialsCount()-1;
        int depth = n.getDepth()+1;
        int pathCost = n.getPathCost()+ ActionsAttributes[1].Price;
        int moneySpent = state.getMoneySpent() + ActionsAttributes[1].Price;
        boolean wait = ActionsAttributes[0].Delay==0?true:false;
         int prosperity = state.getProsperity();
        State newState = new State(prosperity, food, energy, materials, moneySpent,wait);
    return new Node(n, newState, ActionType.REQFOOD , pathCost, depth);
    }

    public Node RequestMaterialAction(Node n)
    {
        State state = n.getCurrState();
        int food = state.getFoodCount()-1;
        int energy = state.getEnergyCount()-1;
        int materials = state.getMaterialsCount()-1;
        int depth = n.getDepth()+1;
        int pathCost = n.getPathCost()+ ActionsAttributes[2].Price;
        int moneySpent = state.getMoneySpent() + ActionsAttributes[2].Price;
        boolean wait = ActionsAttributes[0].Delay==0?true:false;
         int prosperity = state.getProsperity();
        State newState = new State(prosperity, food, energy, materials, moneySpent,wait);
    return new Node(n, newState, ActionType.REQMATERIALS , pathCost, depth);
    }

    public Node Wait(Node n)
    {
        State state = n.getCurrState();
        int food = state.getFoodCount()-1;
        int energy = state.getEnergyCount()-1;
        int materials = state.getMaterialsCount()-1;
        int depth = n.getDepth()+1;
        int pathCost = n.getPathCost()+ ActionsAttributes[3].Price;
        int moneySpent = state.getMoneySpent() + ActionsAttributes[3].Price;
        int prosperity = state.getProsperity();
        State newState = new State(prosperity, food, energy, materials, moneySpent, state.isWaiting());
    return new Node(n, newState, ActionType.WAIT , pathCost, depth);
    }

    public Node BuildOne(Node n)
    {
        State state = n.getCurrState();
        int food = state.getFoodCount()-ActionsAttributes[4].ResourceConsumption[0];
        int energy = state.getEnergyCount()-ActionsAttributes[4].ResourceConsumption[1];
        int materials = state.getMaterialsCount()-ActionsAttributes[4].ResourceConsumption[2];
        int depth = n.getDepth()+1;
        int pathCost = n.getPathCost()+ ActionsAttributes[4].Price;
        int moneySpent = state.getMoneySpent() + ActionsAttributes[4].Price;
        int prosperity = state.getProsperity()+ActionsAttributes[5].IncreaseInProsperity;
        State newState = new State(prosperity, food, energy, materials, moneySpent,state.isWaiting());
    return new Node(n, newState, ActionType.BUILD1 , pathCost, depth);
    }

    public Node BuildTwo(Node n)
    {
        State state = n.getCurrState();
        int food = state.getFoodCount()-ActionsAttributes[5].ResourceConsumption[0];
        int energy = state.getEnergyCount()-ActionsAttributes[5].ResourceConsumption[1];
        int materials = state.getMaterialsCount()-ActionsAttributes[5].ResourceConsumption[2];
        int depth = n.getDepth()+1;
        int pathCost = n.getPathCost()+ ActionsAttributes[5].Price;
        int moneySpent = state.getMoneySpent() + ActionsAttributes[5].Price;
         int prosperity = state.getProsperity()+ActionsAttributes[5].IncreaseInProsperity;
        State newState = new State(prosperity, food, energy, materials, moneySpent,state.isWaiting());
    return new Node(n, newState, ActionType.BUILD2 , pathCost, depth);
    }

}
