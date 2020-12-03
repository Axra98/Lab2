import java.awt.*;
import java.awt.geom.Point2D;

public abstract class SuperTruck extends Vehicle {
    // private Vehicle parent = new Vehicle();
    private Vehicle.Direction direction = Vehicle.Direction.UP;


   protected SuperTruck (int nrDoors, double enginePower, Color color, String modelName, Point.Double position, Double length){
       super.nrDoors = nrDoors;
       super.enginePower = enginePower;
       super.color = color;
       super.modelName = modelName;
       super.position = position;
       super.length = length;

    }
/*
    protected double getCurrentSpeed() {
        return parent.getCurrentSpeed();
    }

    protected void startEngine(){
        parent.startEngine();
    }

    protected void stopEngine(){
        parent.stopEngine();
    }

    protected void gas(double amount) {
        parent.gas(amount);
    }

    protected void brake(double amount){
        parent.brake(amount);
    }

    public void move() {
        parent.move();
    }

    public void turnLeft() {
        parent.turnLeft();
    }

    public void turnRight() {
        parent.turnLeft();
    }

    protected Point2D.Double getPos(){
        return parent.getPos();
    }

    protected Vehicle.Direction getDirection() {
        return parent.getDirection();
    }

    protected void setDirection(Vehicle.Direction direction) {
        parent.setDirection(direction);
    }

    protected void setPosition(Point2D.Double position) {
        parent.setPosition(position);
    }

    protected double getLength() {
        return parent.getLength();
    }

    public String getmodelName() {
        return parent.getmodelName();
    }

 */
}