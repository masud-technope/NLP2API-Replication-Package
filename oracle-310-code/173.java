import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * ! Here's a block of text to use as input to the regular expression matcher.
 * Note that we'll first extract the block of text by looking for the special
 * delimiters, then process the extracted block. !
 */

public class TheReplacements {
  public static void main(String[] args) throws Exception {
    String s = TextFile.read("TheReplacements.java");
    // Match the specially-commented block of text above:
    Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL)
        .matcher(s);
    if (mInput.find())
      s = mInput.group(1); // Captured by parentheses
    // Replace two or more spaces with a single space:
    s = s.replaceAll(" {2,}", " ");
    // Replace one or more spaces at the beginning of each
    // line with no spaces. Must enable MULTILINE mode:
    s = s.replaceAll("(?m)^ +", "");
    System.out.println(s);
    s = s.replaceFirst("[aeiou]", "(VOWEL1)");
    StringBuffer sbuf = new StringBuffer();
    Pattern p = Pattern.compile("[aeiou]");
    Matcher m = p.matcher(s);
    // Process the find information as you
    // perform the replacements:
    while (m.find())
      m.appendReplacement(sbuf, m.group().toUpperCase());
    // Put in the remainder of the text:
    m.appendTail(sbuf);
    System.out.println(sbuf);

  }
} ///:~

class TextFile extends ArrayList {
  // Tools to read and write files as single strings:
  public static String read(String fileName) throws IOException {
    StringBuffer sb = new StringBuffer();
    BufferedReader in = new BufferedReader(new FileReader(fileName));
    String s;
    while ((s = in.readLine()) != null) {
      sb.append(s);
      sb.append("\n");
    }
    in.close();
    return sb.toString();
  }

  public static void write(String fileName, String text) throws IOException {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
        fileName)));
    out.print(text);
    out.close();
  }

  public TextFile(String fileName) throws IOException {
    super(Arrays.asList(read(fileName).split("\n")));
  }

  public void write(String fileName) throws IOException {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
        fileName)));
    for (int i = 0; i < size(); i++)
      out.println(get(i));
    out.close();
  }

  // Simple test:
  public static void main(String[] args) throws Exception {
    String file = read("TextFile.java");
    write("test.txt", file);
    TextFile text = new TextFile("test.txt");
    text.write("test2.txt");
  }
} ///:~
