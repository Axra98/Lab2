import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.HashMap;

public class DrawPanel extends JPanel implements Observer, RemoveObserver {

    HashMap<Vehicle, BufferedImage> imageMap = new HashMap<>();
    CarController cc;

    public DrawPanel(int x, int y, CarController cc) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.magenta);
        cc.model.addObservers(this);
        cc.model.addObservers2(this);
        this.cc = cc;
        paintImage();
    }

    public void removeImage() {
        try {
            imageMap.remove(cc.model.cars.remove(imageMap.size() - 1));
        } catch (IndexOutOfBoundsException ex) {
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

    public void actOnUpdate() {
        paintImage();
        repaint();
    }

    public void removeOnUpdate() {
        removeImage();
        repaint();
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