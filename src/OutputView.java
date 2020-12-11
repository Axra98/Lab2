import javax.swing.*;

public class OutputView extends JPanel {

    CarController carC;

    //JButton speedButton = new JButton("speedButton");
    JLabel speedLabel = new JLabel("hej");

    public OutputView(CarController cc) {
        this.carC = cc;
        initComponents();
    }

    public void actOnUpdate() {
        speedLabel.setText(carC.updateSpeed());
    }

    public void initComponents() {
        this.add(speedLabel);

        /**speedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              text();
            }
        });
         **/
    }


}
