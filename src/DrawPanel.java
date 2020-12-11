import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.HashMap;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize

    HashMap<Vehicle, BufferedImage> imageMap = new HashMap<>();

    // TODO: Make this general for all cars
    void moveit(int x, int y, Vehicle car){
        car.getPos().setLocation(x,y);
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Vehicle> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.magenta);
        // Print an error message in case file is not found with a try/catch block
        paintImage();
    }

    public void removeImage() {
        try {
            imageMap.remove(0);
        }
        catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

    public void paintImage() {
        try {
            String path;
            for (Vehicle car : cc.model.cars) {
                path = "pics/" + car.getmodelName() + ".jpg";
                BufferedImage image = ImageIO.read(DrawPanel.class.getResourceAsStream(path));
                imageMap.put(car, image);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void actOnUpdate(){
        repaint();
        paintImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int count = 0;
        for (Vehicle car : imageMap.keySet()) {
            g.drawImage(imageMap.get(car), (int) car.getPos().x, (int) car.getPos().y + count, null);
            count += 100;
        }
    }
}