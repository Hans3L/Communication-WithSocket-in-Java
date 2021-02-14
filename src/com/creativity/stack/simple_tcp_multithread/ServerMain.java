package com.creativity.stack.simple_tcp_multithread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    public ServerMain() throws IOException {
        ServerSocket serverSocket = new ServerSocket(2020);
        System.out.println("Puerto 2020 esta abierto");

        //infinito while loop: espere para nueva conexion
        while (true) {
            Socket socket = serverSocket.accept();
            ServerThread serverThread = new ServerThread(socket);
            Thread thread = new Thread(serverThread);
            thread.start();
        }
    }

    public static void main(String[] args) {
        try {
            new ServerMain();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
