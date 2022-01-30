import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public interface DoorState extends PropertyChangeListener {



    @Override
    public default void propertyChange(PropertyChangeEvent evt) {

    }

    void changeState(Door door);
}
