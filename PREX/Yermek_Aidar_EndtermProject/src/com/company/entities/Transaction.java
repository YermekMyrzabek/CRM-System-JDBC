package com.company.entities;

public class Transaction {
    public int transaction_id;
    public int customer_id;
    public int item_id;
    public boolean transaction_status;
    public String transaction_time;

    public Transaction(){

    }

    public Transaction(int transaction_id, int customer_id, int item_id, boolean transaction_status, String transaction_time){
        this.transaction_id=transaction_id;
        this.customer_id=customer_id;
        this.item_id=item_id;
        this.transaction_status=transaction_status;
        this.transaction_time=transaction_time;
    }

    public int getTransactionId(){
        return this.transaction_id;
    }

    public void setTransactionId(int transaction_id){
        this.transaction_id=transaction_id;
    }

    public int getCustomerId(){
        return this.customer_id;
    }

    public void setCustomerId(int customer_id){
        this.customer_id=customer_id;
    }

    public int getItemId(){
        return this.item_id;
    }

    public void setItemId(int item_id){
        this.item_id=item_id;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transaction_id=" + transaction_id +
                ", customer_id=" + customer_id +
                ", item_id=" + item_id +
                ", transaction_status =" + transaction_status +
                ", transaction_time=" + transaction_time +
                '}'+ "\n";
    }
}
