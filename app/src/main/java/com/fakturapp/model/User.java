package com.fakturapp.model;

public class User extends People{
    String name;
    String lastName;
    String enail;
    String adress;
    String company;


    public User() {
    }

    public User (String name, String lastName, String email, String adress, String company) {
        this.name = name;
        this.lastName = lastName;
        this.enail = email;
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
        return email();
    }

    public String getAdress(){
        return adress;
    }

    public String getCompany() {
        return company;
    }

   public void setName(String name) {
        this.name =name;
   }

   public void setLastName(String lastName){
        this.lastName = name;
   }

   public void setEnail(String email) {
        this.enail = email;
   }

   public void setAdress(String adress) {
        this.adress = adress;
   }

   public void setCompany(String company) {
        this.company = company;
   }

}
