import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("C:/Users/Компик/Desktop/Обучение/ip.txt");
            FileOutputStream fos= new FileOutputStream("C:/Users/Компик/Desktop/Обучение/good_ip.txt");
            String string = "";
            int i;
            while ((i=fin.read())!=-1){
                string += (char)i;
            }
            String[] lines = string.split("\\n");
            for (i=0; i<lines.length; i++){
                String ip = lines[i].split(":")[0];
                int port  = Integer.parseInt(lines[i].split(":")[1].trim());
                Thread thread = new Thread(new MyRunnableClass()) {
                    @Override
                    public void run() {
                        if (checkProxy(ip,port)){
                            System.out.println(ip+" - Адрес рабочий");
                            byte[] buffer = (ip+":"+port+"\n").getBytes();
                            try {
                                fos.write(buffer);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        else
                            System.out.println(ip+" - Адрес не работает");
                    }
                };
                thread.start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }



    public static boolean checkProxy(String ip, int port){
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
        try {
            URLConnection connection = new URL("https://vozhzhaev.ru/test.php").openConnection(proxy);
            InputStream is = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            char[] buffer = new char[256];
            int rc;
            StringBuilder sb = new StringBuilder();
            while ((rc = reader.read(buffer)) != -1)
                sb.append(buffer, 0, rc);
            reader.close();
            return true;

        }catch (Exception e){
            return false;
        }
    }
}
