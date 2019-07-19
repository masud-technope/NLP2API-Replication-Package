package net.codejava.graphic;
 
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
import javax.imageio.ImageIO;
 
public class ImageConverter {
 
    /**
     * Converts an image to another format
     *
     * @param inputImagePath Path of the source image
     * @param outputImagePath Path of the destination image
     * @param formatName the format to be converted to, one of: jpeg, png,
     * bmp, wbmp, and gif
     * @return true if successful, false otherwise
     * @throws IOException if errors occur during writing
     */
    public static boolean convertFormat(String inputImagePath,
            String outputImagePath, String formatName) throws IOException {
        FileInputStream inputStream = new FileInputStream(inputImagePath);
        FileOutputStream outputStream = new FileOutputStream(outputImagePath);
         
        // reads input image from file
        BufferedImage inputImage = ImageIO.read(inputStream);
         
        // writes to the output image in specified format
        boolean result = ImageIO.write(inputImage, formatName, outputStream);
         
        // needs to close the streams
        outputStream.close();
        inputStream.close();
         
        return result;
    }
}
