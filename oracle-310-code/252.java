import java.awt.BorderLayout;
/*  ww  w. java2 s.  c  om*/
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Main {

  public static void main(String[] args) {
    JPanel gui = new JPanel(new BorderLayout());
    gui.setBorder(new TitledBorder("Border Layout"));

    JPanel labels = new JPanel();
    labels.setBorder(new TitledBorder("Flow Layout"));
    labels.add(new JLabel("Label 1"));
    labels.add(new JLabel("Label 2"));

    gui.add(labels, BorderLayout.NORTH);
    gui.add(new JButton("Button"), BorderLayout.SOUTH);

    JOptionPane.showMessageDialog(null, gui);
  }
}
