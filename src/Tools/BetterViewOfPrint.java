package Tools;

import java.io.InputStream;

public class BetterViewOfPrint {

    public static void print(String InputStream){

        for (int i = 0; i<InputStream.length (); i++){
            String SingleSign = String.valueOf ( InputStream.charAt ( i ) );
            if (SingleSign.equals (",") ) {
                System.out.println ( ",");
                System.out.print( "\t" );
            }
            else if (SingleSign.equals ( "}" )){
                System.out.println (  );
                System.out.println ( "}" );
                i++;
                System.out.println (  );
            }
            else if (SingleSign.equals ( "{" )){
                System.out.println ( "{" );
                System.out.print ( "\t" );
            }
            else {
                System.out.print( SingleSign );
            }
        }
    }
}
