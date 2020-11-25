import java.awt.*;
import java.awt.geom.Point2D;

public abstract class SuperTruck implements Movable{
    private Vehicle parent = new Vehicle();
    private Vehicle.Direction direction = Vehicle.Direction.UP;


   protected SuperTruck (int nrDoors, double enginePower, Color color, String modelName, Point.Double position, Double length){
       parent.nrDoors = nrDoors;
       parent.enginePower = enginePower;
       parent.color = color;
       parent.modelName = modelName;
       parent.position = position;
       parent.length = length;
    }

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
}