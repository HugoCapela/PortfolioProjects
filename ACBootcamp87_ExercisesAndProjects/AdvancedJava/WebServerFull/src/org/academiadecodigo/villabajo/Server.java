package org.academiadecodigo.villabajo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;
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
public class Server {

    private ServerSocket serverSocket;
    public static final int SERVER_PORT = 8080;
    private ExecutorService cachedPool;
    private List<ServerLogic> clientsList = new Vector<>();

    public static void main(String[] args) {

        // Server Initialization
        Server server = new Server();

        try {
            // ServerSocket initialization with SERVER_PORT
            server.serverSocket = new ServerSocket(SERVER_PORT);
            // Cashed Pool initialization
            server.cachedPool = Executors.newCachedThreadPool();

            // Server is always listening
            while(true) {
                //System.out.println("Listening");

                // Process the information from the Client
                server.dispatch(server.serverSocket);
            }

            //server.serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void dispatch(ServerSocket serverSocket) {

        try {
            // Establish the connection with the Client ( .accept() -> 3-Way Handshake )
            Socket clientSocket = serverSocket.accept();

            // Create a new ServerLogic Worker to process my requests
            ServerLogic d1 = new ServerLogic(clientSocket);
            // Add that ServerLogic to my list of clients
            clientsList.add(d1);
            // Send the ServerLogic to my Thread Pool
            cachedPool.submit( d1 );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private class ServerLogic implements Runnable {

        private Socket clientSocket;
        private BufferedReader buffReader;
        private PrintWriter output;
        private String name;
        public ServerLogic(Socket clientSocket) throws IOException {
            this.clientSocket = clientSocket;
            this.buffReader = new BufferedReader( new InputStreamReader( clientSocket.getInputStream() ) );
            this.output = new PrintWriter( clientSocket.getOutputStream(), true );
            this.name = clientSocket.getInetAddress().getHostAddress();
        }

        @Override
        public void run() {

            try {
                while( true ) {

                    // Store input message
                    String message = buffReader.readLine();
                    System.out.println("Message received: " + message);

                    // If message is \quit close the connection
                    if( message.equals("\\quit") ) {
                        /*int index = clientsList.indexOf(this);
                        clientsList.remove(index);*/
                        clientsList.remove(this);
                        break;
                    }

                    // For every input message from a client,
                    // send it to every other connected client
                    // but not himself
                    for( int i = 0; i < clientsList.size(); i++ ) {
                        if( clientsList.get(i) == this ) {
                            continue;
                        }
                        clientsList.get(i).send(message);
                    }
                }

                // Client disconnected: close all streams
                System.out.println("Connection terminated!");
                buffReader.close();
                output.close();
                clientSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        // Method to send a message
        private void send(String message) {
            output.println(message);
        }

    }
}
