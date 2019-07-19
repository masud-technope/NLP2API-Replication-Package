import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfDestination;
import com.lowagie.text.pdf.PdfOutline;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;

public class Bookmarks1PDF{
  public static void main(String[] args) {
    Document document = new Document(PageSize.A6);
    try {
      PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Bookmarks1PDF.pdf"));
      writer.setViewerPreferences(PdfWriter.PageModeUseOutlines);
      document.open();
            
      document.add(new Paragraph("Text.", new Font(Font.HELVETICA, 12)));
      PdfContentByte cb = writer.getDirectContent();
      PdfDestination destination = new PdfDestination(PdfDestination.FITH, 0);
      PdfOutline outline = new PdfOutline(cb.getRootOutline(), destination, "paragraph " + 1);
      
      document.add(new Paragraph("Text.", new Font(Font.HELVETICA, 12)));
      document.add(new Paragraph("Text.", new Font(Font.HELVETICA, 12)));
      
      cb = writer.getDirectContent();
      destination = new PdfDestination(PdfDestination.FITH, 1);
      outline = new PdfOutline(cb.getRootOutline(), destination, "paragraph " + 2);
      
      document.add(new Paragraph("Text.", new Font(Font.HELVETICA, 12)));
    } catch (Exception de) {
      de.printStackTrace();
    }
    document.close();
  }
}