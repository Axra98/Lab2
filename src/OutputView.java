import javax.swing.*;

public class OutputView extends JPanel implements Observer {

    CarController carC;

    JLabel speedLabel = new JLabel();

    public OutputView(CarController cc) {
        this.carC = cc;
        initComponents();
        cc.model.addObservers(this);
    }

    public void actOnUpdate() {
        speedLabel.setText(carC.updateSpeed());
    }

    public void initComponents() {
        this.add(speedLabel);
    }
}