import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class GetInputStreamResponseBuffer {

    public static StringBuffer getInputStream(HttpURLConnection connection) throws IOException {

        StringBuffer responseBuffer;
        BufferedReader inBufferedReader;
        String inputLine;

        inBufferedReader = new BufferedReader ( new InputStreamReader (connection.getInputStream()));
        //System.out.println ( "inBufferedReader : " + inBufferedReader );
        responseBuffer = new StringBuffer();
        //System.out.println ( "responseBuffer : " + responseBuffer );

        //writing inBufferReader line by line into the responseBuffer
        while ((inputLine = inBufferedReader.readLine()) != null) {
            responseBuffer.append(inputLine);
        }
        inBufferedReader.close();

        return responseBuffer;

    }
}
