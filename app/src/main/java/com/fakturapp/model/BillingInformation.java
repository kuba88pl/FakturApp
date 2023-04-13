package com.fakturapp.model;

public class BillingInformation extends BaseEntity{
    private String nip;
    private String regon;

    public BillingInformation() {
    }

    public BillingInformation(String nip, String regon) {
        this.nip = nip;
        this.regon = regon;
    }

    public BillingInformation(int id, String nip, String regon) {
        super(id);
        this.nip = nip;
        this.regon = regon;
    }

    public String getNip() {
        return nip;
    }

    public String getRegon() {
        return regon;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }
}