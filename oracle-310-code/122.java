import java.awt.Color;
import java.awt.Toolkit;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

public class AddingAWTImageColorPDF {
  public static void main(String[] args) {
    Document document = new Document();
    try {
      PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("AddingAWTImageColorPDF.pdf"));
      document.open();
      PdfContentByte cb = writer.getDirectContent();
      
      java.awt.Image awtImage = Toolkit.getDefaultToolkit().createImage("logo.png");

      Image image = Image.getInstance(awtImage, new Color(0x00, 0x00, 0xFF), true);
      image.setAbsolutePosition(100, 500);
      cb.addImage(image);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    document.close();
  }
}