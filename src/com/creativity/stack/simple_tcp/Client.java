package com.creativity.stack.simple_tcp;

import java.io.*;
import java.net.Socket;

public class Client {

    public Client() throws IOException {
        Socket socket = new Socket("localhost",2021);
        System.out.println("Conexion exitosa en el server.");

        // I/O Buffer
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

        String message = in_socket.readLine();
        System.out.println("Server dice: " + message);
        out_socket.println("Gracias!");

        out_socket.close();
        System.out.println("Socket esta cerrado.");
    }

    public static void main(String[] args) {
        try {
            new Client();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
