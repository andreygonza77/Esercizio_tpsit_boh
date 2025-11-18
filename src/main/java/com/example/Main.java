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
        String zona = "";
        String[] comando = {"", "", ""};
        
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        do{
            String msg = in.readLine();
            try {
                int pin_inserito = Integer.parseInt(msg);
                if(pin_inserito != pin){
                    out.println("ERROR");
                }
            } catch (Exception e) {
                out.println("ERROR");
            }
            String cmd = in.readLine();
        comando = cmd.split(" ", 3);
        switch (comando[1]) {
            case "g":
                if(comando[2].equals("A") || comando[2].equals("B") || comando[2].equals("C") || comando[2].equals("D")){
                    switch (comando[2]) {
                        case "A":
                            if(zona.equals("A"))
                                out.println("OFF");
                            else if(zona.equals("")){
                                out.println("ON");
                                zona = "A";
                            }
                            else{
                                out.println("ALREADY");
                            }
                            break;
                        case "B":
                            if(zona.equals("B"))
                                out.println("OFF");
                            else if(zona.equals("")){
                                out.println("ON");
                                zona = "B";
                            }
                            else{
                                out.println("ALREADY");
                            }
                            break;
                        case "C":
                            if(zona.equals("C"))
                                out.println("OFF");
                            else if(zona.equals("")){
                                out.println("ON");
                                zona = "C";
                            }
                            else{
                                out.println("ALREADY");
                            }
                            break;
                        case "D":
                            if(zona.equals("D"))
                                out.println("OFF");
                            else if(zona.equals("")){
                                out.println("ON");
                                zona = "D";
                            }
                            else{
                                out.println("ALREADY");
                            }
                            break;
                        default:
                            out.println("ERROR");
                            break;
                    }
                }
                else 
                    out.println("ERROR");
                break;
            case "STATUS":
                if(zona.equals("")){
                    out.println("OFF");
                }
                else{
                    out.println("ON ");
                    out.println(zona);
                }
                break;
            case "DIS":
                if(!zona.equals(""))
                    zona = "";
                else{
                    out.println("ERROR");
                }
                break;
            default:
                out.println("ERROR");
                break;
        }
        }
        while(true);
        
    }
}