package com.fakturapp.enums;

public enum TemplateName {
    INVOICE_TEMPLATE1("invoice-template1"),
    TEST_TEMPLATE("test-template");

    private final String templateName;

    TemplateName(String templateName){
        this.templateName = templateName;
    }

    public String getTemplateName(){
        return templateName;
    }
}
