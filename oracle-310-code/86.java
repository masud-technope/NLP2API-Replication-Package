import java.io.FileReader;
import java.io.StreamTokenizer;

public class Main {
  public static void main(String[] argv) throws Exception {
    FileReader rd = new FileReader("filename.java");
    StreamTokenizer st = new StreamTokenizer(rd);

    st.parseNumbers();
    st.wordChars('_', '_');
    st.eolIsSignificant(true);
    st.ordinaryChars(0, ' ');
    st.slashSlashComments(true);
    st.slashStarComments(true);

    int token = st.nextToken();
    while (token != StreamTokenizer.TT_EOF) {
      token = st.nextToken();
      switch (token) {
      case StreamTokenizer.TT_NUMBER:
        double num = st.nval;
        System.out.println(num);
        break;
      case StreamTokenizer.TT_WORD:
        String word = st.sval;
        System.out.println(word);
        break;
      case '"':
        String dquoteVal = st.sval;
        System.out.println(dquoteVal);
        break;
      case '\'':
        String squoteVal = st.sval;
        System.out.println(squoteVal);
        break;
      case StreamTokenizer.TT_EOL:
        break;
      case StreamTokenizer.TT_EOF:
        break;
      default:
        char ch = (char) st.ttype;
        System.out.println(ch);
        break;
      }
    }
    rd.close();
  }
}