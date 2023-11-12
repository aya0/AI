package code;
import java.util.*;

public class AS extends GenericSearch{
    int Heuristic;

    public AS(int heuristic){
        Heuristic = heuristic;
    }

    @Override
    public String Search(String searchProblem, Collection<Node> collection) {
        PriorityQueue<Node> queue = (PriorityQueue<Node>) collection;
        if(Heuristic==1){
            queue = new PriorityQueue<>(Comparator.comparingInt(Node::getAS1).thenComparingLong(Node::getInsertionTime));
        }
        else{
            queue = new PriorityQueue<>(Comparator.comparingInt(Node::getAS2).thenComparingLong(Node::getInsertionTime));
        }
        queue.add(this.GenerateInitial(searchProblem));
        Node Curr, Next;
        int MoneySpent = 0;
        String result = "";
        while(!queue.isEmpty())
        {
            Curr = queue.remove();
            this.nodesExpanded++;
            if(this.visualize)
            {
                System.out.println(this.nodesExpanded);
                Curr.getCurrState().print();
            }
            if(Curr.getCurrState().getEnergyCount()==0||Curr.getCurrState().getFoodCount()==0||Curr.getCurrState().getMaterialsCount()==0||Curr.getCurrState().getMoneySpent()==100000)
            {
                continue;
            }
            else{
                    if(Curr.getCurrState().getProsperity()>=100)
                {
                    result = Curr.getCurrState().getPlan().substring(0, Curr.getCurrState().getPlan().length() - 1);
                    MoneySpent = Curr.getCurrState().getMoneySpent();
                    break;
                }
                else{
                    if(!Curr.getCurrState().isWaiting())
                {
                    Next = this.action.RequestFoodAction(Curr);
                    if(!this.action.hashset.contains(Next.getCurrState().HashsetString()))
                    {
                        Next.insertionTime= System.nanoTime();
                        queue.add(Next);
                        this.action.hashset.add(Next.getCurrState().HashsetString());
                    }
                    
                    Next = this.action.RequestMaterialAction(Curr);
                    if(!this.action.hashset.contains(Next.getCurrState().HashsetString()))
                    {
                        Next.insertionTime= System.nanoTime();
                        queue.add(Next);
                        this.action.hashset.add(Next.getCurrState().HashsetString());
                    }
                    
                    Next = this.action.RequestEnergyAction(Curr);
                    if(!this.action.hashset.contains(Next.getCurrState().HashsetString()))
                    {
                        Next.insertionTime= System.nanoTime();
                        queue.add(Next);
                        this.action.hashset.add(Next.getCurrState().HashsetString());
                    }
                }
                Next = this.action.Wait(Curr);
                if(!this.action.hashset.contains(Next.getCurrState().HashsetString()))
                    {
                        Next.insertionTime= System.nanoTime();
                        queue.add(Next);
                        this.action.hashset.add(Next.getCurrState().HashsetString());
                    }
                ActionAttributes[] ActionData= this.action.getActionsAttributes();
                //For build1 we have to check that we have enough of all the available resources and enough money for the build
                State s = Curr.getCurrState();

                if(s.getFoodCount()>ActionData[4].ResourceConsumption[0] && s.getMaterialsCount()>ActionData[4].ResourceConsumption[1] && s.getEnergyCount()>ActionData[4].ResourceConsumption[2]&&(s.getMoneySpent()+ActionData[4].Price<100000))
                {
                    Next = this.action.BuildOne(Curr);
                    if(!this.action.hashset.contains(Next.getCurrState().HashsetString()))
                    {
                        Next.insertionTime= System.nanoTime();
                        queue.add(Next);
                        this.action.hashset.add(Next.getCurrState().HashsetString());
                    } 
                }
                if(s.getFoodCount()>ActionData[5].ResourceConsumption[0] && s.getMaterialsCount()>ActionData[5].ResourceConsumption[1] && s.getEnergyCount()>ActionData[5].ResourceConsumption[2]&&(s.getMoneySpent()+ActionData[5].Price<100000))
                {
                   Next = this.action.BuildTwo(Curr);
                   if(!this.action.hashset.contains(Next.getCurrState().HashsetString()))
                    {
                        Next.insertionTime= System.nanoTime();
                        queue.add(Next);
                        this.action.hashset.add(Next.getCurrState().HashsetString());
                    } 
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
    

