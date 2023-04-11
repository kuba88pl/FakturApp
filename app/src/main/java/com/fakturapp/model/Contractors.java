package com.fakturapp.model;


public class Contractors extends User {

    User contractor = new User();

    Company contractorCompany;

    public String getName(String name) {
        contractor.name = name;
        return name;
    }

    public String getLastName(String lastName) {
        contractor.lastName = lastName;
        return name;
    }

    public String getEmail(String email) {
        contractor.email = email;
        return email;
    }

    public String getAdress() {
        //adressClass to referencja do klasy Adress
        Address addressClass = new Address();
        addressClass.getCity();
        addressClass.getStreet();
        addressClass.getPlace();
        addressClass.getNumber();
        contractor.adress =
                  addressClass.getCity().toString()
                + addressClass.getStreet().toString()
                + addressClass.getPlace().toString()
                + addressClass.getNumber().toString();
        return adress;
    }

    public Company getContractorCompany(Company company) {

        return company.companyAdd(contractorCompany);
    }

    public void setContractorCompany(Company contractorCompany) {
        this.contractorCompany = contractorCompany;
    }


}
