package com.javadb;
 
import java.awt.AWTException;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
 
/**
 *
 * @author www.javadb.com
 */
public class ScreenCapture {
 
    BufferedImage theScreen;
 
    public void captureScreenShot() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        Rectangle screenSize = getScreenSize();
        theScreen = robot.createScreenCapture(screenSize);
    }
 
    private Rectangle getScreenSize() {
        GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gDev = gEnv.getDefaultScreenDevice();
        DisplayMode mode = gDev.getDisplayMode();
        return new Rectangle(mode.getWidth(), mode.getHeight());
        //return new Rectangle(100, 100);  <- any size is valid
    }
 
    public void saveAsPng(String fileName) {
        if (theScreen == null) {
            System.err.println("Couldn't find any captured screenshot.");
            return;
        }
        Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName("png");
        if (!iter.hasNext()) {
            System.err.println("No ImageWriter could be found for this format");
            System.exit(-1);
        }
        ImageWriter imgWriter = iter.next();
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName));
            ImageOutputStream ios = ImageIO.createImageOutputStream(bos);
            imgWriter.setOutput(ios);
            imgWriter.write(theScreen);
            ios.close();
            bos.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
 
    public static void main(String[] args) {
        ScreenCapture sc = new ScreenCapture();
        sc.captureScreenShot();
        sc.saveAsPng("MyScreen.png");
    }
}