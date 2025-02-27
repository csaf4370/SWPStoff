import java.util.ArrayList;
import java.util.List;

public class Subject {

    private float temperatur = 0.0f;
    public String name = "default";

    private List<Observer> observerCollection = new ArrayList<Observer>();

    public void registerObserver(Observer o){
        observerCollection.add(o);
    }

    public void unregisterObserver(Observer o){
        observerCollection.remove(o);
    }

    protected void notifyObservers(){
        for(Observer o: this.observerCollection){
            o.update(this);
        }
    }

    public void setState(float temp){
        this.temperatur = temp;
        this.notifyObservers();
    }

    public float getState(){
        return this.temperatur;
    }
}
