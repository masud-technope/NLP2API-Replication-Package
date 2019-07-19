package org.kodejava.example.awt;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class TurnNumLockOn {
    public static void main(String[] args) {
        //
        // Gets the default toolkit.
        //
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        //
        // Update the locking state for num lock button to true
        // will turn the num lock on.
        //
        toolkit.setLockingKeyState(KeyEvent.VK_NUM_LOCK, Boolean.TRUE);
    }
}