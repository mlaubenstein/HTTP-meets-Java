import javax.net.ssl.HttpsURLConnection;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class POSTRequest {

    public boolean finished = false;

    public void sendPOST(String USER_AGENT, String urlString) throws IOException {

        URL url;
        int responseCode;
        HttpURLConnection connection;
        DataOutputStream dataOutputStream;
        StringBuffer responseBuffer;

        //the sun thing is from internet, no changes to failure
        url = new URL(null, urlString, new sun.net.www.protocol.http.Handler() );
        connection = (HttpURLConnection) url.openConnection();

        //run Http POST request and pass the User Agent set in the main class
        connection.setRequestMethod("POST");//
        connection.setRequestProperty("User-Agent", USER_AGENT);
        connection.setRequestProperty("Content-Type", "application/json");

        connection.setDoInput ( true );
        connection.setDoOutput( true );

        //trying to post the Hello World into the stream //TODO fix the failure
        dataOutputStream = new DataOutputStream(connection.getOutputStream()); //IOException needed
        dataOutputStream.writeBytes ( "{\"title\" : \"Neuer post \", \"author\":\"WankWank\" }");
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
        System.out.println(responseBuffer.toString());

        //connection.disconnect ();//Tried
        dataOutputStream.close ();

        //Try to solve that todo in the main
        finished = true;
        finished ();
    }

    public boolean finished (){
        return finished;
    }
}
