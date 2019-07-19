import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class AddingParagraphToAPagePDF {
  public static void main(String[] args) {
    Document document = new Document();
    try {
      PdfWriter.getInstance(document, new FileOutputStream("AddingParagraphToAPagePDF.pdf"));
      document.open();
      document.add(new Paragraph("First Page."));
      document.setPageSize(PageSize.A3);
      document.newPage();
      document.add(new Paragraph("This PageSize is A3."));
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    document.close();
  }
}