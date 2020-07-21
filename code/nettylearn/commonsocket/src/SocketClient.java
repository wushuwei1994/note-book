import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by wushuwei on 2020/5/14.
 * 描述：
 */
public class SocketClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 8080);
        OutputStream outputStream = socket.getOutputStream();
        while (true) {
            outputStream.write("hello".getBytes());
            Thread.sleep(5000);
        }


    }
}
