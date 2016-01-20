/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package dp.abs.factory;

import java.util.Scanner;

/**
 *
 * @author mohamed
 */
public class MainPage {

    private static String menuValue = "TOP";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Partial partial = new Partial(generateFromConfig());
    }

    public static MenuBuilder generateFromConfig() {
        //read from user input!
        System.out.println("What to Draw ? #  ");
        Scanner in = new Scanner(System.in);
        menuValue = in.next();
        if (menuValue.equals("TOP")) {
            return new TopMenuBuilder();
        }
        return new LeftMenuBuilder();

    }
}
