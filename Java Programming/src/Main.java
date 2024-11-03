import java.util.Scanner;

/**
 * Main class used to connect between Car class and it utility class
 * 
 * @see Car
 * @see CarUtil
 * @author Mohammad Rahimi Bin Zamri
 */

// main class -> compile all code from Car class and run it here
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        CarUtil cuInterface = new CarUtil();
        cuInterface.mainLoop(true, scan);
    }

}