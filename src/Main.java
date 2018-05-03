/*
* @author: Marvin Laubenstein
* */


import java.io.IOException;
import java.net.URL;


public class Main {

    private static final  String USER_AGENT ="Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/604.4.7 (KHTML, like Gecko) Version/11.0.2 Safari/604.4.7";

    private static final String ANSI_RED     = "\u001B[31m";
    private static final String ANSI_GREEN   = "\u001B[32m";
    private static final String ANSI_YELLOW  = "\u001B[33m";
    private static final String ANSI_RESET   = "\u001B[ 0m";
    private static final String ANSI_BLUE    = "\u001B[34m";

    public static void main (String [] args ) throws IOException {

        String urlString;
        URL url;
        URLConnectionReader urlConnectionReader;
        GETRequest getRequest;
        POSTRequest postRequest;
        DELETERequest deleteRequest;
        boolean loop = true;

        urlString = "http://localhost:3000/posts";
        url = new URL (urlString);


        //print some information about the URL
        System.out.println ( " Host = " + url.getHost () + "\n\n" + //Gets the host name of this URL, if applicable.
                " Authority = " + url.getAuthority () + "\n\n" +//Gets the authority part of this URL.
                " File = " + url.getFile () + "\n\n" +//Gets the file name of this URL.
                " String = " + url.toString () + "\n\n" +//Constructs a string representation of this URL.
                " UserInfo = " + url.getUserInfo () + "\n\n" +
                " Content = " + url.getContent () );


        while (loop == true) {
            switch (Cases.chooseAction ()) {

                case 1:

                    // print information regarding the headers and cookies of the URL
                    System.out.println ( "\n\n\n" + ANSI_GREEN + "Testing 0 - Read URL Connection information" + ANSI_RESET );
                    urlConnectionReader = new URLConnectionReader ();
                    urlConnectionReader.read ( USER_AGENT, urlString );
                    break;


                case 2:

                    // print result of an execute a Http GET request on a URL
                    System.out.println ( "\n\n\n" + ANSI_YELLOW + "Testing 1 - Send Http GET request" + ANSI_RESET );
                    getRequest = new GETRequest ();
                    getRequest.sendGET ( USER_AGENT, urlString, IDScanner.scan () );
                    break;

                case 3:

                    // print out the URL information after a Http POST request
                    System.out.println ( "\n\n\n" + ANSI_RED + "Testing 2 - Send Http POST request" + ANSI_RESET );
                    postRequest = new POSTRequest ();
                    postRequest.sendPOST ( USER_AGENT, urlString, IDScanner.scan () );
                    break;

                case 4:

                    // print out the URL information after a Http DELETE request
                    System.out.println ( "\n\n\n" + ANSI_BLUE + "Testing 3 - Send Http DELETE request" + ANSI_RESET );
                    deleteRequest = new DELETERequest ();
                    deleteRequest.sendDELETE ( USER_AGENT, urlString, IDScanner.scan () );
                    break;

                case 5:
                    loop = false;
                    break;

                    //TODO : Make sure that one class expires after another
            }
        }
    }
}
