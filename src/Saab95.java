import java.awt.*;
public class Saab95 extends Car implements ITurbo {
    /**
     * Denna klass ärver från Vehicles.Car. Man får med alla metoder pluss att man lägger till egna här.
     */

    public boolean turboOn;

    public Saab95() {

        super(2, 125, Color.CYAN, "Saab95", new Point.Double(0, 0), 4.0);
    }

    /**
     * Sätta på turbon på Saab. Detta påverkar speedFactor.
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Stänger av turbon och påverkar speedFactor
     *
     * @return
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * Denna metod heter speedFactor vilket är samma som den i Vehicles.Car klassen. Mha en override skriver man dock
     * över det som finns i car och använder denna istället, eftersom Vehicles.Saab95 har en turbo.
     * Skulle någon annan bil (skapar en annan klass som ärver från Vehicles.Car) inte ha några speciella
     * preferenser kring speedFactor kan man använda den som finns i Vehicles.Car och behöver därmed inte skapa en ny.
     */
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;

    }
}
