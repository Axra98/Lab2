public class CarApp {
    /**
     * Mainmetoden. Startar programmet
     * @param args
     */
    public static void main(String[] args) {

        CarController cc = new CarController();

        cc.model.cars.add(new Volvo240());
        cc.model.cars.add(new Saab95());
        cc.model.cars.add(new Scania());

        CarView frame = new CarView("CarSim 1.0", cc);

        cc.timer.start();
    }
}
