package sg.edu.nus.iss.vttp_day12_lecture.model;

public class Item {

    //Instance Variables
    private String itemName;
    private Integer quantity;

    //Getters Setters
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    //Constructors
    public Item(String itemName, Integer quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }
    public Item(){

    }

    //ToString
    @Override
    public String toString() {
        return "Item [itemName=" + itemName + ", quantity=" + quantity + "]";
    }
    
    
}
