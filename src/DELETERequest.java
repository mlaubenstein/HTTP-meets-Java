import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class DELETERequest {

    public void sendDELETE(String USER_AGENT, String urlString, String ID) throws IOException {


        URL url = new URL ( urlString + "/" + ID );
        int responseCode;
        StringBuffer responseBuffer;

        HttpURLConnection connection = (HttpURLConnection)url.openConnection ();


        try {
            connection.setRequestMethod ( "DELETE" );
            connection.setRequestProperty ( "UserAgent", USER_AGENT );

        }catch (IOException e){
            //TODO
        }

        responseCode = connection.getResponseCode ();
        System.out.println("\nSending 'DELETE' request to URL : "  + url);
        System.out.println("\nResponse Code : "                 + responseCode);

        responseBuffer = GetInputStreamResponseBuffer.getInputStream ( connection );
        System.out.println ( responseBuffer.toString () );






    }
}
