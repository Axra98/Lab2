public class CarApp {
    /**
     * Mainmetoden. Startar programmet
     * @param args
     */
    public static void main(String[] args) {
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }
}
