import java.applet.Applet;
import java.applet.AppletContext;
import java.net.MalformedURLException;
import java.net.URL;
 
/*
<applet code="LoadNewHTMLFileExample" width=200 height=200>
</applet>
*/
 
 
public class LoadNewHTMLFileExample extends Applet{
 
        public void start(){
               
                //get code base of an Applet using getCodeBase() method
                URL codeBase = getCodeBase();
               
                //get AppletContext using getAppletContext() method
                AppletContext context = getAppletContext();
               
                /*
                 * To load a new HTML file in a browser use
                 * void showDocument(URL url)
                 * method of AppletContext class.
                 *
                 * PLEASE NOTE that the new HTML document must be in the
                 * same directory.
                 */
               
                try{
                       
                        URL url = new URL(codeBase + "AppletContextExample.html");
                        context.showDocument(url);
                       
                }catch(MalformedURLException me){
                        //do nothing
                }
        }
}