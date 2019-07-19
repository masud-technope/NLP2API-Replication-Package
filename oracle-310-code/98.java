import javax.media.*;
import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.awt.event.*;
import javax.swing.event.*;

public class JMFTest extends JFrame {

    JMFTest() {
        Player _player;    
        addWindowListener( new WindowAdapter() {
            public void windowClosing( WindowEvent e ) {
                _player.stop();
                _player.deallocate();
                _player.close();
                System.exit( 0 );
            }
        });
        setExtent( 0, 0, 320, 260 );
        JPanel panel = (JPanel)getContentPane();
        panel.setLayout( new BorderLayout() );
        String mediaFile = "vfw://1";
        try {
            MediaLocator mlr = new MediaLocator( mediaFile );
            _player = Manager.createRealizedPlayer( mlr );
            if (_player.getVisualComponent() != null)
            panel.add("Center", _player.getVisualComponent());
            if (_player.getControlPanelComponent() != null)
            panel.add("South", _player.getControlPanelComponent());
        }
        catch (Exception e) {
            System.err.println( "Got exception " + e );
        }
    }

    public static void main(String[] args) {
        JMFTest jmfTest = new JMFTest();
        jmfTest.show();
    }
}