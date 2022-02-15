/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flutapp;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author azubi02
 */
public class createPDF {

    private static final PDDocument document = new PDDocument();
    private static final PDPage page = new PDPage();
    private static PDPageContentStream contentStream;

    public static String nachname;
    public static String betrag;
    public static int rechnungsnr;
    public static String datum;
    public static String vorname;
    public static String strasse;
    public static String hausnummer;
    public static String plz;
    public static String stadt;
    public static String email;
    

    
    public createPDF() throws IOException{
    
    
            document.addPage(page);
            contentStream = new PDPageContentStream(document, page);

            //Schriftart
            PDFont font = PDType1Font.HELVETICA;

            //Content
            add("Sehr geehrte/r Frau/Herr " + nachname, font, 12, 50, 650);
            add("Rechnungsnummer:" + " " + rechnungsnr, font, 12, 400, 760);
            add("Datum:" + datum, font, 12, 400, 730);
            add("Spendenbetrag:" + " " + betrag + "€", font, 12, 400, 700);
            add("vielen Dank für Ihre Unterstützung der Flutopfer!", font, 12, 50, 530);
            add("Ihr Spendenbetrag in Höhe von 100€ wurden erhalten", font, 12, 50, 510);
            add("Angaben zum Spender:", font, 12, 50, 470);
            add("Name:" + " " + vorname + " " + nachname, font, 12, 50, 450);
            add("Anschrift:" + " " + strasse + " " + hausnummer + " " + plz + " " + stadt, font, 12, 50, 430);
            add("Email:" + " " + email, font, 12, 50, 410);
            add("Mit freundlichen Grüßen", font, 12, 50, 260);
            add("Aktion Deutschland", font, 12, 50, 240);
         

            contentStream.close();

            document.save("Rechnung.pdf");
            document.close();

        }
    

    //Rohr 
    private static void add(String text, PDFont font, int size, int x, int y) throws IOException {

        contentStream.beginText();
        contentStream.setFont(font, size);
        contentStream.newLineAtOffset(x, y);
        contentStream.showText(text);
        contentStream.endText();
    }
    
}
