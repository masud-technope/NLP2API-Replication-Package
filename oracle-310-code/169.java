import java.net.URL;

  import jjv.net.HttpObjectChannel;
  import jjv.net.HttpObjectRequest;
  import jjv.net.HttpVarg;

  // JVHttpObjectChannelTester
  public class JVHttpObjectChannelTester implements Runnable {

     /* constants */
     public static final String    COMMAND_NAME  = new String("JVHttpObjectChannelTester");
     public static final String    COMMAND_DESC  = new String("Web Tunneling Application Tester");
     public static final String    COMMAND_VER   = new String("1.0");
     public static final String    COMMAND_CR    = new String("Copyright (c) 2000 by JV - All Rights Reserved");

     /* globals */
     protected boolean  _trace;
     protected String   _url;

     // utilities
     private void TRACE(String msg) { if (_trace) System.out.println("TRACE JVHttpObjectChannelTester " + msg); }
     private void ERROR(String msg) { System.out.println("ERROR JVHttpObjectChannelTester " + msg); }

     // Main
     public static final void main(String args[]) { new JVHttpObjectChannelTester(args); }

     // Constructor
     public JVHttpObjectChannelTester(String args[]) {

         /* init */
         _trace = false;
         _url = "http://host:port/servlets/MyChannelServlet";

         /* try */
         try {
             int  i;

             /* scan */
             i = 0;
             while (true) {
               char  c;

               /* set */
               c = args[i].charAt(0);
               /* check */
               if ((c == '/') || (c == '-'))
                 c = args[i].charAt(1);

               /* check */
               switch(c) {
                 case 'v': /* version */
                     System.out.println(COMMAND_NAME + " : " + COMMAND_DESC + " - Version : " + COMMAND_VER);
                     System.out.println(COMMAND_CR);
                     exit(0);

                 case 'T': /* trace */
                     _trace = true;
                     break;

                 case '?': /* bad option */
                     this.usage();
                     exit(1);
               }

               /* next */
               i++;
             }
         } catch(ArrayIndexOutOfBoundsException excp) {;};

         /* check */
         if (this.init() < 0) {
             ERROR("Cannot init...");
             exit(1);
         }

         /* run */
         this.run();
     }

     // Usage
     public void usage() {
         System.out.println("Usage: " + COMMAND_NAME + " [-v] [-T]");
         System.out.println("Where:");
         System.out.println("\t-v\tprint command version");
         System.out.println("\t-T\ttrace");
         return;
     }

     // Init
     public int init() { return(0); }

     // Run
     public void run() {
         String              url;
         HttpObjectChannel   channel;
         HttpObjectRequest   request;
         HttpVarg            varg;
         Object              response;

        /* check */
        if ((url = _url) == null) {
            ERROR("run: Invalid URL, _url='" + _url + "'");
            usage();
            exit(1);
        }

        /* try */
        try {
            channel = new HttpObjectChannel(this, new URL(url));
       } catch(Exception excp) {
            channel = null;
           ERROR("run: Exception caught while creating channel, excp='" + excp + "'");
            excp.printStackTrace();
           exit(1);
        }

        /* create */
        request = channel.createRequest();
        /* set */
        varg = new HttpVarg();
        varg.set("var1", "val1");
        varg.set("var2", "val2");
        varg.set("var3", "val3");

        /* check */
        if ((response = request.exec(varg)) == null) {
            ERROR("run: Cannot exec request");
            exit(1);
        }

        /* */
        TRACE("The Response is '" + response + "'");

        /* exit */
        exit(0);
    }

    // Exit
    public void exit(int code) { System.exit(code); }
}