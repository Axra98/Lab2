import java.awt.*;
import java.awt.geom.Point2D;

public class Volvo240 extends Car {


    private final static double trimFactor = 1.25;

    public Volvo240(){
        super(4, 100, Color.GRAY, "Volvo 240", new Point.Double(0,0), 3.0);
    }

    /** Här får man en speedFactor som tar hänsyn till en trimFactor.
     * Den används sedan i incrementSpeed och decrementSpeed.
     * Den overridear den som finns i Car. Det som skiljer denna från den i Car är att här
     * tar man hänsyn till trimFactor, något som den i Car inte gör.
     */
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}

