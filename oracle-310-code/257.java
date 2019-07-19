import java.awt.BorderLayout;
//www  . j  a  v  a 2s  .co  m
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    JComponent button = new JButton("Cut");
    String tooltiptext = "<html>" + "This is the "
        + "<img src=\"file:cut.gif\">" + " tool tip text." + "</html>";
    button.setToolTipText(tooltiptext);
    JPanel panel = new JPanel();
    panel.add(button);
    frame.add(panel, BorderLayout.CENTER);
    frame.setSize(400, 400);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
