package org.kodejava.example.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.lang.Runnable;
import java.lang.Thread;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketExample {
    private ServerSocket server;
    private int port = 7777;

    public ServerSocketExample() {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerSocketExample example = new ServerSocketExample();
        example.handleConnection();
    }

    public void handleConnection() {
        System.out.println("Waiting for client message...");

        //
        // The server do a loop here to accept all connection initiated by the
        // client application.
        //
        while (true) {
            try {
                Socket socket = server.accept();
                new ConnectionHandler(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ConnectionHandler implements Runnable {
    private Socket socket;

    public ConnectionHandler(Socket socket) {
        this.socket = socket;

        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        try
        {
            //
            // Read a message sent by client application
            //
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message Received: " + message);

            //
            // Send a response information to the client application
            //
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("Hi...");

            ois.close();
            oos.close();
            socket.close();

            System.out.println("Waiting for client message...");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package org.kodejava.example.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketExample {
    public static void main(String[] args) {
        try {
            //
            // Create a connection to the server socket on the server application
            //
            InetAddress host = InetAddress.getLocalHost();
            Socket socket = new Socket(host.getHostName(), 7777);

            //
            // Send a message to the client application
            //
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("Hello There...");

            //
            // Read and display the response message sent by server application
            //
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message: " + message);

            ois.close();
            oos.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}