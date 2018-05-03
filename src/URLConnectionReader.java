import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class URLConnectionReader {

    private boolean finished = false;

    public void read(String USER_AGENT, String urlParsed) throws IOException {

        URL url = new URL ( urlParsed );
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();//make sure it's HTTP and not https
        String headerName;
        String cookie;

        //pass the user agent set in the main class
        connection.setRequestProperty("User-Agent", USER_AGENT);

        //returns the key for the nth header field
        for (int i = 1; (headerName = connection.getHeaderFieldKey(i)) != null; i++) {
            if (headerName.equals("Set-Cookie")) {
                //returns the value for the nth header field which is in this case a cookie
                cookie = connection.getHeaderField(i);
                System.out.println("Cookie ::"  + cookie);
            } else {
                System.out.println("Header : "  + connection.getHeaderField(i));
            }
        }
        System.out.println (  GetInputStreamResponseBuffer.getInputStream ( connection ).toString () );
        //   connection.disconnect ();

        //Try to solve that todo in the main
        finished = true;
        finished ();
    }

    private boolean finished (){
        return finished;
    }
}
