import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static ArrayList<Socket> clients= new ArrayList<>();
    public static void main(String[] args) {
        Socket socket = null;
        try{
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Server is running");
            while(true) {
                socket = serverSocket.accept();
                clients.add(socket);
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String username = in.readUTF();
                            System.out.println("Joined "+username);
                            out.writeUTF("Joined "+username);
                            while (true) {
                                String str =in.readUTF();
                                broadcastMsg(str);
                                System.out.println(str);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void broadcastMsg(String str) throws IOException {
        DataOutputStream out;
        for (Socket socket: clients){
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(str);
        }
    }
}
