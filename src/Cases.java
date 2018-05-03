import java.io.IOException;
import java.util.Scanner;

public class Cases {

    public static int chooseAction () throws IOException {

        int choose = 0;

            do {

                System.out.println ( "\n\n\n" );

                if (choose > 5){

                    System.out.println ( "ERROR !!!\nChoose a shown number!!!" );//TODO : Set Exception
                    Runtime.getRuntime().exec("cls");

                }

                System.out.println ( "What do you want ?" );
                System.out.println ( "\n\n" );
                System.out.println ( "INFORMATIONS  : [1]" );
                System.out.println ( "GET           : [2]" );
                System.out.println ( "POST          : [3]" );
                System.out.println ( "DELETE        : [4]" );
                System.out.println ( "EXIT          : [5]" );

                Scanner scanner = new Scanner ( System.in );

                choose = Integer.parseInt ( scanner.nextLine () );
            }while (choose>5);

            return choose;
    }
}
