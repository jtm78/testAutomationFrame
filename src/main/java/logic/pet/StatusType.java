package logic.pet;

public enum StatusType {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold");

    private String type;

    StatusType(String type){
        this.type = type;
    }

    public String getStatusName(){
        return type;
    }
}
