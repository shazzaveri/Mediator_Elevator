import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Door implements DoorState, PropertyChangeListener {

    private String doorState;

    private Elevator elevator;
    private Mediator mediator;
    private DoorState currentDoorState;
    private DoorState DoorOpen;
    private DoorState DoorClose;


    public DoorState getDoorOpen() {
        return DoorOpen;
    }

    public void setDoorOpen(DoorState doorOpen) {
        DoorOpen = doorOpen;
    }

    public Door(Mediator mediator, Elevator elevator){

        this.mediator = mediator;
        this.elevator = elevator;
        DoorOpen = new DoorOpen();
        DoorClose = new DoorClose();

        setCurrentDoorState(DoorOpen);
    }

    public DoorState getCurrentDoorState() {
        return currentDoorState;
    }

    public DoorState getDoorClose() {
        return DoorClose;
    }

    public void setDoorClose(DoorState doorClose) {
        DoorClose = doorClose;
    }

    public void setCurrentDoorState(DoorState currentDoorState) {
        this.currentDoorState = currentDoorState;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (elevator.isStateChange() != false){

            if (getCurrentDoorState() == DoorOpen) {
                DoorClose.changeState(this);
            }
            else if (getCurrentDoorState() == DoorClose){
                DoorOpen.changeState(this);
            }
        }
    }

    @Override
    public void changeState(Door door) {

    }
}
