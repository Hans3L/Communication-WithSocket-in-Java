package com.creativity.stack.simple_tcp_multithread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {

    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Cliente tiene conexion.");

            //I/O buffers
            BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);

            out_socket.println("Bienvenido! Cual es tu nombre? ");  //enviando Bienvenido al cliente
            String message = in_socket.readLine();  //recibe "Gracias!"
            System.out.println("Cliente dice: " + message); //mostrando al cliente mensaje en consola

            socket.close();
            System.out.println("Socket se ha cerrado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
