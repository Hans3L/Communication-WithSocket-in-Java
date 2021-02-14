package com.creativity.stack.simple_tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(2020);
        System.out.println("Puerto 2020 es abierto");
        Socket socket = serverSocket.accept();
        System.out.println("Cliente " + socket.getInetAddress() + " se ha conectado.");

        //I/O buffers
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);

        out_socket.println("Bienvenido!");  //enviando Bienvenido al cliente
        String message = in_socket.readLine();  //recibe "Gracias!"
        System.out.println("Cliente dice: " + message); //mostrando al cliente mensaje en consola

        socket.close();
        System.out.println("Socket se ha cerrado.");
    }
    public static void main(String[] args) {
        try {
            new Server();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
