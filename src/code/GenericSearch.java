package code;
import java.util.*;

public abstract class GenericSearch {
    Action action;
    int nodesExpanded;
    public abstract  String Search(String searchProblem, Collection<Node> collection);  

    public GenericSearch(){
        nodesExpanded=0;
    }
//0
//     initialP rosperity;

//1
// initialF ood, initialM aterials, initialEnergy;

//2
// unitP riceF ood, unitP riceM aterials, unitP riceEnergy;

//3
// amountRequestF ood, delayRequestF ood;

//4
// amountRequestM aterials, delayRequestM aterials;

//5
// amountRequestEnergy, delayRequestEnergy;

//6
// priceBUILD1, foodUseBUILD1,
// materialsUseBUILD1, energyUseBUILD1, prosperityBUILD1;

//7
// priceBUILD2, foodUseBUILD2,
// materialsUseBUILD2, energyUseBUILD2, prosperityBUILD1;

//aa[0]=> energy
    //aa[1]=> food
    //aa[2]=> materials
    //aa[3]=> wait
    //aa[4]=> build1
    //aa[5]=> build2

    public Node GenerateInitial(String searchProblem){
        String[] split = searchProblem.split(";");
        String[] initial = split[1].split(",");
        String[] price = split[2].split(",");
        String[] FoodData = split[3].split(",");
        String[] MaterialsData = split[4].split(",");
        String[] EnergyData = split[5].split(",");
        String[] BuildOneData = split[6].split(",");
        String[]BuildTwoData = split[7].split(",");

        System.out.println(split);
        System.out.println(initial);
        System.out.println(price);
        System.out.println(FoodData);
        System.out.println(MaterialsData);
        System.out.println(EnergyData);
        System.out.println(BuildOneData);
        System.out.println(BuildTwoData);
        int[] empty = {};
        ActionAttributes[] ActionData = new ActionAttributes[6];
        ActionAttributes Food = new ActionAttributes(Integer.parseInt(FoodData[0]), empty, Integer.parseInt(FoodData[1]), 0, Integer.parseInt(price[0]));
        ActionAttributes Materials = new ActionAttributes(Integer.parseInt(MaterialsData[0]), empty, Integer.parseInt(MaterialsData[1]), 0, Integer.parseInt(price[1]));
        ActionAttributes Energy = new ActionAttributes(Integer.parseInt(EnergyData[0]), empty, Integer.parseInt(EnergyData[1]), 0, Integer.parseInt(price[2]));
        ActionAttributes Wait = new ActionAttributes(0, empty, 0, 0, 0);
        int PriceForOneOfEach = Food.Price+ Materials.Price + Energy.Price;
    
        int[] build1Resource = new int[3];
        build1Resource[0]= Integer.parseInt(BuildOneData[1]);
        build1Resource[1]= Integer.parseInt(BuildOneData[2]);
        build1Resource[2]= Integer.parseInt(BuildOneData[3]);
        int priceBuild1 = build1Resource[0]* Food.Price + build1Resource[1]* Materials.Price + build1Resource[2]*Energy.Price +Integer.parseInt(BuildOneData[0]);
        ActionAttributes BuildOne = new ActionAttributes(0, build1Resource, 0, Integer.parseInt(BuildOneData[4]), priceBuild1);
        int[] build2Resource = new int[3];
        build2Resource[0]= Integer.parseInt(BuildTwoData[1]);
        build2Resource[1]= Integer.parseInt(BuildTwoData[2]);
        build2Resource[2]= Integer.parseInt(BuildTwoData[3]);
        int priceBuild2 = build2Resource[0]* Food.Price + build2Resource[1]* Materials.Price + build2Resource[2]*Energy.Price +Integer.parseInt(BuildTwoData[0]);
        ActionAttributes BuildTwo = new ActionAttributes(0, build2Resource, 0, Integer.parseInt(BuildTwoData[4]), priceBuild2);

        Food.Price=PriceForOneOfEach;
        Materials.Price = PriceForOneOfEach;
        Energy.Price = PriceForOneOfEach;
        Wait.Price = PriceForOneOfEach;
        ActionData[0]= Energy;
        ActionData[1]= Food;
        ActionData[2]= Materials;
        ActionData[3]= Wait;
        ActionData[4]= BuildOne;
        ActionData[5]= BuildTwo;

        Action action = new Action(ActionData);
        this.action = action;
        State s0 = new State(Integer.parseInt(split[0]), Integer.parseInt(initial[0]), Integer.parseInt(initial[1]),Integer.parseInt(initial[2]), 0, false,0,0, "");

        Node Root = new Node(null, s0, null, 0, 0);
        return Root;
    }
    
}




