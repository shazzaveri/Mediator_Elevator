import java.beans.PropertyChangeListener;

public class DoorClose implements DoorState, PropertyChangeListener {


    public void changeState(Door door){
        System.out.println("Doors are Closed");
        door.setCurrentDoorState(door.getDoorClose());
    }
}
