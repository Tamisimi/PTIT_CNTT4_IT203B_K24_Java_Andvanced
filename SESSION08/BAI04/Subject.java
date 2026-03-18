package SESSION08.BAI04;

interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}
