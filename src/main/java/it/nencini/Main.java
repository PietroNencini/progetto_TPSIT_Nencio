package it.nencini;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException{      //? Il mio primo server in Java 
        System.out.println("Benvenuto nel server");

        ServerSocket ss = new ServerSocket(5763);
        Socket socket = ss.accept();

        System.out.println("Qualcuno è entrato nel server");
    }
}