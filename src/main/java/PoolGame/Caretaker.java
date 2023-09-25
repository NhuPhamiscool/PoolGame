package PoolGame;

import java.util.*;

/** Holds memento list for undo feature. */
public class Caretaker {
    private Deque<Memento> history;

    public Caretaker() {
        history = new LinkedList<Memento>();
    }

    /**
     * return the latest memento
     *
     * @return memento
     */
    public Memento undo() {
        if (history.size() == 0) {
            return null;
        }
        return history.removeLast();
    }

    /**
     * checking the saved state list
     * @return saved state list
     */
    public int getHistorySize() {
        return history.size();
    }

    /**
     * save memento into list
     * @param m memento to be added into the saved list
     */
    public void addMemento(Memento m) {
        history.add(m);
    }

}