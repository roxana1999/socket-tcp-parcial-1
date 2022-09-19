package sockets;


import java.io.*;
import java.net.*;
import java.util.*;

public class TCPClient {

    public static void main(String[] args) throws IOException {
        DataInputStream in;
        DataOutputStream out;
        final String id_estacion = "3";
        
        try{
            Socket sc = new Socket("localhost",5000);
            
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            String mensaje = in.readUTF();
            System.out.print(mensaje); //Hola desde el servidor;
            
            Scanner input= new Scanner(System.in);
            String opcion= input.nextLine();
            out.writeUTF(opcion);
            int opcionNum = Integer.parseInt(opcion);
            if (opcionNum == 1){
                out.writeUTF(id_estacion);
                String datos_estacion = in.readUTF();
                System.out.println(datos_estacion);
            }
            if (opcionNum == 2){
                String indicaciones = in.readUTF();
                System.out.println(indicaciones); 
                String ciudad= input.nextLine();
                out.writeUTF(ciudad);
                String temperatura = in.readUTF();
                System.out.println(temperatura);
            }
            sc.close();
            input.close();
        }
        catch (IOException ex){
            System.out.println(ex);
        }
        
    }
}
