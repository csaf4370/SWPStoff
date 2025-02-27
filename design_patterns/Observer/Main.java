public class Main {

    public static void main(String[] args) {
        Observer1 obsi1 = new Observer1();

        Subject heizung1 = new Subject();
        heizung1.name = "Heizung 1";
        Subject heizung2 = new Subject();
        heizung2.name = "Heizung 2";

        heizung1.registerObserver(obsi1);
        heizung2.registerObserver(obsi1);

        heizung1.setState(55.0f);
        heizung2.setState(33.0f);
    }
}
