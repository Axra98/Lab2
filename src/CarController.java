import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CarController implements ICar {

    private final int delay = 50;
    protected Timer timer = new Timer(delay, new TimerListener());
    CarModel model= new CarModel();

    private class TimerListener implements ActionListener {
        public void checkCar() {
            model.checkCar();
        }

        public void actionPerformed(ActionEvent e) {
            checkCar();
        }
    }

    /**
     * Metoden ökar bilens hastighet. Kopplar till en metod i CarModel
     * @param amount en int som påverkar hur mycket bilen gasar
     */
    public void gas(int amount) {
        model.gas(amount);
    }
    public void brake(int amount) {
        model.brake(amount);
    }
    public void startEngine() {
        model.startEngine();
    }
    public void stopEngine() {
        model.stopEngine();
    }
    public void setTurboOn() {
        model.setTurboOn();
    }
    public void setTurboOff() {
        model.setTurboOff();
    }
    public void rampDown() {
        model.rampDown();
    }
    public void rampUp() {
        model.rampUp();
    }
    public String updateSpeed() {
        return model.updateSpeed();
    }
    public void removeCar() {
        model.removeCar();
    }
    public void addCar() {
       model.addCar();
    }
}