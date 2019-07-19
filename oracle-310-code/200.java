  /*  ww w.  j ava  2s. c o  m*/


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class Main {
  public static void main(String[] argv) throws Exception {
    double data[] = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6 };
    DataOutputStream fout = new DataOutputStream(new DeflaterOutputStream(new FileOutputStream(
        "data.dat")));
    fout.writeInt(data.length);

    for (double d : data)
      fout.writeDouble(d);

    DataInputStream  fin = new DataInputStream(new InflaterInputStream(new FileInputStream(
        "data.dat")));
    int num = fin.readInt();

    double avg = 0.0;
    double d;

    for (int i = 0; i < num; i++) {
      d = fin.readDouble();
      avg += d;
      System.out.print(d + " ");
    }
    fin.close();
    fout.close();
  }
}
