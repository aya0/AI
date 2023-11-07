public class State {
    private int Prosperity;
    private int FoodCount;
    private int EnergyCount;
    private int MaterialsCount;
    private int MoneySpent;
    private boolean Waiting;

    public boolean isWaiting() {
        return Waiting;
    }

    public void setWaiting(boolean waiting) {
        Waiting = waiting;
    }

    public State(int prosperity, int foodCount, int energyCount, int materialsCount, int moneySpent) {
        Prosperity = prosperity;
        FoodCount = foodCount;
        EnergyCount = energyCount;
        MaterialsCount = materialsCount;
        MoneySpent = moneySpent;
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

}
