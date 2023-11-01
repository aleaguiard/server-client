package servidor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import pelicula.GestorPeliculas;

public class SocketServidorHilo {

    public static final int PUERTO = 2018;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("      APLICACIÓN DE SERVIDOR CON HILOS     ");
        System.out.println("-------------------------------------------");
        GestorPeliculas gestorPeliculas = new GestorPeliculas();

        // Inicia un servidor Socket
        try (ServerSocket servidor = new ServerSocket()) {
            InetSocketAddress direccion = new InetSocketAddress(PUERTO);
            servidor.bind(direccion);

            System.out.println("SERVIDOR: Esperando petición en el puerto " + PUERTO);

            while (true) {
                // Espera a que se reciba una petición de un cliente
                Socket socketAlCliente = servidor.accept();
                System.out.println("SERVIDOR: Petición recibida");

                // Crea un nuevo hilo para manejar la comunicación con el cliente
                new ClienteHandler(socketAlCliente, gestorPeliculas);
            }

        } catch (IOException e) {
            System.err.println("SERVIDOR: Error de entrada/salida");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("SERVIDOR: Error");
            e.printStackTrace();
        }
    }
}
