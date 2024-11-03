import java.util.Scanner;

/**
 * This class manage the functionality (utility) methods for working with cars
 * 
 * @see Car c
 * 
 * @author Mohammad Rahimi Bin Zamri
 */

class CarUtil {

    Car[] carlist;
    Scanner scan;

    public CarUtil() {
        this.carlist = new Car[5];
        this.scan = new Scanner(System.in);
    }

    /**
     * Helper method to show menu in mainloop
     * 
     * @return show menu option for handling car
     */
    private void showMenu() {
        System.out.println("Cars handling");
        System.out.println("1. Register 5 car");
        System.out.println("2. Show the fastest car");
        System.out.println("3. Move car");
        System.out.println("4. Check cars next service date");
        System.out.println("5. Compare between two car number");
        System.out.println("q. Quit");
    }

    /**
     * Helper method to check for terminating program (mainloop)
     * 
     * @param input
     * @return boolean value true or false depend on input
     */
    private boolean stopRun(String input) {
        if (input.equals("q") || (input.equals("Q"))) {
            System.out.println("Terminating program...");
            return false;
        } else {
            System.out.println("\n");
            return true;
        }
    }

    /**
     * Helper method to check whether carList already full
     * 
     * @return true if carList already full, else return false
     */
    private boolean isFull() {
        for (Car car : carlist) {
            if (car == null) {
                System.out.println("You have to register car first before you can use this feature.\n");
                return false;
            }
        }
        return true;
    }

    /**
     * This method help register car by prompting
     * user input for constructor
     * 
     * @return Car object with model, ownerName and yearmade
     */
    private Car registerCar() {
        System.out.println("Enter name");
        String ownerName = scan.nextLine();
        System.out.println("Enter model");
        String model = scan.nextLine();
        System.out.println("Enter year made");
        int yearMade = Integer.valueOf(scan.nextLine());
        // newline to separate between input
        System.out.println("--------------------------");

        return new Car(model, ownerName, yearMade);
    }

    /**
     * This method assign 5 car instances
     * to carList list (since we cannot use ArrayList)
     * 
     * @return updated list with 5 car objects
     */
    private void registerCarInList() {
        for (int i = 0; i < 5; i++) {
            carlist[i] = registerCar();
        }
    }

    /**
     * Helper method to check whether all cars have
     * top speed assigned to them, if cars doesn't have
     * speed, user have to give input regarding their
     * top speed
     * 
     * @return updated all cars top speed, or message saying
     *         that all cars already have top speed assigned to them
     */
    private void checkFaster() {
        boolean allCarsHaveSpeed = true;
        for (Car car : carlist) {
            if (car.getCarTopSpeed() == 0) {
                allCarsHaveSpeed = false;
                System.out.println("Enter top speed for " + car.getModel());
                int carTopSpeed = Integer.valueOf(scan.nextLine());
                car.setCarTopSpeed(carTopSpeed);
            }
        }
        if (allCarsHaveSpeed) {
            System.out.println("All car have top speed !");
        }
    }

    /**
     * this method help to move a car, user will be prompt
     * for car owner name and then we will check for each car whether
     * it have the ownerName equals user input, then make it move
     * 
     * 
     */
    private void makeCarMove() {
        System.out.println("Enter car owner name: ");
        String owner = scan.nextLine();

        for (Car car : carlist) {
            if (car.getOwnerName().equals(owner)) {
                // move car here
                System.out.println("Enter car initial speed: ");
                int initialSpeed = Integer.valueOf(scan.nextLine());
                System.out.println("Enter next mileage: ");
                int nextMileage = Integer.valueOf(scan.nextLine());
                car.moveCar(initialSpeed, nextMileage);
            }
        }
    }

    /**
     * This method can check how many mileage more before
     * car need to service.
     * 
     * User need to input their name (owner name) to get
     * access from carlist array.
     */
    private void checkNextService() {
        System.out.println("Enter car owner name: ");
        String owner = scan.nextLine();

        for (Car car : carlist) {
            if (car.getOwnerName().equals(owner)) {
                if (car.getCarMileage() == 0) {
                    System.out.println("Enter current mileage: ");
                    int mileage = Integer.valueOf(scan.nextLine());
                    car.setCarMileage(mileage);
                }
            } else {
                continue;
            }
            System.out.println("Enter next service mileage: ");
            int nextMileage = Integer.valueOf(scan.nextLine());
            car.nextService(nextMileage);
        }
    }

    /**
     * Helper method to set car number
     */
    private void checkAndAddCarNumber(Car carOne, Car carTwo) {
        if (carOne.getCarNumber().equals("unknown")) {
            System.out.println("Enter car one car's number: ");
            String carNumber = scan.nextLine();
            carOne.setCarNumber(carNumber);
        }
        if (carTwo.getCarNumber().equals("unknown")) {
            System.out.println("Enter car two car's number: ");
            String carNumber = scan.nextLine();
            carTwo.setCarNumber(carNumber);
        }
    }

    /**
     * Compare two car, this is helper method which combined
     * with Car's compareCarNumber() method (Requirement)
     * 
     * Car one will be the main car, and car two will be compare
     * to car one, eg:
     * carOne.compareCarNumber(carTwo);
     * 
     * @see Car's compareCarNumber(Car otherCar) method
     */
    public void compareTwoCar() {
        System.out.println("Enter car one's owner name: ");
        String carOneOwner = scan.nextLine();

        System.out.println("Enter car two's owner name: ");
        String carTwoOwner = scan.nextLine();

        Car carOne = null;
        Car carTwo = null;

        for (Car car : carlist) {
            if (car.getOwnerName().equals(carOneOwner)) {
                carOne = car;
            }
            if (car.getOwnerName().equals(carTwoOwner)) {
                carTwo = car;
            }
            // exit loop if both car found
            if (carOne != null && carTwo != null) {
                break;
            }
        }

        // check if both car were found
        if (carOne == null) {
            System.out.println("Car one owner name not found!");
            return;
        }
        if (carTwo == null) {
            System.out.println("Car two owner name not found!");
            return;
        }
        checkAndAddCarNumber(carOne, carTwo);
        carOne.comparecarNumber(carTwo);
    }

    /**
     * this method act as a main loop to handle all the interaction
     * between Car and it methods
     * 
     * @param run
     * @param scan
     */
    public void mainLoop(boolean run, Scanner scan) {
        while (run) {
            showMenu();
            String userInput = scan.nextLine();
            // handle quit program
            run = stopRun(userInput);
            if (userInput.equals("1")) { // register 5 cars
                if (isFull()) {
                    System.out.println("5 cars already registered!");
                    continue;
                }
                registerCarInList();
            } else if (userInput.equals("2")) { // get the fastest cars in the list
                if (!isFull()) {
                    continue;
                }
                checkFaster();
                // create car instace to use 'static' method
                Car fastCar = Car.checkFastestCar(carlist);
                System.out.println("\nFastest car details: \n" + fastCar.carDetails());
            } else if (userInput.equals("3")) { // move car
                if (!isFull()) {
                    continue;
                } else {
                    checkFaster();
                    makeCarMove();
                }
            } else if (userInput.equals("4")) { // get car next service date
                if (!isFull()) {
                    continue;
                } else {
                    checkNextService();
                }
            } else if (userInput.equals("5")) { // compare between two car
                if (!isFull()) {
                    continue;
                } else {
                    compareTwoCar();
                }

            } else {
                System.out
                        .println("Invalid input,\nChoose 1 - 4 for car related menu,\nOr 'q' to terminate program.\n");
            }

        }

    }

}