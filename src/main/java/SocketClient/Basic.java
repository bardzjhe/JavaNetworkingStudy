package SocketClient;

import javafx.scene.input.DataFormat;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * @Author Anthony Z.
 * @Date 9/8/2022
 * @Description:
 */
public class Basic {
    public static void main(String[] args) {
        Socket socket = null;
        try{
            socket = new Socket("time.nist.gov", 13);
            // set timeout is optional but highly recommended.
            socket.setSoTimeout(15000); // Timeouts are measured in milliseconds.

            // Once you have opened the socket and
            // set its timeout, call getInputStream()
            // to return an InputStream you can use to
            // read bytes from the socket.
            InputStream in = socket.getInputStream();
            StringBuilder stringBuilder = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(in, "ASCII");
            for(int c = reader.read(); c != -1; c = reader.read()){
                stringBuilder.append((char)c);
            }
            System.out.println(stringBuilder);
//            System.out.println(parseDate);

        }catch (IOException e){
            System.err.println(e);
        }finally {
            try{
                socket.close();
            }catch (Exception e){

            }
        }

    }

//    static Date parseDate(String s) throws ParseException{
//        String[] pieces = s.split(" ");
//        String dataTime = pieces[1] + " " + pieces[2] + "UTC";
//        DataFormat format = new SimpleDateFormat("yy-MM-dd hh:mm:ss z");
//        return format
//    }
}