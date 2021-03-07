package com.company.entities;

public class Customer {
    public String customer_firstName,customer_secondName, customer_gender, customer_dateOfBirth, customer_ageGroup, gender ;
    public int customer_id, customer_fund;

    public Customer(String customer_firstName, String customer_secondName, String customer_gender,String customer_dateOfBirth,String customer_ageGroup,int customer_id, int customer_fund) {
        this.customer_firstName = customer_firstName;
        this.customer_secondName = customer_secondName;
        this.customer_gender = customer_gender;
        this.customer_dateOfBirth = customer_dateOfBirth;
        this.customer_ageGroup = customer_ageGroup;
    }
    public String getName() {
        return customer_firstName;
    }
    public String getSecond_Name() {
        return customer_secondName;
    }
    public String getGender() {
        return customer_gender;
    }
    public String getCustomer_dateOfBirth() {
        return customer_dateOfBirth;
    }
    public String getAge_Group() {
        return customer_ageGroup;
    }
    public int getCustomer_id() {
        return customer_id;
    }
    public int getCustomer_fund() {
        return customer_fund;
    }


    public void setName(String customer_firstName) {
        this.customer_firstName = customer_firstName;
    }
    public void setSecond_Name(String customer_secondName) {
        this.customer_secondName = customer_secondName;
    }
    public void setAge_Group(String customer_ageGroup) {
        this.customer_ageGroup = customer_ageGroup;
    }
    public void setGender(String customer_gender) {
        this.customer_gender = customer_gender;
    }
    public void setCustomer_dateOfBirth(String customer_dateOfBirth) {
        this.customer_dateOfBirth = customer_dateOfBirth;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
    public void setCustomer_fund(int customer_fund) {
        this.customer_fund = customer_fund;
    }

}
