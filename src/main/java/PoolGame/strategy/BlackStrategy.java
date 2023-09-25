package PoolGame.strategy;

/** Hold strategy logic for black ball and brown ball */
public class BlackStrategy extends PocketStrategy {
    /** Creates a new black strategy. */
    public BlackStrategy() {
        this.lives = 3;
    }

    /**
     * reset the ball's lives into 3
     */
    public void reset() {
        this.lives = 3;
    }
}
