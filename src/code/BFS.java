package code;
import java.util.*;

    //aa[0]=> energy
    //aa[1]=> food
    //aa[2]=> materials
    //aa[3]=> wair
    //aa[4]=> build1
    //aa[5]=> build2

public class BFS extends GenericSearch{

    public BFS()
    {
        super();
    }


    
    public String Search(String searchProblem,Collection<Node> collection) {
        String result ="";
        Queue<Node> queue = (Queue<Node>) collection;
        queue.add(this.GenerateInitial(searchProblem));
        Node Curr;
        int MoneySpent = 0;
        while(!queue.isEmpty())
        {
            Curr = queue.remove();
            this.nodesExpanded++;
            if(this.visualize)
            {
                System.out.println(this.nodesExpanded);
                // Curr.getCurrState().print();
            }
            if(Curr.getCurrState().getEnergyCount()==0||Curr.getCurrState().getFoodCount()==0||Curr.getCurrState().getMaterialsCount()==0||Curr.getCurrState().getMoneySpent()==100000)
            {
                continue;
            }
            else{
                    if(Curr.getCurrState().getProsperity()>=100)
                {
                    result = Curr.getCurrState().getPlan().substring(0, Curr.getCurrState().getPlan().length() - 1) +".";
                    MoneySpent = Curr.getCurrState().getMoneySpent();
                    break;
                }
                else{
                    if(!Curr.getCurrState().isWaiting())
                {
                    queue.add(this.action.RequestFoodAction(Curr));
                    queue.add(this.action.RequestMaterialAction(Curr));
                    queue.add(this.action.RequestEnergyAction(Curr));
                }
                queue.add(this.action.Wait(Curr));
                ActionAttributes[] ActionData= this.action.getActionsAttributes();
                //For build1 we have to check that we have enough of all the available resources and enough money for the build
                State s = Curr.getCurrState();

                if(s.getFoodCount()>ActionData[4].ResourceConsumption[0] && s.getMaterialsCount()>ActionData[4].ResourceConsumption[1] && s.getEnergyCount()>ActionData[4].ResourceConsumption[2]&&(s.getMoneySpent()+ActionData[4].Price<100000))
                {
                    queue.add(this.action.BuildOne(Curr)); 
                }
                if(s.getFoodCount()>ActionData[5].ResourceConsumption[0] && s.getMaterialsCount()>ActionData[5].ResourceConsumption[1] && s.getEnergyCount()>ActionData[5].ResourceConsumption[2]&&(s.getMoneySpent()+ActionData[5].Price<100000))
                {
                    queue.add(this.action.BuildTwo(Curr)); 
                }
                }
            }
            
            
            
        }
        if (result =="")
        {
             return "NOSOLUTION";
        }
        else{
            return result+";"+ MoneySpent +";" +this.nodesExpanded;
        }
    }

    
    
}