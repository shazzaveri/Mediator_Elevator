import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Elevator implements PropertyChangeListener  {

    private Floor floorOne;
    private Floor floorTwo;
    private Floor floorThree;
    private Door door;
    private Floor currentFloor;
    private boolean stateChange;
    private String id;
    private Mediator mediator;

    public Elevator(String id,Mediator mediator) {
        this.mediator = mediator;

        floorOne = new FloorOne(this, mediator);
        floorTwo = new FloorTwo(this, mediator);
        floorThree = new FloorThree(this, mediator);

        setStateChange(true);
        setCurrentFloor(getFloorOne());
    }



    public void press1() {
        currentFloor.press1();
    }

    public void press2() {
        currentFloor.press2();

    }

    public void press3() {
        currentFloor.press3();
    }


    public Floor getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor;
    }


    public Floor getFloorOne() {
        return floorOne;
    }

    public void setFloorOne(Floor floorOne) {
        this.floorOne = floorOne;
    }

    public Floor getFloorTwo() {
        return floorTwo;
    }

    public void setFloorTwo(Floor floorTwo) {
        this.floorTwo = floorTwo;
    }

    public Floor getFloorThree() {
        return floorThree;
    }

    public void setFloorThree(Floor floorThree) {
        this.floorThree = floorThree;
    }

    public boolean isStateChange() {
        return stateChange;
    }

    public void setStateChange(boolean stateChange) {
        this.stateChange = stateChange;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource() instanceof Floor) {
            if ( !(evt.getSource().equals(getCurrentFloor()))){
                setStateChange(true);
                Floor rfloor = ((Floor) evt.getSource());
                if ( (rfloor.floorNumber() - getCurrentFloor().floorNumber()) > 0){
                    System.out.println("Going up...");
                    System.out.println("*ding* The elevator arrives at Floor " + rfloor.floorNumber());
                    setCurrentFloor(rfloor);
                } else if ((rfloor.floorNumber() - getCurrentFloor().floorNumber()) < 0 ){
                    System.out.println("Going down...");
                    System.out.println("*ding* The elevator arrives at Floor " + rfloor.floorNumber());
                    setCurrentFloor(rfloor);
                }
            } else {
                System.out.println("Nothing Happens");
                setStateChange(false);
            }
        }
    }
}
