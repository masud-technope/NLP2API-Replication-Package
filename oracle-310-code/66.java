package com.javadb.triangle;
 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JFrame;
 
/**
 *
 * @author www.javadb.com
 */
public class TriangleFrame extends JFrame {
    
    public TriangleFrame() {
        init();
    }
 
    private void init() {
        this.setTitle("Draggable triangle example by www.javadb.com");
        TrianglePanel triangle = new TrianglePanel(new Point(100, 10), new Point(50, 100), new Point(150, 100));
        triangle.setPreferredSize(new Dimension(500, 500));
        triangle.setBackground(Color.BLUE);
        this.add(triangle);
        pack();
    }
    
    public static void main(String[] args) {
        TriangleFrame frame = new TriangleFrame();
        frame.setVisible(true);
    }
    
}