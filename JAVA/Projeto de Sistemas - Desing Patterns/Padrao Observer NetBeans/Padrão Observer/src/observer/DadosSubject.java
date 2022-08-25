package observer;

import java.util.ArrayList;

public class DadosSubject {
    protected ArrayList<InfoObserver> observers;
    protected Info info;
    public DadosSubject() {
        observers = new ArrayList<>();
    }
    public void attach(InfoObserver observer) {
        observers.add(observer);
    }
    public void detach(int index) {
        observers.remove(index);
    }
    public void setState(Info info) {
        this.info = info;
        notifyObservers();
    }
    private void notifyObservers() {
        observers.forEach(o -> o.update());
    }
    public Info getState() {
        return info;
    }
}
