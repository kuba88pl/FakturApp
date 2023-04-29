package com.fakturapp.model;

import com.x5.util.AccessAsBean;

import java.math.BigDecimal;
import java.util.List;

@AccessAsBean
public class Product extends BaseEntity{

    private String name;
    private String quantity;
    private BigDecimal price;
    private BigDecimal value;

    public Product(){

    }

    public Product(String name, String quantity, BigDecimal price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.value = this.price.multiply(new BigDecimal(quantity));
    }

    public Product(int id, String name, String quantity, BigDecimal price) {
        super(id);
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.value = this.price.multiply(new BigDecimal(quantity));
    }

    public Product(String name, String quantity, String price) {
        this.name = name;
        this.quantity = quantity;
        this.price = new BigDecimal(price);
        this.value = this.price.multiply(new BigDecimal(quantity));
    }

    public Product(int id, String name, String quantity, String price) {
        super(id);
        this.name = name;
        this.quantity = quantity;
        this.price = new BigDecimal(price);
        this.value = this.price.multiply(new BigDecimal(quantity));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
        this.value = getPrice().multiply(new BigDecimal(getQuantity()));
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
        this.value = getPrice().multiply(new BigDecimal(getQuantity()));
    }

    public BigDecimal getValue() {
        return value;
    }

    public static BigDecimal calculateProductsTotalPrice(List<Product> products){
        return products
                .stream()
                .map(Product::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
