package com.company.entities;

public class Item {
    public int item_id;
    public String item_name;
    public String item_category;
    public int item_price;

    public Item(){

    }

    public Item(int item_id, String item_name, String item_category, int item_price){
        this.item_id=item_id;
        this.item_name=item_name;
        this.item_category=item_category;
        this.item_price=item_price;
    }

    public int getItemId(){
        return this.item_id;
    }

    public void setItemId(int item_id){
        this.item_id=item_id;
    }

    public String getItemName(){
        return this.item_name;
    }

    public void setItemName(String item_name){
        this.item_name=item_name;
    }

    public String getItemCategory(){
        return this.item_category;
    }

    public void setItemCategory(String item_category){
        this.item_category=item_category;
    }

    public int getItemPrice(){
        return this.item_price;
    }

    public void setItemPrice(int item_id){
        this.item_price=item_price;
    }

}
