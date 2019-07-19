import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/*from ww w  .  j  av  a2s. co  m*/
public class MainClass {
  public static void main(String args[]) throws IOException {
    // Write output to a file.
    FileWriter fout = new FileWriter("test.txt");
    fout.write("2 3.4 5 6 7.4 9.1 10.5 done");
    fout.close();

    FileReader fin = new FileReader("Test.txt");

    Scanner src = new Scanner(fin);

    // Read and sum numbers.
    while (src.hasNext()) {
      if (src.hasNextDouble()) {
        System.out.println(src.nextDouble());
      }else{
        break;
      } 
    }
    fin.close();
  }
}
