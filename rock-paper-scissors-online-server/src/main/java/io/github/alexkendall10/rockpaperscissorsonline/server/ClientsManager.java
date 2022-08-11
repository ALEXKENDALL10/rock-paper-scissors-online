package io.github.alexkendall10.rockpaperscissorsonline.server;

import io.github.alexkendall10.rockpaperscissorsonline.commons.InitialMessage;
import io.github.alexkendall10.rockpaperscissorsonline.commons.WelcomeMessage;
import lombok.extern.java.Log;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Log
public class ClientsManager {

    private ServerSocket serverSocket;

    private ExecutorService executorService;

    public ClientsManager(int port, int rooms) throws IOException {
        serverSocket = new ServerSocket(port);
        executorService = Executors.newFixedThreadPool(rooms);
    }

    public void start() throws IOException, ClassNotFoundException {
        Player player1 = null;
        while (true) {
            Socket socket = serverSocket.accept();
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            InitialMessage initialMessage = (InitialMessage) objectInputStream.readObject();
            WelcomeMessage welcomeMessage = new WelcomeMessage(initialMessage.getPlayerName());
            objectOutputStream.writeObject(welcomeMessage);

            if(player1 == null){
                player1 = new Player(initialMessage.getPlayerName(),socket,objectInputStream,objectOutputStream);
            }else{
                Player player2 = new Player(initialMessage.getPlayerName(),socket,objectInputStream,objectOutputStream);
                RockPaperScissorsGame game1 = new RockPaperScissorsGame(player1,player2,5);
                executorService.execute(game1);
                player1 = null;
                log.info("Two players had been connected");
            }

        }
    }

}
