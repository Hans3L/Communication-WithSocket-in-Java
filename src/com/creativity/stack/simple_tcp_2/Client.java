package com.creativity.stack.simple_tcp_2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public Client() throws IOException {
        Socket socket = new Socket("localhost",2020);
        System.out.println("Conexion exitosa en el server.");

        // I/O Buffer
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

        Scanner keyboard = new Scanner(System.in);

        String message = in_socket.readLine();
        System.out.println("Server dice: " + message);
        System.out.println("Dile algo al Servidor: ");
        message = keyboard.nextLine();  //Se solicita al usuario que escriba un mensaje para el servidor
        out_socket.println(message);

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
