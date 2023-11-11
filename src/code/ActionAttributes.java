package code;
public class ActionAttributes{
    int Amount;
    int[] ResourceConsumption;
    int Delay;
    int IncreaseInProsperity;
    int Price;
    
    public ActionAttributes(int amount, int[] resourceConsumption, int delay, int increaseInProsperity, int price) {
        Amount = amount;
        ResourceConsumption = resourceConsumption;
        Delay = delay;
        IncreaseInProsperity = increaseInProsperity;
        Price = price;
    }
}