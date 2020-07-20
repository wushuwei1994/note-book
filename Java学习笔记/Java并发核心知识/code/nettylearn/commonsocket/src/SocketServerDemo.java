import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wushuwei on 2020/5/14.
 * 描述：
 */
public class SocketServerDemo {
    public static void main(String[] args) throws IOException {
        new Server(8080).start();
        System.out.println("服务已启动");
    }
}

class Server{
    private ServerSocket serverSocket;

    public Server(int port) throws  IOException{
        serverSocket = new ServerSocket(port);
    }

    public void start() {
        // 新建线程启动ServerSocket,避免调用此线程方法阻塞
        new Thread(()->{
            doStart();
        }).start();
    }

    private void doStart() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("收到新连接");
                new ClientHandler(socket).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler{
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        new Thread(() -> {
            doStart();
        }).start();
    }

    private void doStart() {
        try {
            InputStream is = this.socket.getInputStream();
            byte[] data = new byte[1024];
            int len;
            while ((len = is.read(data)) != -1) {
                System.out.println(new String(data, 0, len));
                socket.getOutputStream().write("已收到响应".getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
