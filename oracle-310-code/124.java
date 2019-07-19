import java.io.FileOutputStream;
import java.util.HashMap;

import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

public class AddWatermarkImageToAnExistingPDFFile {
    public static void main(String[] args) {
        try {
            PdfReader reader = new PdfReader("YourOwnPDF.pdf");
            int n = reader.getNumberOfPages();
            PdfStamper stamp = new PdfStamper(reader, new FileOutputStream("NewPDFWithWatermarkImage.pdf"));
            int i = 0;
            PdfContentByte under;
            Image img = Image.getInstance("logo.png");
            img.setAbsolutePosition(200, 400);
            while (i < n) {
              i++;
              under = stamp.getUnderContent(i);
              under.addImage(img);
            }
            stamp.close();
        }
        catch (Exception de) {
            de.printStackTrace();
        }
    }
}