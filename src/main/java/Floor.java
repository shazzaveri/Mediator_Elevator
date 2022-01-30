import java.beans.PropertyChangeListener;

public interface Floor extends PropertyChangeListener {



    public abstract int floorNumber();

    default void press1() {
    }

    default void press2() {

    }
    default void press3() {}

    public abstract void printState();

}


