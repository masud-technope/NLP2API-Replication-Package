import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

public class Main {

  public static byte[] LoadImage(String filePath) throws Exception {
    File file = new File(filePath);
    int size = (int) file.length();
    byte[] buffer = new byte[size];
    FileInputStream in = new FileInputStream(file);
    in.read(buffer);
    in.close();
    return buffer;
  }

  public static void main(String[] args) throws Exception {
    byte[] imageBytes = LoadImage("C:/Java_Dev/bear.png");
    MongoClient mongo = new MongoClient("127.0.0.1");
    String dbName = "GridFSTestJava";
    DB db = mongo.getDB(dbName);

    GridFS fs = new GridFS(db);
    GridFSInputFile in = fs.createFile(imageBytes);
    in.save();

    GridFSDBFile out = fs.findOne(new BasicDBObject("_id", in.getId()));

    FileOutputStream outputImage = new FileOutputStream("C:/Temp/bearCopy.bmp");
    out.writeTo(outputImage);
    outputImage.close();
  }
}
