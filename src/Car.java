import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Car extends Vehicle implements Movable {

    private Vehicle.Direction direction = Vehicle.Direction.UP;
    //private Vehicle parent = new Vehicle();

    public Car(int nrDoors, double enginePower, Color color, String modelName, Point.Double position, double length) {
        super.nrDoors = nrDoors;
        super.enginePower = enginePower;
        super.color = color;
        super.modelName = modelName;
        super.position = position;
        super.length = length;
    }
/*
    protected double getEnginePower() {
        return parent.getEnginePower();
    }

    protected int getNrDoors() {
        return parent.getNrDoors();
    }

    protected double getCurrentSpeed() {
        return parent.getCurrentSpeed();
    }

    protected Color getColor() {
        return parent.getColor();
    }

    protected void setColor(Color clr) {
        parent.setColor(clr);
    }

    protected void startEngine() {
        parent.startEngine();
    }

    protected void stopEngine() {
        parent.stopEngine();
    }

    protected abstract double speedFactor();

    protected void gas(double amount) {
        parent.gas(amount);
    }

    public void brake (double amount){
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

    protected String getmodelName() {
        return parent.getmodelName();
    }

    protected void setCurrentSpeed(double currentSpeed) {
        parent.setCurrentSpeed(currentSpeed);
    }

 */
}
