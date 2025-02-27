public class Observer1 extends Observer{


    @Override
    public void update(Subject s) {
        System.out.println("Got an update event");
        System.out.printf("With %f Grad... from %s%n", s.getState(), s.name);
    }
}
