public interface Load<T extends Car> {
    void loadCar(T t);

    void removeCar(T t);
}
