package com.creativity.stack.simple_tcp_multithread;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public Client() throws IOException {
        Socket socket = new Socket("127.0.0.1",2020);
        System.out.println("Conexion exitosa al servidor.");

        // I/O stream
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner keyboard = new Scanner(System.in);
        String message = in_socket.readLine();
        System.out.println("Servidor dice: " + message);
        message = keyboard.nextLine();
        out_socket.println(message);

        socket.close();
        System.out.println("Socket Cerrado");
    }
    public static void main(String[] args) {
        try {
            new Client();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
