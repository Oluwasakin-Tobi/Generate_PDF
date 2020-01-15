/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createpdf;

import java.io.InputStream;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.pdf.PdfDocument;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.tool.xml.XMLWorkerHelper;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

//import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import java.io.File;
import java.io.FileInputStream;

/**
 *
 * @author oluwasakinoluwatobi
 */
public class CreatePdf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        generatePDF();
    }
    
    
    
     public static void generatePDF() throws Exception {
        InputStream inputStream = null;
        try {

            //Specify a path to save the pdf
            String destination = "D:\\Documents\\Example.pdf";
            // Creating a PdfWriter object
            PdfWriter writer = new PdfWriter(destination);

            // Creating a PdfDocument object
            PdfDocument pdfDoc = new PdfDocument(writer);

            // Creating a Document object
            com.itextpdf.layout.Document doc = new com.itextpdf.layout.Document(pdfDoc);

            // Creating a table
            float [] pointColumnWidths = {200F, 200F};
            Table table = new Table(pointColumnWidths);

            // Populating row 1 and adding it to the table
            Cell c1 = new Cell();
            c1.add("I am writing to a pdf");
            c1.setBackgroundColor(Color.GRAY);
            c1.setBorder(Border.NO_BORDER);
            c1.setTextAlignment(TextAlignment.CENTER);
            table.addCell(c1);

            Cell c2 = new Cell();
            c2.add("because I can. Thanks");
            c2.setBackgroundColor(Color.GRAY);
            c2.setBorder(Border.NO_BORDER);
            c2.setTextAlignment(TextAlignment.CENTER);
            table.addCell(c2);

            // Adding Table to document
            doc.add(table);

            // Closing the document
            doc.close();

            System.out.println("Background added successfully..");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}

//ADD THE FOLLOWING DEPENDENCIES TO YOUR POM FILE AND YOU CAN CHECK FOR THE LATEST VERSION

<!-- https://mvnrepository.com/artifact/com.itextpdf/itextpdf -->
		<dependency>
			<groupId>com.itextpdf</groupId>
			<artifactId>itextpdf</artifactId>
			<version>5.5.13.1</version>
		</dependency>

		<dependency>
			<groupId>com.itextpdf.tool</groupId>
			<artifactId>xmlworker</artifactId>
			<version>5.5.10</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/com.itextpdf/layout -->
		<dependency>
			<groupId>com.itextpdf</groupId>
			<artifactId>layout</artifactId>
			<version>7.0.0</version>
		</dependency>
