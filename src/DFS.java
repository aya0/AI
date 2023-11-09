import java.util.*;

public class DFS extends GenericSearch {
    
    public DFS()
    {
        super();
    }


    
    public String Search(String searchProblem, Collection<Node> collection) {
        Stack<Node> stack = (Stack<Node>)collection;
       // queue.add(this.GenerateInitial(searchProblem));
       stack.push(this.GenerateInitial(searchProblem));
        Node Curr;
        while(!stack.isEmpty())
        {
            Curr = stack.pop();
            this.nodesExpanded++;
            if(Curr.getCurrState().getEnergyCount()==0||Curr.getCurrState().getFoodCount()==0||Curr.getCurrState().getMaterialsCount()==0||Curr.getCurrState().getMoneySpent()==100000)
            {
                continue;
            }
            else
            {
    
            if(Curr.getCurrState().getProsperity()>=100)
            {
                return "Solution Found";
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

        return "’NOSOLUTION’";
    }



    
    
}
