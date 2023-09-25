package PoolGame.strategy;

/** Hold strategy logic for orange ball, yellow ball and red ball */
public class BallStrategy extends PocketStrategy {
    /**
     * Creates a new ball strategy.
     */
    public BallStrategy() {
        this.lives = 1;
    }

    /**
     * reset the ball's lives into 1
     */
    public void reset() {
        this.lives = 1;
    }
}
