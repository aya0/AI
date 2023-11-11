package code;
import java.util.*;

public class IDS extends GenericSearch {
    public IDS(){
        
    }

    @Override
    public String Search(String searchProblem, Collection<Node> collection) {
        Stack<Node> stack = (Stack<Node>)collection;
        Node Root=  this.GenerateInitial(searchProblem);
        int Depth = 0;
        String Result;
        do {
            stack.push(Root);
            Result = this.helper(stack, Depth);
            Depth ++;

        }
        while(Result.equals("continue") );
        return Result;

        
    }
    private String helper(Stack<Node> stack , int depth){
        Node Curr;
        boolean Continue = false;
        while(!stack.isEmpty())
        {
            Curr = stack.pop();
            this.nodesExpanded++;
            if(this.visualize)
            {
                System.out.println(this.nodesExpanded);
                // Curr.getCurrState().print();
            }
            if(Curr.getCurrState().getProsperity()>=100)
            {
                return Curr.getCurrState().getPlan().substring(0, Curr.getCurrState().getPlan().length() - 1) +"."+ Curr.getCurrState().getMoneySpent()+";"+ this.nodesExpanded;
            }
            else
            {
            if(depth==Curr.getDepth()){
                if(!(Curr.getCurrState().getEnergyCount()==0||Curr.getCurrState().getFoodCount()==0||Curr.getCurrState().getMaterialsCount()==0||Curr.getCurrState().getMoneySpent()==100000))
                {
                    Continue=true;
                }
            }
            else
            {
    
            if(Curr.getCurrState().getEnergyCount()==0||Curr.getCurrState().getFoodCount()==0||Curr.getCurrState().getMaterialsCount()==0||Curr.getCurrState().getMoneySpent()==100000)
            {
                continue;
            }
            else{
                if(!Curr.getCurrState().isWaiting())
            {
                stack.push(this.action.RequestFoodAction(Curr));
                stack.push(this.action.RequestMaterialAction(Curr));
                stack.push(this.action.RequestEnergyAction(Curr));
                
            }
            stack.push(this.action.Wait(Curr));
            ActionAttributes[] ActionData= this.action.getActionsAttributes();
            //For build1 we have to check that we have enough of all the available resources and enough money for the build
            State s = Curr.getCurrState();

            if(s.getFoodCount()>ActionData[4].ResourceConsumption[0] && s.getMaterialsCount()>ActionData[4].ResourceConsumption[1] && s.getEnergyCount()>ActionData[4].ResourceConsumption[2]&&(s.getMoneySpent()+ActionData[4].Price<100000))
            {
                stack.push(this.action.BuildOne(Curr)); 
            }
            if(s.getFoodCount()>ActionData[5].ResourceConsumption[0] && s.getMaterialsCount()>ActionData[5].ResourceConsumption[1] && s.getEnergyCount()>ActionData[5].ResourceConsumption[2]&&(s.getMoneySpent()+ActionData[5].Price<100000))
            {
                stack.push(this.action.BuildTwo(Curr)); 
            }
            }
        }
            
        } 
        }

        if(Continue){
            return "continue";
        }
        else{
            return "’NOSOLUTION’";        
        }

    }

    
}