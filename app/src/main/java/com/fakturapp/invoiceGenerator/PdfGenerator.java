package com.fakturapp.invoiceGenerator;

import android.content.Context;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class PdfGenerator {

    private final Context context;

    private PdfGenerator(Context context){
        this.context = context;
    }

    public static class PdfGeneratorFactory{
        public static PdfGenerator getPdfGenerator(Context context){
            return new PdfGenerator(context);
        }
    }

    private String generatePdfFileName(){
        return "template" + LocalDateTime.now().getNano() + ".pdf";
    }

    private String getPath(){
        return new File(context.getFilesDir(), generatePdfFileName()).getPath();
    }

    public void generatePdfFromHtml(String html) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter pdfWriter = PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(getPath())));
        document.open();
        InputStream fileInputStream = new ByteArrayInputStream(html.getBytes());
        XMLWorkerHelper workerHelper = XMLWorkerHelper.getInstance();
        workerHelper.parseXHtml(pdfWriter, document, fileInputStream);
        document.close();
        pdfWriter.close();
    }

}
