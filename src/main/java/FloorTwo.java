import javax.sound.midi.Soundbank;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FloorTwo implements Floor, PropertyChangeListener {

    private Elevator elevator;
    private FloorOne floorOne;
    private FloorThree floorThree;
    int floorNumber;
    private Mediator mediator;

    public FloorTwo(Elevator elevator, Mediator mediator){
        this.elevator = elevator;
        this.mediator = mediator;
        floorNumber = 2;
    }

    public int floorNumber(){
        return getFloorNumber();
    }

    public void press1(){
        floorOne = new FloorOne(elevator, mediator);
        floorOne.press1();
    }
    public void press2(){

        System.out.println(floorNumber + " pressed");
        mediator.mediate(elevator.getId(), this);

    }

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

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
