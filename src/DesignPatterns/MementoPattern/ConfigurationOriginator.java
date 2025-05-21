package DesignPatterns.MementoPattern;

public class ConfigurationOriginator {

    public int height;

    public int width;


    public ConfigurationOriginator(int height, int width) {
        this.height = height;
        this.width = width;
    }


    public Memento createMemento() {
        return new Memento(this.height, this.width);
    }


    public void undoMemento(Memento memento) {
        this.height = memento.height;
        this.width = memento.width;
    }

    public void set(int height, int width) {
        this.height = height;
        this.width = width;
    }


}
