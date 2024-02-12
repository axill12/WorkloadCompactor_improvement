package Servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server9 {

    public static void main (String args []) {
        try (ServerSocket server = new ServerSocket((6842))) {
            while (true) {
                Socket client = server.accept();
                Worker worker = new Worker(client);
                new Thread(worker).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //The purpose of this class is to do just some calculations. They are meaningless. The purpose is to make processor work.
    public static class Worker implements Runnable {

        private Socket client;

        public Worker (Socket client) {
            this.client = client;
        }

        public void run () {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
                String line;
                line = reader.readLine();
                int timesOfAddition = -1;
                try {
                    timesOfAddition = Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    System.out.println ("The input from client isn't in a form that can be considered integer. This is input;\n" + line);
                }
                double result = 0;
                //It adds timesOfAddition * 10 times 1 to result.
                if (timesOfAddition != -1) {
                    for (int i=0; i<timesOfAddition*5; i++) {
                        result += (1 + Math.abs(Math.cos(i))) / Math.pow(1.0001, i);
                    }
                }
                System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
