package sockets;

import java.net.*;
import java.io.*;


public class TCPServer {

    public static void main(String[] args) throws Exception {
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;

        DatosMeteorologicos listaDatos[] = new DatosMeteorologicos[5];

        listaDatos[0] = new DatosMeteorologicos(1, "Emboscada", 40, 20, 70, "2022-9-18", "22:00");
        listaDatos[1] = new DatosMeteorologicos(2, "Coronel Oviedo", 40, 20, 70, "2022-9-18", "22:00");
        listaDatos[2] = new DatosMeteorologicos(3, "Ciudad del Este", 40, 20, 70, "2022-9-18", "22:00");
        listaDatos[3] = new DatosMeteorologicos(4, "Limpio", 40, 20, 70, "2022-9-18", "22:00");
        listaDatos[4] = new DatosMeteorologicos(5, "Villarrica", 40, 20, 70, "2022-9-18", "22:00");


        try {
            servidor = new ServerSocket(5000);
            System.out.println("Servidor iniciado");

            while(true){
                sc = servidor.accept();
                System.out.println("Cliente conectado");

                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                
                out.writeUTF("Hola desde el servidor\nIngrese 1 para obtener datos meteorológicos de su estación.\nIngrese 2 para consultar la temperatura de una ciudad específica.\nIngrese cualquier otro número para desconectar.\n(Si envía un tipo de dato no numérico se arrojará una excepción no controlada)\nOpción: ");
                
                String opcion = in.readUTF();
                System.out.println("Se ha recibido: "+opcion);
                int opcionNum = Integer.parseInt(opcion);
                if (opcionNum == 1){
                    String id_estacion = in.readUTF();
                    Integer id_estacionNum = Integer.parseInt(id_estacion)-1;
                    out.writeUTF(
                        "Ciudad: "+listaDatos[id_estacionNum].ciudad +
                        "\nTemperatura: "+listaDatos[id_estacionNum].temperatura +
                        "\nPorcentaje de humedad: "+listaDatos[id_estacionNum].porcentaje_humedad+"%" +
                        "\nVelocidad viento: "+listaDatos[id_estacionNum].velocidad_viento+" km/h" +
                        "\nFecha: "+listaDatos[id_estacionNum].fecha +
                        "\nHora: "+listaDatos[id_estacionNum].hora 
                    );
                }
                if (opcionNum == 2){
                    out.writeUTF("Ingrese el nombre de la ciudad de la cual desea obtener datos:");
                    String ciudad = in.readUTF().toLowerCase();
                    boolean encontrado = false;
                    int i;
                    for (i=0; i<listaDatos.length; i++){
                        String c = listaDatos[i].ciudad.toLowerCase();
                        if (ciudad.equals(c)){
                            encontrado = true;
                            break;
                        }
                    }
                    if (encontrado){
                        out.writeUTF("La temperatura de "+listaDatos[i].ciudad+" es: "+listaDatos[i].temperatura+".");
                    }
                    else {
                        out.writeUTF("No se ha encontrado registro de esta ciudad.");
                    }
                }
                sc.close();
                System.out.println("Cliente desconectado");
            }
        }
        catch (IOException ex) {
            System.out.println(ex);
        }

        
    }
}
