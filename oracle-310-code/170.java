import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CaretListener;
import org.eclipse.swt.custom.ExtendedModifyEvent;
import org.eclipse.swt.custom.ExtendedModifyListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.xml.sax.SAXException;

public class RichText extends Composite {

 private List cachedStyles =
   Collections.synchronizedList(new LinkedList());

 private ToolBar toolBar;
 private StyledText styledText;

 private ToolItem boldBtn;
 private ToolItem italicBtn;
 private ToolItem strikeThroughBtn;
 private ToolItem underlineBtn;

 private ToolItem pasteBtn;
 private ToolItem eraserBtn;

 public RichText(Composite parent, int style) {
  super(parent, style);
  initComponents();
 }

 public void addCaretListener(CaretListener listener) {
  styledText.addCaretListener(listener);
 }

 public void removeCaretListener(CaretListener listener) {
  styledText.removeCaretListener(listener);
 }

 public void addExtendedModifyListener(ExtendedModifyListener listener) {
  styledText.addExtendedModifyListener(listener);
 }

 public void removeExtendedModifyListener(ExtendedModifyListener listener) {
  styledText.removeExtendedModifyListener(listener);
 }

 public void addModifyListener(ModifyListener listener) {
  styledText.addModifyListener(listener);
 }

 public void removeModifyListener(ModifyListener listener) {
  styledText.removeModifyListener(listener);
 }

 public void addVerifyKeyListener(VerifyKeyListener listener) {
  styledText.addVerifyKeyListener(listener);
 }

 public void removeVerifyKeyListener(VerifyKeyListener listener) {
  styledText.removeVerifyKeyListener(listener);
 }

 public void addVerifyListener(VerifyListener listener) {
  styledText.addVerifyListener(listener);
 }

 public void removeVerifyListener(VerifyListener listener) {
  styledText.removeVerifyListener(listener);
 }

 public int getCharCount() {
  return styledText.getCharCount();
 }

 public Caret getCaret() {
  return styledText.getCaret();
 }

 public int getCaretOffset() {
  return styledText.getCaretOffset();
 }

 /**
  * Obtain an HTML formatted text from the component contents
  *
  * @return an HTML formatted text
  */
 public String getFormattedText() {
  String plainText = styledText.getText();

  RichStringBuilder builder = new RichStringBuilder();
  Integer[] lineBreaks = getLineBreaks();

  int brIdx = 0;
  int start = 0;
  int end = (lineBreaks.length > brIdx ? lineBreaks[brIdx++] : plainText.length() - 1);

  while (start < end) {
    builder.startParagraph();
    StyleRange[] ranges = styledText.getStyleRanges(start, (end - start));
    if (ranges != null && ranges.length > 0) {
    for (int i = 0;i < ranges.length;i++) {
     if (start < ranges[i].start) {
      builder.append(plainText.substring(start, ranges[i].start));
     }

     List styles = translateStyle(ranges[i]);
     builder.startFontStyles(styles.toArray(new FontStyle[styles.size()]));
     builder.append(plainText.substring(ranges[i].start,
       ranges[i].start + ranges[i].length));
     builder.endFontStyles(styles.size());

     start = (ranges[i].start + ranges[i].length) + 1;
    }
   }
   if (start < end) {
     builder.append(plainText.substring(start, end));
    }
    start = end + styledText.getLineDelimiter().length();
    end = (lineBreaks.length > brIdx ? lineBreaks[brIdx++] : plainText.length() - 1);
   builder.endParagraph();
  }

  return builder.toString();
 }

 public void setFormattedText(String text)
 throws ParserConfigurationException, SAXException, IOException {
  RichTextParser parser = RichTextParser.parse(text);
  styledText.setText(parser.getText());
  styledText.setStyleRanges(parser.getStyleRanges());
 }

 public int getLineAtOffset(int offset) {
  return styledText.getLineAtOffset(offset);
 }

 public int getLineCount() {
  return styledText.getLineCount();
 }

 public int getLineSpacing() {
  return styledText.getLineSpacing();
 }

 public String getText() {
  return styledText.getText();
 }

 protected void applyFontStyleToSelection(FontStyle style) {
  Point sel = styledText.getSelectionRange();
  if ((sel == null) || (sel.y == 0)) {
   return ;
  }

  StyleRange newStyle;
  for (int i = sel.x; i < (sel.x + sel.y); i++) {
   StyleRange range = styledText.getStyleRangeAtOffset(i);
   if (range != null) {
    newStyle = (StyleRange) range.clone();
    newStyle.start = i;
    newStyle.length = 1;
   } else {
    newStyle = new StyleRange(i, 1, null, null, SWT.NORMAL);
   }

   switch (style) {
   case BOLD:
    newStyle.fontStyle ^= SWT.BOLD;
    break;
   case ITALIC:
    newStyle.fontStyle ^= SWT.ITALIC;
    break;
   case STRIKE_THROUGH:
    newStyle.strikeout = !newStyle.strikeout;
    break;
   case UNDERLINE:
    newStyle.underline = !newStyle.underline;
    break;
   }

   styledText.setStyleRange(newStyle);
  }

  styledText.setSelectionRange(sel.x + sel.y, 0);
 }

 /**
  * Clear all styled data
  */
 protected void clearStylesFromSelection() {
  Point sel = styledText.getSelectionRange();
  if ((sel != null) && (sel.y != 0)) {
   StyleRange style = new StyleRange(
     sel.x, sel.y, null, null, SWT.NORMAL);
   styledText.setStyleRange(style);
  }
  styledText.setSelectionRange(sel.x + sel.y, 0);
 }

 private Integer[] getLineBreaks() {
  List list = new ArrayList();
  int lastIdx = 0;
  while (lastIdx < styledText.getCharCount()) {
    int br = styledText.getText().indexOf(
      styledText.getLineDelimiter(), lastIdx);
    if (br >= lastIdx && !list.contains(br)) {
    list.add(br);
   }
   lastIdx += styledText.getLineDelimiter().length() + 1;
  }
  Collections.sort(list);
  return list.toArray(new Integer[list.size()]);
 }

 protected void handleCutCopy() {
  // Save the cut/copied style info so that during paste we will maintain
  // the style information. Cut/copied text is put in the clipboard in
  // RTF format, but is not pasted in RTF format. The other way to
  // handle the pasting of styles would be to access the Clipboard
  // directly and
  // parse the RTF text.
  cachedStyles = Collections
    .synchronizedList(new LinkedList());
  Point sel = styledText.getSelectionRange();
  int startX = sel.x;
  for (int i = sel.x; i <= sel.x + sel.y - 1; i++) {
    StyleRange style = styledText.getStyleRangeAtOffset(i);
   if (style != null) {
    style.start = style.start - startX;
    if (!cachedStyles.isEmpty()) {
     StyleRange lastStyle = cachedStyles
       .get(cachedStyles.size() - 1);
     if (lastStyle.similarTo(style)
       && lastStyle.start + lastStyle.length == style.start) {
      lastStyle.length++;
     } else {
      cachedStyles.add(style);
     }
    } else {
     cachedStyles.add(style);
    }
   }
  }
  pasteBtn.setEnabled(true);
 }

 private void handleExtendedModified(ExtendedModifyEvent event) {
  if (event.length == 0) return;

  StyleRange style;
  if (event.length == 1
    || styledText.getTextRange(event.start, event.length).equals(
      styledText.getLineDelimiter())) {
   // Have the new text take on the style of the text to its right
   // (during
   // typing) if no style information is active.
   int caretOffset = styledText.getCaretOffset();
   style = null;
   if (caretOffset < styledText.getCharCount())
    style = styledText.getStyleRangeAtOffset(caretOffset);
   if (style != null) {
    style = (StyleRange) style.clone();
    style.start = event.start;
    style.length = event.length;
   } else {
    style = new StyleRange(event.start, event.length, null, null,
      SWT.NORMAL);
   }
   if (boldBtn.getSelection())
    style.fontStyle |= SWT.BOLD;
   if (italicBtn.getSelection())
    style.fontStyle |= SWT.ITALIC;
   style.underline = underlineBtn.getSelection();
   style.strikeout = strikeThroughBtn.getSelection();
   if (!style.isUnstyled())
    styledText.setStyleRange(style);
  } else {
   // paste occurring, have text take on the styles it had when it was
   // cut/copied
   for (int i = 0; i < cachedStyles.size(); i++) {
     style = cachedStyles.get(i);
     StyleRange newStyle = (StyleRange) style.clone();
     newStyle.start = style.start + event.start;
     styledText.setStyleRange(newStyle);
    }
   }
  }

  private void handleTextSelected(SelectionEvent event) {
   Point sel = styledText.getSelectionRange();
   if ((sel != null) && (sel.y != 0)) {
    StyleRange[] styles = styledText.getStyleRanges(sel.x, sel.y);
    eraserBtn.setEnabled((styles != null) && (styles.length > 0));
  } else {
   eraserBtn.setEnabled(false);
  }
 }

 private void handleKeyReleased(KeyEvent event) {
  if ((event.keyCode == SWT.ARROW_LEFT) || (event.keyCode == SWT.ARROW_UP)
    || (event.keyCode == SWT.ARROW_RIGHT) || (event.keyCode == SWT.ARROW_DOWN)) {
   updateStyleButtons();
  }
 }

 private void updateStyleButtons() {
  int caretOffset = styledText.getCaretOffset();
  StyleRange style = null;
  if (caretOffset >= 0 && caretOffset < styledText.getCharCount()) {
   style = styledText.getStyleRangeAtOffset(caretOffset);
  }

  if (style != null) {
   boldBtn.setSelection((style.fontStyle & SWT.BOLD) != 0);
   italicBtn.setSelection((style.fontStyle & SWT.ITALIC) != 0);
   underlineBtn.setSelection(style.underline);
   strikeThroughBtn.setSelection(style.strikeout);
  } else {
   boldBtn.setSelection(false);
   italicBtn.setSelection(false);
   underlineBtn.setSelection(false);
   strikeThroughBtn.setSelection(false);
  }
 }

 private void initComponents() {
  GridLayout layout = new GridLayout();
  layout.numColumns = 1;
  setLayout(layout);

  toolBar = createToolBar(this);
  toolBar.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

  styledText = new StyledText(this, SWT.BORDER | SWT.MULTI |
    SWT.V_SCROLL | SWT.H_SCROLL);
  styledText.setLayoutData(new GridData(GridData.FILL_BOTH));
  styledText.addKeyListener(new KeyAdapter() {
   @Override
   public void keyReleased(KeyEvent e) {
    handleKeyReleased(e);
   }
  });
  styledText.addExtendedModifyListener(new ExtendedModifyListener() {
   @Override
   public void modifyText(ExtendedModifyEvent event) {
    handleExtendedModified(event);
   }
  });
  styledText.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseUp(MouseEvent e) {
    updateStyleButtons();
   }
  });
  styledText.addSelectionListener(new SelectionAdapter() {
   @Override
   public void widgetSelected(SelectionEvent event) {
    handleTextSelected(event);
   }
  });
 }

 private ToolBar createToolBar(Composite parent) {
  ToolBar toolBar = new ToolBar(parent, SWT.FLAT);

  boldBtn = new ToolItem(toolBar, SWT.CHECK);
  boldBtn.setImage(RichTextImages.IMG_BOLD);
  boldBtn.setToolTipText(RichTextStrings.boldBtn_tooltipText);
  boldBtn.addSelectionListener(
    new FontStyleButtonListener(FontStyle.BOLD));

  italicBtn = new ToolItem(toolBar, SWT.CHECK);
  italicBtn.setImage(RichTextImages.IMG_ITALIC);
  italicBtn.setToolTipText(RichTextStrings.italicBtn_tooltipText);
  italicBtn.addSelectionListener(
    new FontStyleButtonListener(FontStyle.ITALIC));

  underlineBtn = new ToolItem(toolBar, SWT.CHECK);
  underlineBtn.setImage(RichTextImages.IMG_UNDERLINE);
  underlineBtn.setToolTipText(RichTextStrings.underlineBtn_tooltipText);
  underlineBtn.addSelectionListener(
    new FontStyleButtonListener(FontStyle.UNDERLINE));

  strikeThroughBtn = new ToolItem(toolBar, SWT.CHECK);
  strikeThroughBtn.setImage(RichTextImages.IMG_STRIKE_THROUGH);
  strikeThroughBtn.setToolTipText(RichTextStrings.strikeThroughBtn_tooltipText);
  strikeThroughBtn.addSelectionListener(
    new FontStyleButtonListener(FontStyle.STRIKE_THROUGH));

  new ToolItem(toolBar, SWT.SEPARATOR);

  ToolItem cutBtn = new ToolItem(toolBar, SWT.PUSH);
  cutBtn.setImage(RichTextImages.IMG_CUT);
  cutBtn.setToolTipText(RichTextStrings.cutBtn_tooltipText);
  cutBtn.addSelectionListener(new SelectionAdapter() {
   @Override
   public void widgetSelected(SelectionEvent e) {
    handleCutCopy();
    styledText.cut();
   }
  });

  ToolItem copyBtn = new ToolItem(toolBar, SWT.PUSH);
  copyBtn.setImage(RichTextImages.IMG_COPY);
  copyBtn.setToolTipText(RichTextStrings.copyBtn_tooltipText);
  copyBtn.addSelectionListener(new SelectionAdapter() {
   @Override
   public void widgetSelected(SelectionEvent e) {
    handleCutCopy();
    styledText.copy();
   }
  });

  pasteBtn = new ToolItem(toolBar, SWT.PUSH);
  pasteBtn.setEnabled(false);
  pasteBtn.setImage(RichTextImages.IMG_PASTE);
  pasteBtn.setToolTipText(RichTextStrings.pasteBtn_tooltipText);
  pasteBtn.addSelectionListener(new SelectionAdapter() {
   @Override
   public void widgetSelected(SelectionEvent e) {
    styledText.paste();
   }
  });

  new ToolItem(toolBar, SWT.SEPARATOR);

  eraserBtn = new ToolItem(toolBar, SWT.PUSH);
  eraserBtn.setEnabled(false);
  eraserBtn.setImage(RichTextImages.IMG_ERASER);
  eraserBtn.setToolTipText(RichTextStrings.eraserBtn_tooltipText);
  eraserBtn.addSelectionListener(new SelectionAdapter() {
   @Override
   public void widgetSelected(SelectionEvent e) {
    clearStylesFromSelection();
   }
  });

  return toolBar;
 }

 private List translateStyle(StyleRange range) {
  List list = new ArrayList();

  if ((range.fontStyle & SWT.BOLD) != 0) {
   list.add(FontStyle.BOLD);
  }
  if ((range.fontStyle & SWT.ITALIC) != 0) {
   list.add(FontStyle.ITALIC);
  }
  if (range.strikeout) {
   list.add(FontStyle.STRIKE_THROUGH);
  }
  if (range.underline) {
   list.add(FontStyle.UNDERLINE);
  }

  return list;
 }

 private class FontStyleButtonListener extends SelectionAdapter {
  private FontStyle style;

  public FontStyleButtonListener(FontStyle style) {
   this.style = style;
  }

  @Override
  public void widgetSelected(SelectionEvent e) {
   applyFontStyleToSelection(style);
  }
 }

}
