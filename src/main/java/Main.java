public class Main {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();

        Elevator elevator = new Elevator("E1", mediator);

        Door door = new Door(mediator, elevator);

        mediator.addColleague(elevator.getId(), door );
        mediator.addColleague(elevator.getId(), elevator);
        mediator.addColleague(elevator.getId(), door );

        elevator.press2();
        elevator.press1();
        elevator.press3();
        elevator.press3();
        elevator.press1();

    }

}
