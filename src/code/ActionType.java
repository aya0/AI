package code;
public enum ActionType {
    REQFOOD,
    REQENERGY,
    REQMATERIALS,
    WAIT,
    BUILD1,
    BUILD2;

    public String ActionTypeString(ActionType x){
        switch(x)
        {
            case REQFOOD: return "Request Food"; 
            case REQENERGY: return "Request Energy";
            case REQMATERIALS: return "Request Material";
            case WAIT: return "Wait";
            case BUILD1: return "Build one";
            case BUILD2: return "Build Two";
            default : return "";
        }

    }
}
