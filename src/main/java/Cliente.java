import java.io.*;
import java.net.*;


// Cliente


public class Cliente {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite seu nome:");
        String name = reader.readLine();
        out.writeUTF(name);

        System.out.println("Escolha: pedra, papel ou tesoura");
        String choice = reader.readLine();
        out.writeUTF(choice);

        String result = in.readUTF();
        System.out.println(result);

        socket.close();
    }
}