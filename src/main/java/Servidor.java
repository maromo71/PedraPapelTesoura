import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Servidor pronto para receber conexões...");

        while (true) {
            Socket player1Socket = serverSocket.accept();
            DataInputStream in1 = new DataInputStream(player1Socket.getInputStream());
            DataOutputStream out1 = new DataOutputStream(player1Socket.getOutputStream());

            Socket player2Socket = serverSocket.accept();
            DataInputStream in2 = new DataInputStream(player2Socket.getInputStream());
            DataOutputStream out2 = new DataOutputStream(player2Socket.getOutputStream());

            String player1Name = in1.readUTF();
            String player1Choice = in1.readUTF();

            String player2Name = in2.readUTF();
            String player2Choice = in2.readUTF();

            String result = determineWinner(player1Choice, player2Choice);

            out1.writeUTF(result);
            out2.writeUTF(result);

            System.out.println(player1Name + " escolheu: " + player1Choice);
            System.out.println(player2Name + " escolheu: " + player2Choice);
            System.out.println(result);
        }
    }

    public static String determineWinner(String choice1, String choice2) {
        if (choice1.equals(choice2)) return "Empate!";
        if ((choice1.equals("pedra") && choice2.equals("tesoura")) ||
                (choice1.equals("papel") && choice2.equals("pedra")) ||
                (choice1.equals("tesoura") && choice2.equals("papel"))) return "Jogador 1 venceu!";
        return "Jogador 2 venceu!";
    }
}


