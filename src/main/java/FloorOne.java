import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FloorOne implements Floor, PropertyChangeListener {

    private Elevator elevator;
    private FloorTwo floorTwo;
    private FloorThree floorThree;
    int floorNumber;
    private Mediator mediator;

    public FloorOne(Elevator elevator, Mediator mediator){
        this.elevator = elevator;
        this.mediator = mediator;
        floorNumber = 1;

    }

    public int floorNumber(){
       return getFloorNumber();
    }

    @Override
    public void press1(){

        System.out.println(floorNumber + " pressed");
        mediator.mediate(elevator.getId(), this);
    }

    @Override
    public void press2(){
        floorTwo = new FloorTwo(elevator, mediator);
        floorTwo.press2();
    }

    @Override
    public void press3(){
        floorThree = new FloorThree(elevator, mediator);
        floorThree.press3();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public void printState() {

        System.out.println();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
