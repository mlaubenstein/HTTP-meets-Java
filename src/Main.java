import java.io.IOException;
import java.net.URL;

public class Main {

    private static final  String USER_AGENT ="Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/604.4.7 (KHTML, like Gecko) Version/11.0.2 Safari/604.4.7";

    public static void main (String [] args ) throws IOException {

        String urlString;
        URL url;
        URLConnectionReader urlConnectionReader;
        GETRequest getRequest;
        POSTRequest postRequest;

        urlString = "http://localhost:3000/posts";
        url = new URL (urlString);

        //print some information about the URL
        System.out.println (    " Host = "        + url.getHost ()        + "\n\n" + //Gets the host name of this URL, if applicable.
                                " Authority = "   + url.getAuthority ()   + "\n\n" +//Gets the authority part of this URL.
                                " File = "        + url.getFile ()        + "\n\n" +//Gets the file name of this URL.
                                " String = "      + url.toString ()       + "\n\n" +//Constructs a string representation of this URL.
                                " UserInfo = "    + url.getUserInfo ()    + "\n\n" +
                                " Content = "     + url.getContent ()             );

        // print information regarding the headers and cookies of the URL
        System.out.println ( "\n\n\nTesting 0 - Read URL Connection information" );
        urlConnectionReader = new URLConnectionReader ();
        urlConnectionReader.read (USER_AGENT, urlString );
        // print result of an execute a Http GET request on a URL
        System.out.println("\n\n\nTesting 1 - Send Http GET request");
        getRequest = new GETRequest ();
        getRequest.sendGET (USER_AGENT, urlString);
        // print out the URL information after a Http POST request
        System.out.println("\n\n\nTesting 2 - Send Http POST request");
        postRequest = new POSTRequest ();
        postRequest.sendPOST(USER_AGENT, urlString);

        //TODO : Make sure that one class expires after another

    }
}
