import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*  w w  w . jav a  2  s. co  m*/
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main extends JFrame implements ActionListener {
  ImageIcon m[];
  JLabel l;
  JButton b = new JButton("Pre"), b1= new JButton("Next");
  int i, l1;
  JPanel p;

  public Main() {
    setLayout(new BorderLayout());
    setSize(300, 300);
    setVisible(true);
    JPanel p = new JPanel(new FlowLayout());
    
    p.add(b);
    p.add(b1);
    add(p, BorderLayout.SOUTH);
    b.addActionListener(this);
    b1.addActionListener(this);
    m = new ImageIcon[2];
    m[0] = new ImageIcon("m.jpg");
    m[1] = new ImageIcon("m1.jpg");
    l = new JLabel();
    l.setBounds(400, 0, getWidth(), getHeight());
    add(l, BorderLayout.CENTER);
    l.setIcon(m[0]);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == b) {
      if (i == 0) {
        JOptionPane.showMessageDialog(null, "This is First Image");
      } else {
        i = i - 1;
        l.setIcon(m[i]);
      }
    }
    if (e.getSource() == b1) {
      if (i == m.length - 1) {
        JOptionPane.showMessageDialog(null, "This is LastImage");
      } else {
        i = i + 1;
        l.setIcon(m[i]);
      }
    }
  }
  public static void main(String args[]) {
    Main i1 = new Main();
  }
}

