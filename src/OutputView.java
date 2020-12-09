import javax.swing.*;
import java.awt.*;

public class OutputView extends JPanel {

    CarController carC;

    JLabel speedLabel = new JLabel();

    public OutputView(CarController cc) {
        this.carC = cc;
        initComponents();
    }

    private void initComponents() {
        this.add(speedLabel);
    }


}
