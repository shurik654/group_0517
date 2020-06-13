import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket socket;
        DataOutputStream out;
        DataInputStream in;
        Scanner scanner;
        try{
            socket = new Socket("localhost",8189);
            in = new DataInputStream(socket.getInputStream());
            out= new DataOutputStream(socket.getOutputStream());
            scanner = new Scanner(System.in);
            System.out.print("Enter your name: ");
            String username = scanner.nextLine();
            out.writeUTF(username);
            Thread sendThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            String clientText = scanner.nextLine();
                            out.writeUTF(username+": "+clientText);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            Thread responseThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            String strFromSerer = in.readUTF();
                            System.out.println(strFromSerer);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            sendThread.start();
            responseThread.start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
