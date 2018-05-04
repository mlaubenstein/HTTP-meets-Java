package Tools;

import java.util.Scanner;


public class InformationsScanner{

    public static String scanTitle () {

        System.out.println ( "\nSet a Title : " );
        Scanner scanner = new Scanner ( System.in );
        String TitleReturnValue = scanner.nextLine ();
        return TitleReturnValue;
    }
    public static String scanAuthor () {

        System.out.println ( "\nSet a Author : " );
        Scanner scanner = new Scanner ( System.in );
        String AuthorReturnValue = scanner.nextLine ();
        return AuthorReturnValue;
    }
    public static String scanRandom() {

        System.out.println ( "\nSet a Random Property : " );
        Scanner scanner = new Scanner ( System.in );
        String RandomReturnValue = scanner.nextLine ();
        return RandomReturnValue;
    }
}
