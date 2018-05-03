import java.util.Scanner;

public class IDScanner {

    public static String scan (){

        System.out.println ( "\nWhich ID do you refer to? " );
        Scanner scanner = new Scanner ( System.in );
        String scannerString = scanner.nextLine ();
        //int IDReturnValue = Integer.parseInt ( scannerString );

        return scannerString ;
    }
}
