/**
 * Main assignment (and optional) tasks are written here,
 * Assignment requirement are mark with (R) in comment section
 * 
 * @author Mohammad Rahimi Bin Zamri for CDOP3203 Java Programming
 */

public class Car {
    private String model; // (R)
    private String ownerName; // (R)
    private int yearMade; // (R)
    private String carNumber; // (R)
    // additional attributes
    private String manufacturer;
    private int topSpeed;
    private int speed;
    private int mileage;

    ///////////////////// constructors start /////////////////////////////

    /**
     * Car constructor (optional with all params except speed)
     * 
     * @param model
     * @param ownerName
     * @param yearMade
     * @param carNumber
     * @param manufacturer
     * @param topSpeed
     * @param mileage
     * 
     * @return Car instance initialized with all the params, except for speed which
     *         default to 0
     */
    public Car(String model, String ownerName, int yearMade, String carNumber, String manufacturer, int topSpeed,
            int mileage) {
        this.model = model;
        this.ownerName = ownerName;
        this.yearMade = yearMade;
        this.carNumber = carNumber;
        this.manufacturer = manufacturer;
        this.topSpeed = topSpeed;
        this.speed = 0;
        this.mileage = mileage;
    }

    /**
     * (R) requirement
     * 
     * Car constructor, using 'chain constructor' method, which chaining from the
     * main constructor with all the parameters.
     * 
     * I commented out line 62 - 64, the constructor that I use before learning
     * about
     * chain constructor. This is because I don't know if using chain constructor is
     * okay
     * or it will deduct my mark, so I provide the original constructor but
     * commented out.
     * 
     * @param model
     * @param ownerName
     * @param yearMade
     * 
     * @return Car instance initialized with all the params
     */
    public Car(String model, String ownerName, int yearMade) {
        // this.model = model;
        // this.ownerName = ownerName;
        // this.yearMade = yearMade;

        this(model, ownerName, yearMade, "unknown", "unknown", 0, 0);
    }

    /**
     * (R) requirement
     * 
     * 2nd Car constructor
     * 
     * I commented out line 62 - 64, the constructor that I use before learning
     * about
     * chain constructor. This is because I don't know if using chain constructor is
     * okay
     * or it will deduct my mark, so I provide the original constructor but
     * commented out.
     * 
     * @param model
     * @param ownerName
     * @param yearMade
     * @param carNumber
     * 
     * @return Car instance initialized with all the params
     */
    public Car(String model, String ownerName, int yearMade, String carNumber) {
        // this.model = model;
        // this.ownerName = ownerName;
        // this.yearMade = yearMade;
        // this.carNumber = carNumber;

        this(model, ownerName, yearMade, carNumber, "unknown", 0, 0);
    }

    ///////////////////// constructors end /////////////////////////////

    ///////////////////// setter & getter start /////////////////////////////

    /**
     * (R) Requirement : 1. Getter methods for each attribute, 2. setter method for
     * carNumber
     * This section will have setters & getters pair for all class attributes.
     * 
     */

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getYearMade() {
        return yearMade;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarManufacturer() {
        return manufacturer;
    }

    public void setCarManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCarTopSpeed() {
        return this.topSpeed;
    }

    public void setCarTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public int getCarSpeed() {
        return this.speed;
    }

    public void setCarSpeed(int speed) {
        this.speed = speed;
    }

    public int getCarMileage() {
        return this.mileage;
    }

    public void setCarMileage(int mileage) {
        this.mileage = mileage;
    }

    ///////////////////// setter & getter end /////////////////////////////

    ///////////////////// methods start /////////////////////////////

    /**
     * (R) requirement
     * 
     * This method return car details
     * 
     * This method use java util StringBuilder to help combine the string
     * 
     * @see StringBuilder link:
     *      https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html
     * 
     * @return show car details based on their availability
     */
    public String carDetails() {
        StringBuilder sb = new StringBuilder();

        sb.append("Owner Name: ").append(getOwnerName()).append("\n");
        sb.append("Car Model: ").append(getModel()).append("\n");
        sb.append("Car Manufacturer: ").append(getCarManufacturer()).append("\n");
        sb.append("Car Number: ").append(getCarNumber()).append("\n");
        sb.append("Year Made: ").append(getYearMade()).append("\n");
        sb.append("Top Speed: ").append(getCarTopSpeed()).append("\n");

        if (this.localCar()) {
            sb.append("Local Car.").append("\n");
        }

        return sb.toString();
    }

    /**
     * (R) requirement
     * 
     * compare between two cars number
     * 
     * @param Car - another car instance
     * 
     * @return message saying that both car are same or not.
     * 
     */
    public void comparecarNumber(Car othercar) {
        if (getCarNumber().equals(othercar.getCarNumber())) {
            System.out.println(getOwnerName() + " have same car's number with " + othercar.getOwnerName()
                    + ", which is: " + getCarNumber());
        } else {
            System.out.println("Both car have different car number!");
        }
    }

    /**
     * check if car instance is local made, which is proton or perodua
     * 
     * @return boolean value of true if car's manufacturer either proton or produa,
     *         else false
     */
    public boolean localCar() {
        String manufacturer = getCarManufacturer().toLowerCase();
        return manufacturer.equals("proton") || manufacturer.equals("perodua");
    }

    /**
     * check which car is the fastest
     * the reason for static is that we can use it without creating
     * Car instance, use it like this Car.checkFaster(params)
     * 
     * @param varags of Car instances
     * 
     * @return the fastest car alive!!
     */
    public static Car checkFastestCar(Car... cars) {
        // check if cars not 0 or null
        if (cars == null || cars.length == 0) {
            return null;
        }

        // temporary faster car
        Car fastestCar = cars[0];
        for (Car car : cars) {
            if (car.getCarTopSpeed() > fastestCar.getCarTopSpeed()) {
                fastestCar = car;
            }
        }

        // fastest car alive !!!!
        return fastestCar;

    }

    /*
     * helper function for move car, the reason its being private is because it cant
     * be used outside of this class, hence the 'helper' method
     * this method check if the car have achieve the limit mileage and needed to be
     * service
     * 
     * @param nextMileage
     * 
     * @return message showing whether car needed to be service or not.
     */
    public void nextService(int nextMileage) {
        if (this.getCarMileage() >= nextMileage) {
            System.out.println("You current mileage: " + this.getCarMileage() + " have passed the limit of "
                    + nextMileage + ". Please service your car as soon as possible.");
        } else {
            int balance = nextMileage - this.getCarMileage();
            System.out.println("Your current mileage: " + this.getCarMileage() + " still not passed the limit of "
                    + nextMileage + ". There're another " + balance + " to go before next service.");
        }

    }

    /*
     * Car simulation, car will be given a speed and plus 5 for acceleration
     * until achieved top speed, it will brake, which decrease speed
     * until speed zero, this method also will increase the mileage, add 5 per
     * increasing speed
     * 
     * @param initial speed, next mileage
     * 
     * @return void, printing car move from initial speed to top speed,
     * then stopping the car when speed reached zero
     */
    public void moveCar(int initialSpeed, int nextMileage) {
        // check if initialSpeed given more than topspeed
        if (initialSpeed > this.getCarTopSpeed()) {
            System.out.println("Car cannot go faster than " + this.getCarTopSpeed());
            return;
        }

        this.setCarSpeed(initialSpeed);
        System.out.println("Simulation Start..");

        // acceleration
        while (this.getCarSpeed() < this.getCarTopSpeed()) {
            System.out.print("Car is speeding, moving on " + this.getCarSpeed() + "Kmph.           ");
            System.out.println(">".repeat(initialSpeed / 2));
            initialSpeed += 5;
            this.setCarSpeed(initialSpeed);

            // update car mileage everytime we move
            this.setCarMileage(getCarMileage() + 5);

            // add some pause in printing
            // reff:
            // https://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted");
            }
        }

        // decelaration
        while (this.getCarSpeed() >= 0) {
            System.out.print("Car is slowing down, moving on " + this.getCarSpeed() + "Kmph.       ");
            System.out.println("<".repeat(initialSpeed / 2));
            initialSpeed -= 5;
            this.setCarSpeed(initialSpeed);

            // update car mileage everytime we move
            this.setCarMileage(getCarMileage() + 5);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted");
            }
        }

        System.out.println("Car stopped.");
        nextService(nextMileage);
        System.out.println("Simulation End..");
    }

}