import java.util.Scanner;

/**
 * Main class used to connect between Car class and it utility class
 * 
 * @see Car
 * @see CarUtil
 * @author Mohammad Rahimi Bin Zamri
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        CarUtil cuInterface = new CarUtil();
        cuInterface.mainLoop(true, scan);
    }

}