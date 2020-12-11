public interface ICar {
    void startEngine();

    void stopEngine();

    void setTurboOn();

    void setTurboOff();

    void rampDown();

    void rampUp();

    String updateSpeed();

    void gas(int amount);

    void brake(int amount);

    void addCar();

}
