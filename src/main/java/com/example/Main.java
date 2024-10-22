package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {

        System.out.println("client partito");
        Socket s = new Socket("localhost", 3000);
        System.out.println("il client è collegato");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        //

        Scanner scan = new Scanner(System.in); // crela l' input

        System.out.println("cercare di indovinare il numero tra 0 a 99");

        
        do {
            System.out.println("digitare il numero: ");
            String stringNumero = scan.nextLine(); // tentativo
            out.writeBytes(stringNumero + "\n"); // manda il tentativo

            String risultato = in.readLine(); // tra confronto dei numeri //legge
            //System.out.println("risposta: " + risultato); // ?=errore da controllare prima //poiu COMMENTARE
            
            if (risultato.equals("<")){
                System.out.println("Troppo piccolo");

            }else if (risultato.equals(">")){
                System.out.println("Troppo grande");

            }else if(risultato.equals("=")){
                System.out.println("INDOVINATO!");
                break;
            }else if(risultato.equals("?")){
                System.out.println("Il numero inserito non è valido");
            }else{
                System.out.println("ERRORE");
            }
        } while (true);
        String tentativi = in.readLine();
        System.out.println("hai impiegato " + tentativi + " tentativi");

        
        s.close();


    }
}