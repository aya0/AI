package code;
public class State {
    private int Prosperity;
    private int FoodCount;
    private int EnergyCount;
    private int MaterialsCount;
    private int MoneySpent;
    private boolean Waiting;
    private int WaitingTime;
    private int WaitingFor;
    private String Plan;
    //0 if not waiting
    //1 for food
    //2 for energy
    //3 for materials



    


    public State(int prosperity, int foodCount, int energyCount, int materialsCount, int moneySpent, boolean waiting, int waitingTime, int waitingFor, String plan) {
        Prosperity = prosperity;
        FoodCount = foodCount;
        EnergyCount = energyCount;
        MaterialsCount = materialsCount;
        MoneySpent = moneySpent;
        Waiting = waiting;
        WaitingTime = waitingTime;
        WaitingFor = waitingFor;
        Plan = plan;

    }

    public String getPlan() {
        return Plan;
    }


    public void setPlan(String plan) {
        Plan = plan;
    }
    public int getWaitingFor() {
        return WaitingFor;
    }


    public void setWaitingFor(int waitingFor) {
        WaitingFor = waitingFor;
    }

    public int getWaitingTime() {
        return WaitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.WaitingTime = waitingTime;
    }

    public boolean isWaiting() {
        return Waiting;
    }

    public void setWaiting(boolean waiting) {
        Waiting = waiting;
    }
    public int getFoodCount() {
        return FoodCount;
    }

    public void setFoodCount(int foodCount) {
        FoodCount = foodCount;
    }

    public int getEnergyCount() {
        return EnergyCount;
    }

    public void setEnergyCount(int energyCount) {
        EnergyCount = energyCount;
    }

    
    public int getMaterialsCount() {
        return MaterialsCount;
    }

    public void setMaterialsCount(int materialsCount) {
        MaterialsCount = materialsCount;
    }

    




   
    public int getMoneySpent() {
        return MoneySpent;
    }

    public void setMoneySpent(int moneySpent) {
        MoneySpent = moneySpent;
    }

    


    public int getProsperity() {
        return Prosperity;
    }

    public void setProsperity(int prosperity) {
        Prosperity = prosperity;
    }

    public void print(){
        System.out.println(
        "Prosperity = " + this.getProsperity() + 
        " Food = " + this.getFoodCount()+
        " Energy = " + this.getEnergyCount()+
        " Materials =" + this.getMaterialsCount()+
        " Money Spent = " + this.getMoneySpent()
      );
    }

}

