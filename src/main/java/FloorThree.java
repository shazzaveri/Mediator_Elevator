import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FloorThree implements Floor, PropertyChangeListener {

    private Elevator elevator;
    private FloorOne floorOne;
    private FloorTwo floorTwo;
    int floorNumber;
    private Mediator mediator;

    public FloorThree(Elevator elevator, Mediator mediator){
        this.elevator = elevator;
        this.mediator = mediator;
        floorNumber = 3;
    }
    public int floorNumber(){
        return getFloorNumber();
    }
    @Override
    public void press1(){
        floorOne = new FloorOne(elevator, mediator);
        floorOne.press1();
    }

    @Override
    public void press2(){
        floorTwo = new FloorTwo(elevator, mediator);
        floorTwo.press2();
    }

    public void press3(){

        System.out.println(floorNumber + " pressed");
        mediator.mediate(elevator.getId(), this);


    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public void printState() {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
