package com.fakturapp.model;

public class User extends BaseEntity {
    public String name;
    public String lastName;
    public String email;
    public String adress;
    public String company;


    public User() {
    }

    public User(String name, String lastName, String email, String adress, String company) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.adress = adress;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String email() {
        return email;
    }

    public String getAdress() {
        return adress;
    }

    public String getCompany() {
        return company;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = name;
    }

    public void setEnail(String email) {
        this.email = email;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}
