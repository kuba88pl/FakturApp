package com.fakturapp.model;

import com.x5.util.AccessAsBean;

@AccessAsBean
public class Address extends BaseEntity {
    private String city;
    private String street;
    private String number;
    private String place;
    private String cityCode;

    public Address() {
    }

    public Address(String city, String street, String number, String place, String cityCode) {
        this.city = city;
        this.street = street;
        this.number = number;
        this.place = place;
        this.cityCode = cityCode;
    }

    public Address(int id, String city, String street, String number, String place, String cityCode) {
        super(id);
        this.city = city;
        this.street = street;
        this.number = number;
        this.place = place;
        this.cityCode = cityCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

}
