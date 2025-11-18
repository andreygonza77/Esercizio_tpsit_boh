package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 3000;
        int pin = 77777;
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Server in ascolto nella porta " + port);
        Socket s = ss.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        boolean success = false;
        do{
            String msg = in.readLine();
            try {
                int pin_inserito = Integer.parseInt(msg);
                if(pin_inserito != pin){
                    out.println("ERROR");
                }
                else success = true;
            } catch (Exception e) {
            }
        }
        while(!success);
        String cmd = in.readLine();
        switch (out) {
            case value:
                
                break;
        
            default:
                break;
        }

    }
}