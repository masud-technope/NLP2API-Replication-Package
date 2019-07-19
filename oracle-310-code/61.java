package org.kodejava.example.itextpdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class SuperSubscriptDemo {
    public static void main(String[] args) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document,
                    new FileOutputStream("SuperSubscript.pdf"));
            document.open();

            Font small = FontFactory.getFont(FontFactory.HELVETICA,
                    5, Font.ITALIC);

            //
            // Add some chunks into the document object.
            //
            document.add(new Chunk("The quick brown  "));

            Chunk superscript = new Chunk("fox ");
            superscript.setTextRise(5f);
            superscript.setFont(small);
            document.add(superscript);

            document.add(new Chunk("jumps over the lazy "));

            Chunk subscript = new Chunk("dog");
            subscript.setTextRise(-5f);
            subscript.setFont(small);
            document.add(subscript);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}