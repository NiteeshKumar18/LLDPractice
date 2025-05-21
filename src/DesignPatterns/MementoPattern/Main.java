package DesignPatterns.MementoPattern;

public class Main {
    public static void main(String[] args) {
        ConfigurationOriginator configurationOriginator = new ConfigurationOriginator(1, 2);
        Memento memento1 = configurationOriginator.createMemento();

        configurationOriginator.set(3, 4);

        MementoCareTaker mementoCareTaker = new MementoCareTaker();

        mementoCareTaker.addMemento(memento1);
        // mementoCareTaker.addMemento(memento2);


        configurationOriginator.undoMemento((Memento) mementoCareTaker.undoMemento().get());

        System.out.println(configurationOriginator.height + " " + configurationOriginator.width);
    }
}
