import javax.swing.JMenu;
import javax.swing.JPopupMenu;

public class Main {
  public static void main(String[] argv) throws Exception {
    final JPopupMenu popupMenu = new JPopupMenu();

    JMenu submenu = new JMenu("SubMenu1");
    submenu.add("asdf");
    submenu.add("asdf");

    // Add submenu to popup menu
    popupMenu.add(submenu);
  }
}
