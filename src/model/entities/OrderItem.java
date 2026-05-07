package model.entities;

public class OrderItem {

    private Integer quantity;
    private MenuItem item;

    public OrderItem(){}

    public OrderItem(Integer quantity, MenuItem item) {
        this.quantity = quantity;
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public MenuItem getItem() {
        return item;
    }

    public void setItem(MenuItem item) {
        this.item = item;
    }

    public double getSubtotal(){
        return getItem().getPrice() * quantity;
    }

}
