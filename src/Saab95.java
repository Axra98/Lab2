import java.awt.*;
import java.awt.geom.Point2D;

public class Saab95 extends Car{
    /** Denna klass ärver från Car. Man får med alla metoder pluss att man lägger till egna här.
     *
     */

    private boolean turboOn;

    protected Saab95(){
        super(2, 125, Color.CYAN, "Saab 95", new Point.Double(0,0), 4.0);
    }

    /** Sätta på turbon på Saab. Detta påverkar speedFactor.
     */
    protected void setTurboOn(){
        turboOn = true;
    }

    /**Stänger av turbon och påverkar speedFactor
     * @return
     */
    protected void setTurboOff(){
        turboOn = false;
    }

    /**Denna metod heter speedFactor vilket är samma som den i Car klassen. Mha en override skriver man dock
     * över det som finns i car och använder denna istället, eftersom Saab95 har en turbo.
     * Skulle någon annan bil (skapar en annan klass som ärver från Car) inte ha några speciella
     * preferenser kring speedFactor kan man använda den som finns i Car och behöver därmed inte skapa en ny.
     */
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
            return getEnginePower() * 0.01 * turbo;
    }
}
