package com.fakturapp.invoiceGenerator;

import static org.junit.jupiter.api.Assertions.*;

import com.fakturapp.enums.TemplateName;
import com.fakturapp.model.Address;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TemplateGeneratorTest {

    private String result;
    private TemplateGenerator templateGenerator;

    @BeforeEach
    void setUp(){
        result = "<h1>%s</h1><h1>%s</h1>\n";
        templateGenerator = TemplateGenerator.TemplateGeneratorFactory.getTemplateGenerator(TemplateName.TEST_TEMPLATE);
    }

    @Test
    void parseHtmlTemplate() {
        Address address = new Address("city", "street", "number", "place", "44-444");
        templateGenerator.addValueToTemplate("address", address);
        result = String.format(result, address.getCity(), address.getStreet());
        System.out.println(templateGenerator.parseHtmlTemplate());
        System.out.println(result);
        assertEquals(result, templateGenerator.parseHtmlTemplate());
    }
}