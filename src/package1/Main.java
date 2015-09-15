package package1;

import java.io.*;
import java.net.Socket;

/**
 * Created by admin on 15.09.2015.
 */
public class Main
{
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.244.1", 5050);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
        PrintStream writer = new PrintStream(os, true);

        while(true)
        {
            String input = consoleReader.readLine();
            writer.println(input);
            writer.flush();

            String output = reader.readLine();
            System.out.println(output);

            System.out.println("inp" + input);
            System.out.println("out" + output);

            if("exit".equals(input))
            {
                break;
            }
        }
//        os.write("hello".getBytes());
//        os.flush();
//        os.close();
        socket.close();

    }
}
