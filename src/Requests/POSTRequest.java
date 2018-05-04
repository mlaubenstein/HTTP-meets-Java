package Requests;

import Tools.BetterViewOfPrint;
import Tools.GetInputStreamResponseBuffer;
import Tools.InformationsScanner;
import com.sun.xml.internal.bind.v2.TODO;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class POSTRequest {

    private boolean finished = false;

    public void sendPOST(String USER_AGENT, String urlString, String ID) throws IOException {

        URL url;
        int responseCode;
        HttpURLConnection connection;
        DataOutputStream dataOutputStream;
        StringBuffer responseBuffer;
        String author,title,random;

       

        //the sun thing is from internet, no changes to failure
        url = new URL(null, urlString , new sun.net.www.protocol.http.Handler() );
        connection = (HttpURLConnection) url.openConnection();        //Make sure it's HTTP and not https

        try {
            //run Http POST request and pass the User Agent set in the main class
            connection.setRequestMethod ( "POST" );//
            connection.setRequestProperty ( "User-Agent", USER_AGENT );
            connection.setRequestProperty ( "Content-Type", "application/json" );

            connection.setDoInput ( true );
            connection.setDoOutput ( true );
        }catch (IOException e){
            //TODO
        }


        //trying to post the Hello World into the stream //TODO fix the failure
        title  = InformationsScanner.scanTitle  ();
        author = InformationsScanner.scanAuthor ();
        random = InformationsScanner.scanRandom ();
        dataOutputStream = new DataOutputStream(connection.getOutputStream()); //IOException needed
        dataOutputStream.writeBytes ( "{ \"title\":          \"" +title+"\","+
                                        "\"author\":        \"" +author+"\","+
                                        "\"Keine Ahnung\":  \"" +random+"\","+
                                        "\"id\":            " +ID    +"}"
                                      );
        dataOutputStream.flush();
        dataOutputStream.close();

        // reading out the information coming back from the URL
        responseCode = connection.getResponseCode();
        System.out.println( "\nSending 'POST' request to URL : "    + url);
        System.out.println( "\nResponse Code : "                    + responseCode);
        System.out.println ("\nResponse Message : "                 + connection.getResponseMessage () );

        //reading out the input stream
        responseBuffer = GetInputStreamResponseBuffer.getInputStream ( connection );

        //print result
        BetterViewOfPrint.print ( responseBuffer.toString() );
        //TODO : make output readable, by line break, after every comma

        //connection.disconnect ();//Tried
        dataOutputStream.close ();

        //Try to solve that todo in the main
        finished = true;
        finished ();
    }

    private boolean finished(){
        return finished;
    }
}
