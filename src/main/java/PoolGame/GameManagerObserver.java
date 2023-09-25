package PoolGame;

/** Define method that game manager observers must follow. */
public interface GameManagerObserver {
    /**
     * calling update when user changes the level 
     */
    void update();
}