package com.memorynotfound.view;

import java.text.DateFormat;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.o7planning.springmvcshoppingcart.model.CartInfo;
import org.o7planning.springmvcshoppingcart.model.CartLineInfo;
import org.o7planning.springmvcshoppingcart.util.Utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
//import com.memorynotfound.model.Course;

public class ItextPdfView extends AbstractITextPdfView {

    //private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
    	
    	CartInfo cartInfo = Utils.getCartInSession(request);
    	    	
        @SuppressWarnings("unchecked")
        //List<Course> courses = (List<Course>) model.get("courses");

        PdfPTable table = new PdfPTable(2);
        table.setWidths(new int[]{20, 50});

        table.addCell("ID");
        table.addCell("Name");
       
               
        for(CartLineInfo cartline : cartInfo.getCartLines()) {
        	table.addCell(cartline.getProductInfo().getCode());
        	table.addCell(cartline.getProductInfo().getName());
        	       	
        }


        document.add(table);
        
    }

}