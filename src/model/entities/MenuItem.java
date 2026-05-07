package model.entities;

import model.enums.MenuCategory;

public class MenuItem {

    private String name;
    private Double price;
    private MenuCategory category;

    public MenuItem(){}

    public MenuItem(String name, Double price, MenuCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public MenuCategory getCategory() {
        return category;
    }

    public void setCategory(MenuCategory category) {
        this.category = category;
    }

    public boolean isBeverage(){
        return category == MenuCategory.BEVERAGE;
    }
}
