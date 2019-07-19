import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Snippet94 {

  public static void main(String[] args) {
    Display display = new Display();
    final Clipboard cb = new Clipboard(display);
    final Shell shell = new Shell(display);
    shell.setLayout(new FormLayout());
    final Text text = new Text(shell, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL
        | SWT.H_SCROLL);

    Button copy = new Button(shell, SWT.PUSH);
    copy.setText("Copy");
    copy.addListener(SWT.Selection, new Listener() {
      public void handleEvent(Event e) {
        String textData = text.getSelectionText();
        TextTransfer textTransfer = TextTransfer.getInstance();
        cb.setContents(new Object[] { textData },
            new Transfer[] { textTransfer });
      }
    });

    Button paste = new Button(shell, SWT.PUSH);
    paste.setText("Paste");
    paste.addListener(SWT.Selection, new Listener() {
      public void handleEvent(Event e) {
        TextTransfer transfer = TextTransfer.getInstance();
        String data = (String) cb.getContents(transfer);
        if (data != null) {
          text.insert(data);
        }
      }
    });

    FormData data = new FormData();
    data.right = new FormAttachment(100, -5);
    data.top = new FormAttachment(0, 5);
    copy.setLayoutData(data);

    data = new FormData();
    data.right = new FormAttachment(100, -5);
    data.top = new FormAttachment(copy, 5);
    paste.setLayoutData(data);

    data = new FormData();
    data.left = new FormAttachment(0, 5);
    data.top = new FormAttachment(0, 5);
    data.right = new FormAttachment(copy, -5);
    data.bottom = new FormAttachment(100, -5);
    text.setLayoutData(data);

    shell.setSize(200, 200);
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
    cb.dispose();
    display.dispose();
  }
}