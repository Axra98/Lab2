import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.io.IOException;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());



    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);


        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void driveCar(Vehicle car) {
            car.move();
            int x = (int) Math.round(car.getPos().getX());
            int y = (int) Math.round(car.getPos().getY());
            frame.drawPanel.moveit(x, y, car);
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();
        }

        public void turnCar(Vehicle car, Vehicle.Direction dir) {
            //car.stopEngine();
            car.setDirection(dir);
            //car.startEngine();
            driveCar(car);
        }

        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                if(car.getPos().getX() <= frame.getWidth()- 125 && car.getPos().getX() >= 0) {
                    driveCar(car);
                }
                else if(car.getPos().getX() >= frame.getWidth() - 125){
                    turnCar(car, Vehicle.Direction.LEFT);
                }
                else if(car.getPos().getX() <= 0){
                    turnCar(car, Vehicle.Direction.RIGHT);
                }
            }
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