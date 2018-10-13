package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client_Socket {
    private String host;
    private int port;
    private PrintStream pr;
    Socket client;

    public Client_Socket(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            client = new Socket(host, port);
            pr = new PrintStream(client.getOutputStream());
            System.out.println("hello I'm new Client");
        }
        catch (Exception e) {

        }
    }

    public void sendMessage(String text) {
        System.out.println("I'm in sendMessage");
        pr.println(text);
    }
}
