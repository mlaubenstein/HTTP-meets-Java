import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DELETERequest {

    private String urlString;

    public void sendDELETE(String USER_AGENT, String urlString) throws IOException {

        this.urlString = urlString + "/1";
        URL url = new URL (this.urlString);
        int responseCode;
        StringBuffer responseBuffer;

        HttpURLConnection connection = (HttpURLConnection)url.openConnection ();

        connection.setRequestMethod ( "DELETE" );
        connection.setRequestProperty ( "UserAgent", USER_AGENT );


        responseCode = connection.getResponseCode ();
        System.out.println("\nSending 'DELETE' request to URL : "  + url);
        System.out.println("\nResponse Code : "                 + responseCode);

        responseBuffer = GetInputStreamResponseBuffer.getInputStream ( connection );
        System.out.println ( responseBuffer.toString () );






    }
}
