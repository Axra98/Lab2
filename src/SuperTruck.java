import java.awt.*;

public abstract class SuperTruck extends Vehicle {
    // private Vehicle parent = new Vehicle();
    private Vehicle.Direction direction = Vehicle.Direction.UP;


    protected SuperTruck(int nrDoors, double enginePower, Color color, String modelName, Point.Double position, Double length) {
        super.nrDoors = nrDoors;
        super.enginePower = enginePower;
        super.color = color;
        super.modelName = modelName;
        super.position = position;
        super.length = length;

    }
}