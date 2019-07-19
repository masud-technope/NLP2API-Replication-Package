import java.io.FileOutputStream;
import java.net.URL;

import com.lowagie.text.Annotation;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfAction;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

public class SimpleAnnotationsWithAnotherPDF {
  public static void main(String[] args) {
    Document document1 = new Document(PageSize.A4, 10, 10, 10, 10);
    try {
      PdfWriter writer1 = PdfWriter.getInstance(document1, new FileOutputStream("SimpleAnnotationsWithAnotherPDF.pdf"));
      writer1.setPdfVersion(PdfWriter.VERSION_1_5);
      document1.open();

      Annotation a = new Annotation(100f, 400f, 200f, 500f, "SimpleAnnotations1.pdf", 2);

      document1.add(a);
    } catch (Exception de) {
      de.printStackTrace();
    }
    document1.close();
  }
}