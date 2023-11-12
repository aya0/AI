package code;
import java.util.*;
public class Action {
    //aa[0]=> energy
    //aa[1]=> food
    //aa[2]=> materials
    //aa[3]=> wait
    //aa[4]=> build1
    //aa[5]=> build2

    
    private ActionAttributes[] ActionsAttributes;
    int maxBProsperity;
    int minBPrice;
    int minRatio;
    int MinActionPrice;
    HashSet<String> hashset;


    public Action(ActionAttributes[] actionsAttributes) {
        ActionsAttributes = actionsAttributes;
        hashset = new HashSet<>();
    }

    public ActionAttributes[] getActionsAttributes() {
        return ActionsAttributes;
    }

    public void setActionsAttributes(ActionAttributes[] actionsAttributes) {
        ActionsAttributes = actionsAttributes;
    }

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
        boolean wait = ActionsAttributes[0].Delay==0?false:true;
        if(!wait){
            energy += ActionsAttributes[0].Amount;

        if(energy>50) energy = 50;
        }
        int prosperity = state.getProsperity();
        int waitingFor = wait?2:0;
        String plan = state.getPlan()+"RequestEnergy,";
        State newState = new State(prosperity, food, energy, materials, moneySpent,wait,ActionsAttributes[0].Delay,waitingFor, plan);
        int heuristic1 = ((100-prosperity)/(maxBProsperity)*minBPrice);
        int heuristic2 = ((100-prosperity)*minRatio);
    return new Node(n, newState, ActionType.REQENERGY , pathCost, depth, heuristic1,heuristic2);
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
        boolean wait = ActionsAttributes[1].Delay==0?false:true;

        if(!wait){
            food += ActionsAttributes[1].Amount;

        if(food>50) {food = 50;}
        }
        
        int prosperity = state.getProsperity();
        int waitingFor = wait?1:0;
        String plan = state.getPlan()+"RequestFood,";
        State newState = new State(prosperity, food, energy, materials, moneySpent,wait,ActionsAttributes[1].Delay,waitingFor, plan);
        //System.out.println("AAAAAAAAAAA" +ActionsAttributes[1].Delay);
        int heuristic1 = ((100-prosperity)/(maxBProsperity)*minBPrice);
        int heuristic2 = ((100-prosperity)*minRatio);
    return new Node(n, newState, ActionType.REQFOOD , pathCost, depth,heuristic1,heuristic2);
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
        boolean wait = ActionsAttributes[2].Delay==0?false:true;
        
        if(!wait){
            materials += ActionsAttributes[2].Amount;

        if(materials>50) materials = 50;
        }
        int prosperity = state.getProsperity();
        int waitingFor = wait?3:0;
        String plan = state.getPlan()+"RequestMaterials,";

        State newState = new State(prosperity, food, energy, materials, moneySpent,wait,ActionsAttributes[2].Delay,waitingFor, plan);

        int heuristic1 = ((100-prosperity)/(maxBProsperity)*minBPrice);
        int heuristic2 = ((100-prosperity)*minRatio);
    return new Node(n, newState, ActionType.REQMATERIALS , pathCost, depth,heuristic1,heuristic2);
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
        int waitingtime = state.getWaitingTime();
        //System.out.println("OOOOOOOOO"+ waitingtime);

        boolean waiting = state.isWaiting();
        int waitingFor=0;
        if(waiting){
            waitingtime--;
            if(waitingtime==0)
            {
                waiting=false;
                switch(state.getWaitingFor())
                {
                    case 1: food+= ActionsAttributes[1].Amount; 
                    if(food>50) food=50;
                    break;
                    case 2: energy+= ActionsAttributes[0].Amount; 
                    if(energy>50) energy =50;
                    break;
                    case 3: materials += ActionsAttributes[2].Amount;
                    if(materials>50) materials = 50;
                    break;
                    default:break;
                }
            }
            else
            {
                waitingFor = state.getWaitingFor();
            }
        }
        String plan = state.getPlan()+"WAIT,";

        State newState = new State(prosperity, food, energy, materials, moneySpent, waiting,waitingtime, waitingFor, plan);

        int heuristic1 = ((100-prosperity)/(maxBProsperity)*minBPrice);
        int heuristic2 = ((100-prosperity)*minRatio);
    return new Node(n, newState, ActionType.WAIT , pathCost, depth,heuristic1,heuristic2);
    }

    public Node BuildOne(Node n)
    {
        State state = n.getCurrState();
        int food = state.getFoodCount()-ActionsAttributes[4].ResourceConsumption[0];
        int energy = state.getEnergyCount()-ActionsAttributes[4].ResourceConsumption[2];
        int materials = state.getMaterialsCount()-ActionsAttributes[4].ResourceConsumption[1];
        int depth = n.getDepth()+1;
        int pathCost = n.getPathCost()+ ActionsAttributes[4].Price;
        int moneySpent = state.getMoneySpent() + ActionsAttributes[4].Price;
        int prosperity = state.getProsperity()+ActionsAttributes[4].IncreaseInProsperity;
        boolean waiting = state.isWaiting();
        int waitingtime = state.getWaitingTime();
        int waitingFor=0;
        if(waiting){
            waitingtime--;
            if(waitingtime==0)
            {
                //System.out.println("Yes da5alt hena");
                waiting=false;
                switch(state.getWaitingFor())
                {
                    case 1: food+= ActionsAttributes[1].Amount; 
                    if(food>50) food=50;
                    break;
                    case 2: energy+= ActionsAttributes[0].Amount; 
                    if(energy>50) energy =50;
                    break;
                    case 3: materials += ActionsAttributes[2].Amount;
                    if(materials>50) materials = 50;
                    break;
                    default:break;
                }
            }
            else
            {
                waitingFor = state.getWaitingFor();
            }
        }
        String plan = state.getPlan()+"BUILD1,";

        State newState = new State(prosperity, food, energy, materials, moneySpent,waiting,waitingtime, waitingFor, plan);

        int heuristic1 = ((100-prosperity)/(maxBProsperity)*minBPrice);
        int heuristic2 = ((100-prosperity)*minRatio);
    return new Node(n, newState, ActionType.BUILD1 , pathCost, depth,heuristic1,heuristic2);
    }

    public Node BuildTwo(Node n)
    {
        State state = n.getCurrState();
        int food = state.getFoodCount()-ActionsAttributes[5].ResourceConsumption[0];
        int energy = state.getEnergyCount()-ActionsAttributes[5].ResourceConsumption[2];
        int materials = state.getMaterialsCount()-ActionsAttributes[5].ResourceConsumption[1];
        int depth = n.getDepth()+1;
        int pathCost = n.getPathCost()+ ActionsAttributes[5].Price;
        int moneySpent = state.getMoneySpent() + ActionsAttributes[5].Price;
        int prosperity = state.getProsperity()+ActionsAttributes[5].IncreaseInProsperity;
        boolean waiting = state.isWaiting();
        int waitingtime = state.getWaitingTime();
        int waitingFor=0;
        if(waiting){
            waitingtime--;
            if(waitingtime==0)
            {
                waiting=false;
                switch(state.getWaitingFor())
                {
                    case 1: food+= ActionsAttributes[1].Amount; 
                    if(food>50) food=50;
                    break;
                    case 2: energy+= ActionsAttributes[0].Amount; 
                    if(energy>50) energy =50;
                    break;
                    case 3: materials += ActionsAttributes[2].Amount;
                    if(materials>50) materials = 50;
                    break;
                    default:break;
                }
            }
            else
            {
                waitingFor = state.getWaitingFor();
            }
        }
        String plan = state.getPlan()+"BUILD2,";
        State newState = new State(prosperity, food, energy, materials, moneySpent,waiting,waitingtime,waitingFor, plan);

        int heuristic1 = ((100-prosperity)/(maxBProsperity)*minBPrice);
        int heuristic2 = ((100-prosperity)*minRatio);
    return new Node(n, newState, ActionType.BUILD2 , pathCost, depth,heuristic1,heuristic2);
    }

}
