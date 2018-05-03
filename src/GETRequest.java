import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class GETRequest {

    public boolean finished = false;

    public void sendGET(String USER_AGENT, String urlString) throws IOException {

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();//make sure it's HTTP and not https
        int responseCode;
        StringBuffer responseBuffer;


        //Run Http Get request and pass the User Agent set in the main class
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", USER_AGENT);
        //connection.setDoInput ( true );

        //print response code of the connection
        responseCode = connection.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : "  + url);
        System.out.println("\nResponse Code : "                 + responseCode);

        //reading out the input stream
        responseBuffer = GetInputStreamResponseBuffer.getInputStream ( connection );

        //print result string got the method getInputStream
        System.out.println(responseBuffer.toString());
        //connection.disconnect ();//tried
        //TODO : make output readable, by line break, after every comma

        //Try to solve that todo in the main
        finished = true;
        finished ();
    }

    public boolean finished (){
        return finished;
    }

}
