import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketApp {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        Socket clientSocket = serverSocket.accept();

        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();

        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        String line;
        while ((line=bufferedReader.readLine()) != null){
            System.out.println("'" + line +"'");
            if(line.equals("")){
                bufferedWriter.write("HttP/1.1 200 OK\n");
                bufferedWriter.write("\n");
                bufferedWriter.write("Hello, browser");
                break;
            }
        }
        bufferedWriter.close();
        bufferedReader.close();
        serverSocket.close();
    }
}
