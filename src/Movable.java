public interface Movable {
    void move();
    void turnLeft();
    void turnRight();
}
/**
Används för att kunna implementera i andra klasser. Vill man använda move, turnLeft och turnRight i
en annan klass, tex. Cykel så kan
 */