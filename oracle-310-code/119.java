import java.util.Enumeration;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Header;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.URLName;

public class MainClass {

  public static void main(String[] args) throws Exception {
    URLName server = new URLName("protocol://username@host/foldername");

    Session session = Session.getDefaultInstance(new Properties(), new MailAuthenticator());

    Folder folder = session.getFolder(server);
    if (folder != null) {
      folder.open(Folder.READ_ONLY);

      Message[] messages = folder.getMessages();
      for (int i = 0; i < messages.length; i++) {
        System.out.println((i + 1));
        Enumeration headers = messages[i].getAllHeaders();
        while (headers.hasMoreElements()) {
          Header h = (Header) headers.nextElement();
          System.out.println(h.getName() + ": " + h.getValue());
        }
      }
      folder.close(false);
    }
  }
}

class MailAuthenticator extends Authenticator {

  public MailAuthenticator() {
  }

  public PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication("username", "password");
  }
}