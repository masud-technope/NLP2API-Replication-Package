import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
 
public class ExtractZipWithCRC32Checksum {
 
        public static void main(String args[])
        {
               
                String sourceZipFile = "C:/FileIO/sourceFile.zip";
               
                try
                {
                        //create FileInputStream from the source zip file
                        FileInputStream fin = new FileInputStream(sourceZipFile);
                       
                        /*
                         * To extract zip file with CRC32 checksum, use
                         *
                         * CheckedInputStream(InputStream in, Checksum checksum)
                         *
                         * Constructor.
                         */
                         
                         //create CheckedInputStream object.
                         CheckedInputStream checksum = new CheckedInputStream(fin,new CRC32());
                         
                        //create ZipInputStream from CheckedInputStream object
                        ZipInputStream zin = new ZipInputStream(checksum);
                       
                        //get the first entry from the source zip file
                        ZipEntry entry = zin.getNextEntry();
                       
                        //crate OutputStream to extract the entry from zip file
                        OutputStream os = new FileOutputStream("c:/extractedFile.css");
                       
                       
                        byte[] buffer = new byte[1024];
                        int length;
                       
                        //read the entry from zip file and extract it to disk
                        while( (length = zin.read(buffer)) > 0)
                        {
                                os.write(buffer, 0, length);
                        }
                       
                        //close the streams
                        os.close();
                       
                        //close the zip file
                        zin.close();
                       
                        System.out.println("File Extracted from zip file");
                       
                        /*
                         * To get the CRC32 checksum of the extracted file, use
                         *
                         * Checksum getChecksum()
                         *
                         * Method of CheckedInputStream class.
                         */
                         
                         System.out.println("CRC32 checksum is: " + checksum.getChecksum().getValue());
                         
                }
                catch(IOException e)
                {
                        System.out.println("IOException :" + e);
                }
               
        }
 
}