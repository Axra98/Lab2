import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends Car> implements Load<T> {

    private T car;
    private int max;
    private List<T> store;

    /**
     * Creats a WorkShop
     *
     * @param car decides which typ of Car we can put in the Workshop
     * @param max decides how big the Workshop is
     */
    public Workshop(T car, int max) {
        this.car = car;
        this.max = max;
        store = new ArrayList<>();
    }

    /**
     * Loads the car to the Workshop
     *
     * @param car which car to load
     */
    public void loadCar(T car) {
        if (store.size() < max) {
            store.add(car);
        }
    }

    /**
     * Removes the car from the Workshop
     *
     * @param car which car to remove
     */
    public void removeCar(T car) {
        if (store.contains(car))
            removeCar(car);
    }
}

