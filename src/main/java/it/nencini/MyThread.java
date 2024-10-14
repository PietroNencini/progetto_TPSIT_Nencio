package it.nencini;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyThread extends Thread{

    private static int thread_count = 0;
    private Socket s;

    public MyThread(Socket s) {
        thread_count++;
        System.out.println("Thread - " + thread_count + " - creato");
        this.s = s;
    }

    public void run() {                 // Metodo run() contiene il codice asoncrono di questo thread
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
            DataOutputStream out = new DataOutputStream(this.s.getOutputStream());

            String received_data;
            while(!((received_data = in.readLine()).equals("!"))) {
                
                System.out.println("Messaggio ricevuto: " + received_data);
                String upperString = received_data.toUpperCase();
                out.writeBytes(upperString + '\n');
                System.out.println("** AGGIORNATO E INVIATO LA STRINGA MODIFICATA**");
            
            }
        } catch (IOException e) {
            System.out.println("ERRORE NELLA COMUNICAZIONE");
        }
    }


}
