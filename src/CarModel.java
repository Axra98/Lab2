import java.util.ArrayList;
import java.util.List;

public class CarModel implements ICar {
    List<Vehicle> cars = new ArrayList<>();
    List<Observer> observers = new ArrayList<>();
    List<RemoveObserver> removeObservers = new ArrayList<>();

    public void addObservers(Observer obs) {
        observers.add(obs);
    }

    public void addObservers2(RemoveObserver obs2) {
        removeObservers.add(obs2);
    }

    public void notifyObservers2() {
        for (RemoveObserver o2 : removeObservers) {
            o2.removeOnUpdate();
        }
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.actOnUpdate();
        }
    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            if (car.getCurrentSpeed() >= 0.1) {
                car.gas(gas);
            }
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount / 100);
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }

    public void addCar() {
        if (cars.size() < 10) {
            Vehicle car = new Volvo240();
            cars.add(car);
        }
        notifyObservers();
    }

    public void removeCar() {
        notifyObservers2();
    }

    public String updateSpeed() {
        if (cars != null) {
            String str = Double.toString(cars.get(0).getCurrentSpeed());
            String name = cars.get(0).getmodelName();
            return name + ": " + str + " km/h";
        }
        return "0";
    }

    public void setTurboOff() {
        for (Vehicle car : cars) {
            if (car instanceof ITurbo)
                ((Saab95) car).setTurboOff();
        }
    }

    public void setTurboOn() {
        for (Vehicle car : cars) {
            if (car instanceof ITurbo)
                ((Saab95) car).setTurboOn();
        }
    }

    public void rampUp() {
        for (Vehicle car : cars) {
            if (car instanceof IRamp) {
                ((Scania) car).rampUp(30);
            }
        }
    }

    public void rampDown() {
        for (Vehicle car : cars) {
            if (car instanceof IRamp) {
                ((Scania) car).rampDown(30);
            }
        }
    }

    public void checkCar() {
        for (Vehicle car : cars) {
            if (car.getPos().getX() <= 675 && car.getPos().getX() >= 0) {
                driveCar(car);
            } else if (car.getPos().getX() >= 675) {
                turnCar(car, Vehicle.Direction.LEFT);
            } else if (car.getPos().getX() <= 0) {
                turnCar(car, Vehicle.Direction.RIGHT);
            }
        }
    }

    public void driveCar(Vehicle car) {
        car.move();
        int x = (int) Math.round(car.getPos().getX());
        int y = (int) Math.round(car.getPos().getY());
        moveit(x, y, car);
    }

    public void turnCar(Vehicle car, Vehicle.Direction dir) {
        car.setDirection(dir);
        driveCar(car);
    }

    public void moveit(int x, int y, Vehicle car) {
        car.getPos().setLocation(x, y);
        notifyObservers();
    }

    public void stopEngine() {
        for (Vehicle car : cars)
            car.stopEngine();
    }

    public void startEngine() {
        for (Vehicle car : cars)
            car.startEngine();
    }
}