package DesignPatterns.MementoPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MementoCareTaker {

    private List<Memento> mementoStateList = new ArrayList<>();


    public void addMemento(Memento memento) {
        this.mementoStateList.add(memento);
    }

    public Optional<Object> undoMemento() {
        if (!mementoStateList.isEmpty()) {
            int index = mementoStateList.size() - 1;
            var obj = mementoStateList.get(index);
            mementoStateList.remove(index);
            return Optional.ofNullable(obj);
        }
        return Optional.empty();
    }
}
