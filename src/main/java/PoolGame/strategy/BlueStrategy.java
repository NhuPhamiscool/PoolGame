package PoolGame.strategy;

/** Hold strategy logic for green ball, purple ball and blue ball */
public class BlueStrategy extends PocketStrategy {
    /** Creates a new blue strategy. */
    public BlueStrategy() {
        this.lives = 2;
    }

    /**
     * reset the ball's lives into 2
     */
    public void reset() {
        this.lives = 2;
    }
}
