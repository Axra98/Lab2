import java.awt.*;
import java.awt.geom.Point2D;

public class Scania extends SuperTruck {

    private static double angle = 0;

    /**
     * Construktor, apply startvalues to an object of Scania
     */
    public Scania() {
        super(2, 2000, Color.WHITE, "Scania", new Point2D.Double(0, 0), 8.0);
        stopEngine();
    }

    /**
     * Ser till att motorn inte kan startas så länge flaket inte är nere
     */
    @Override
    public void startEngine() {
        if (getAngle() == 0)
            super.startEngine();
    }

    /**
     * @param change the amoaunt you want to push the ramp up
     */
    protected void rampDown(double change){
        if(getCurrentSpeed() == 0 && (angle - change) >=0)
            angle -= change;
    }

    /**
     * @param change the amoaunt you want to push the ramp down
     */
    protected void rampUp(double change){
        if(getCurrentSpeed() == 0 && (angle + change) <=70)
            angle += change;
    }

    /**
     * @return the current angle of the lift
     */
    protected double getAngle() {
        return angle;
    }
}
