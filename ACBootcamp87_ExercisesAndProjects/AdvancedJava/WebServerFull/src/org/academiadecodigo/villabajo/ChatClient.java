package org.academiadecodigo.villabajo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <Academia de Código_> #87 FLOWribellas
 *
 * Bootcamp Week #7 - Advanced Java - Network and Concurrency
 *
 * Concurrent Web Server with stand-alone Chat Client
 *
 * --> Bugs to fix:
 *      --> while writing a message, if the client receives a message from another client,
 *      the texts will overlap with each other
 *
 */
public class ChatClient {

    private String name;
    private Socket clientSocket;

    public static void main(String[] args) {

        ChatClient client = new ChatClient();

        try {
            BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );

            System.out.println("Enter your username:");
            client.name = input.readLine();
            System.out.println("Write your messages:");

            client.dispatch();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void dispatch() throws IOException {

        clientSocket = new Socket("127.0.0.1", 8080);
        ExecutorService fixedPool = Executors.newFixedThreadPool(4);

        fixedPool.submit(new ChatSender());
        fixedPool.submit(new ChatReceiver());
    }

    private class ChatSender implements Runnable {

        private BufferedReader input;
        private PrintWriter output;

        public ChatSender() throws IOException {
            this.input = new BufferedReader( new InputStreamReader( System.in ) );
            this.output = new PrintWriter( clientSocket.getOutputStream(), true );
        }

        @Override
        public void run() {

            try {
                while( true ) {

                    // Read the message
                    // If it's \quit, get out of the while loop and close connection
                    // Send the message to the server

                    String message = input.readLine();

                    if( message.equals("\\quit") ) {
                        break;
                    }
                    // Send message through Socket output stream
                    output.println(name + ": "+ message);
                }

                // If client disconnects, close all the streams and ends the program
                input.close();
                output.close();
                clientSocket.close();
                System.exit(0);

            } catch (IOException ex) {
                throw new RuntimeException();
            }
        }
    }

    private class ChatReceiver implements Runnable {

        private BufferedReader message;
        public ChatReceiver() throws IOException {
            message = new BufferedReader( new InputStreamReader( clientSocket.getInputStream() ) );
        }
        @Override
        public void run() {
            try {

                while ( !clientSocket.isClosed() ) {

                    if( message.ready() ) {
                        System.out.println(message.readLine());
                    }
                }

            } catch( IOException ex ) {
                throw new RuntimeException();
            }
        }
    }
}
