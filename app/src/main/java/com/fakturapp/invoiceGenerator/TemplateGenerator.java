package com.fakturapp.invoiceGenerator;

import com.fakturapp.enums.TemplateName;
import com.fakturapp.model.Address;
import com.fakturapp.model.BaseEntity;
import com.x5.template.Chunk;
import com.x5.template.Theme;

import java.util.HashMap;
import java.util.Map;

public class TemplateGenerator {

    private final Map<String, Object> valuesToAddToTemplate = new HashMap<>();
    private final Chunk html;

    private TemplateGenerator(TemplateName templateName) {
        Theme theme = new Theme();
        this.html = theme.makeChunk(templateName.getTemplateName());
    }

    public static class TemplateGeneratorFactory{

        public static TemplateGenerator getTemplateGenerator(){
            return getTemplateGenerator(TemplateName.INVOICE_TEMPLATE1);
        }

        public static TemplateGenerator getTemplateGenerator(TemplateName templateName){
            return new TemplateGenerator(templateName);
        }
    }

    public String parseHtmlTemplate(){
        if (!valuesToAddToTemplate.isEmpty()){
            addValuesToTemplate();
        }
        return html.toString();
    }

    public void addValueToTemplate(String key, Object value){
        valuesToAddToTemplate.put(key, value);
    }

    private void addValuesToTemplate(){
        valuesToAddToTemplate.forEach((key, value) -> {
            html.set(key, value);
//            if (value instanceof String){
//                html.set(key, value);
//            }else if (value instanceof BaseEntity){
//                html.setToBean(key, value);
//            }else {
//                html.set(key, value);
//            }
        });
    }
}
