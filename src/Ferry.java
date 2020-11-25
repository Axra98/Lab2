import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayDeque;
import java.util.Deque;


public class Ferry implements Load, Movable{

    private int max;
    private Deque<Car> store;
    private String modelName; // The car model name
    private Vehicle.Direction direction = Vehicle.Direction.UP;
    private Vehicle parent = new Vehicle();


    public Ferry(int max) {
        parent.enginePower = 500;
        parent.color = Color.CYAN;
        parent.modelName = "Färja 1";
        parent.position = new Point2D.Double(0,0);
        parent.length = 80;
        store = new ArrayDeque<>();
        this.max = max;
    }

    /**
     * Loads the chosen car to the ferry
     * @param car which car to load
     */
    public void loadCar(Car car) {
        if(store.size() < max) {
            store.add(car);
        }
    }

    /**
     *  removes the chosen car from the ferry
     * @param car which car to remove
     */
    public void removeCar(Car car) {
        if(store.contains(car) && store.peekFirst().equals(car)){
            switch (getDirection()) {
                case UP:
                    car.setPosition(new Point2D.Double(car.getPos().getX(), car.getPos().getY()-2));
                    break;
                case RIGHT:
                    car.setPosition(new Point2D.Double(car.getPos().getX()-2, car.getPos().getY()));
                    break;
                case DOWN:
                    car.setPosition(new Point2D.Double(car.getPos().getX(), car.getPos().getY()+2));
                    break;
                case LEFT:
                    car.setPosition(new Point2D.Double(car.getPos().getX()+2, car.getPos().getY()));
                    break;
            }
            store.remove(car);
        }
    }

    protected double speedFactor() {
        return parent.getEnginePower();
    }

    protected void startEngine() {
        parent.startEngine();
    }

    protected void stopEngine() {
        parent.stopEngine();
    }

    protected void gas(double amount) {
        parent.gas(amount);
    }

    protected void brake (double amount){
        parent.brake(amount);
    }

    public void move () {
        parent.move();
    }

    public void turnLeft () {
        parent.turnLeft();
    }

    public void turnRight () {
        parent.turnRight();
    }

    protected Point2D.Double getPos () {
        return parent.getPos();
    }
    protected Vehicle.Direction getDirection () {
        return parent.getDirection();
    }

    protected void setDirection (Vehicle.Direction direction){
        parent.setDirection(direction);
    }

    protected void setPosition (Point2D.Double position){
        parent.setPosition(position);
    }

    protected double getLength () {
        return parent.getLength();
    }

    public Deque<Car> getStore() {
        return store;
    }

    public void setStore(Deque<Car> store) {
        this.store = store;
    }
}
