import java.io.FileOutputStream;

import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

public class AddExtraPageToExistingPDF {
  public static void main(String[] args) {
    try {
      PdfReader reader = new PdfReader("YourOwnPDF.pdf");
      PdfStamper stamp = new PdfStamper(reader, new FileOutputStream("AddExtraPageToExistingPDF.pdf"));

      PdfContentByte over;
      BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);

      stamp.insertPage(1, PageSize.A4);
      over = stamp.getOverContent(1);
      over.beginText();
      over.setFontAndSize(bf, 18);
      over.showTextAligned(Element.ALIGN_LEFT, "DUPLICATE OF AN EXISTING PDF DOCUMENT", 30, 600, 0);
      over.endText();

      stamp.close();
    } catch (Exception de) {
      de.printStackTrace();
    }
  }
}