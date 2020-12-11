import java.awt.*;

public abstract class Car extends Vehicle {

    private Vehicle.Direction direction = Vehicle.Direction.DOWN;

    public Car(int nrDoors, double enginePower, Color color, String modelName, Point.Double position, double length) {
        super.nrDoors = nrDoors;
        super.enginePower = enginePower;
        super.color = color;
        super.modelName = modelName;
        super.position = position;
        super.length = length;
    }
}
