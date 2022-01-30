import java.beans.PropertyChangeListener;

public class DoorOpen implements DoorState, PropertyChangeListener {
    @Override
    public void changeState(Door door) {
        System.out.println("Doors are Open");
        door.setCurrentDoorState(door.getDoorOpen());
    }
}
