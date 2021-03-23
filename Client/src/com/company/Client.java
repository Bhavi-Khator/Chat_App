package Client.src.com.company;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 11000);

        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Client created.");
        System.out.println("Enter name of client.");
        String name = null;
        try {
            name = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ReceiveMsg receiveMsg = new ReceiveMsg(socket);
            Thread thread=new Thread(receiveMsg);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(name);
            while (true){
                String message;
                System.out.println("/n Enter your message");
                message=bufferedReader.readLine();
                String to;
                System.out.println("/n Whom to send");
                to =bufferedReader.readLine();
                Message sendMsg =new Message(message,name,to);
                outputStream.writeObject(sendMsg);
                outputStream.flush();
            }

        } catch (IOException e){
            e.printStackTrace();
        }


    }
}

