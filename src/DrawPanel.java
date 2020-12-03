import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.HashMap;

// This panel represent the animated part of the view with the car images.
public class DrawPanel extends JPanel{

    HashMap<Vehicle, BufferedImage> imageMap = new HashMap<>();

    // TODO: Make this general for all car
    /**
     * Används för att flytta bilderna till positionen bilarna är på
     * @param x komponenten i x led
     * @param y komponenten i y led
     * @param car bilen i listan som ska flyttas
     */
    void moveit(int x, int y, Vehicle car){
        car.getPos().setLocation(x,y);
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Vehicle> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block

        try {
            String path;
            for(Vehicle car: cars) {
                path = "pics/" + car.getmodelName() + ".jpg";
                BufferedImage image = ImageIO.read(DrawPanel.class.getResourceAsStream(path));
                imageMap.put(car, image);
                //car.setPosition(new Point2D.Double(x, y));

            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int count = 0;
        for( Vehicle car: imageMap.keySet()) {
            g.drawImage(imageMap.get(car), (int) car.getPos().x, (int) car.getPos().y+count, null);
            count += 100;
        }
    }
}