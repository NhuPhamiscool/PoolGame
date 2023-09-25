package PoolGame;

import java.util.ArrayList;
import PoolGame.objects.Ball;

/** Save internal state of the game */
public class Memento {
    private ArrayList<Ball> b;
    private Score scoreScreen;
    private Clock time;

    public Memento (ArrayList<Ball> b, Score scoreScreen, Clock time) {
        this.b = b;
        this.scoreScreen = scoreScreen;
        this.time = time;
    }

    /**
     * @return arraylist of saved balls
     */
    public ArrayList<Ball> getSavedBalls() {
        return this.b;
    }

    /**
     * @return the saved score
     */
    public Score getSavedScore() {
        return this.scoreScreen;
    }

    /**
     * @return the saved time
     */
    public Clock getSavedTime() {
        return this.time;
    }
}