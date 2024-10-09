package it.nencini;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.DataOutputStream;

public class Main {

    public static void main(String[] args) throws IOException{      //? Il mio primo server in Java 
        System.out.println("Benvenuto nel server");

        ServerSocket ss = new ServerSocket(5763);
        Socket socket = ss.accept();

        System.out.println("Qualcuno è entrato nel server");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String received_data = in.readLine();
        System.out.println("Messaggio ricevuto: " + received_data);

        String upperString = received_data.toUpperCase();
        out.writeBytes(upperString + '\n');

        System.out.println("** AGGIORNATO E INVIATO LA STRINGA **");

        socket.close();
        ss.close();
    }
}