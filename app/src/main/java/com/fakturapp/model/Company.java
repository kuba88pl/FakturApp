package com.fakturapp.model;

import java.util.ArrayList;
import java.util.List;

public class Company extends BaseEntity {
    String companyName;
    Address companyAdress = new Address();
    Company company = new Company();

    public Company() {
    }

    public Company(String companyName, Address companyAdress) {
        this.companyName = companyName;
        this.companyAdress = companyAdress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Address getCompanyAdress() {
        return companyAdress;
    }

    public void setCompanyAdress(Address companyAdress) {
        this.companyAdress = companyAdress;
    }
    List<Company> companyList = new ArrayList<Company>();

    public Company companyAdd(Company company) {
        companyList.add(this.company);
        return company;
    }

}
