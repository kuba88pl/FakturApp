package com.fakturapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import com.fakturapp.invoiceGenerator.TemplateGenerator;
import com.fakturapp.model.Address;
import com.fakturapp.model.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageButton loginBtn, createBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.loginButton);
        createBtn = findViewById(R.id.createAccount);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             openActivityLogin();
            }
        });

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityRegister();
            }
        });

        toTestTemplateDeleteLater();
    }

public void openActivityLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
}

public void openActivityRegister() {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
}










    /**
     * I leave it here for now for some future test of template. It will be deleted later
     */
    private void toTestTemplateDeleteLater(){
        Address address = new Address(1, "m-ce", "p", "22", "1", "44-444");
        Address address2 = new Address(2, "m-ce2", "p2", "222", "12", "44-444");
        Address address3 = new Address(3, "m-ce3", "p3", "2223", "123", "44-444");

        Product product1 = new Product("name1", "2", "3.22");
        Product product2 = new Product("name2", "1", "1.00");
        Product product3 = new Product("name3", "3", "5.15");

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        BigDecimal totalPrice = products.stream().map(Product::getValue).reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("totalPrice = " + totalPrice);
        System.out.println("totalPrice2 = " + Product.calculateProductsTotalPrice(products));

        TemplateGenerator templateGenerator = TemplateGenerator.TemplateGeneratorFactory.getTemplateGenerator();
        templateGenerator.addValueToTemplate("address", address);
        templateGenerator.addValueToTemplate("address2", address);
        templateGenerator.addValueToTemplate("products", products);
        templateGenerator.addValueToTemplate("totalPrice", Product.calculateProductsTotalPrice(products));
        templateGenerator.addValueToTemplate("invoiceData", LocalDate.now().toString());
        templateGenerator.addValueToTemplate("saleData", LocalDate.now().toString());
        templateGenerator.addValueToTemplate("invoiceNumber", "3-15-15");
        String s = templateGenerator.parseHtmlTemplate();
        System.out.println("******************");
        System.out.println("html = " + s);
        System.out.println("******************");


        templateGenerator.addValueToTemplate("address", address2);
        templateGenerator.addValueToTemplate("address2", address);
        templateGenerator.addValueToTemplate("products", products);
        templateGenerator.addValueToTemplate("totalPrice", totalPrice);
        templateGenerator.addValueToTemplate("invoiceData", LocalDate.now().toString());
        templateGenerator.addValueToTemplate("saleData", LocalDate.now().toString());
        templateGenerator.addValueToTemplate("invoiceNumber", "3-15-15");
        String s2 = templateGenerator.parseHtmlTemplate();
        System.out.println("******************");
        System.out.println("html2 = " + s2);
        System.out.println("******************");

        TemplateGenerator templateGenerator3 = TemplateGenerator.TemplateGeneratorFactory.getTemplateGenerator();
        templateGenerator3.addValueToTemplate("address", address3);
        templateGenerator.addValueToTemplate("address2", address);
        templateGenerator.addValueToTemplate("products", products);
        templateGenerator.addValueToTemplate("totalPrice", totalPrice);
        templateGenerator3.addValueToTemplate("invoiceData", LocalDate.now().toString());
        templateGenerator3.addValueToTemplate("saleData", LocalDate.now().toString());
        templateGenerator3.addValueToTemplate("invoiceNumber", "3-15-15");
        String s3 = templateGenerator.parseHtmlTemplate();
        System.out.println("******************");
        System.out.println("html3 = " + s3);
        System.out.println("******************");

    }
}