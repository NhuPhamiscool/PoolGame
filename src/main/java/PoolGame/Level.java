package PoolGame;

/** Super level class that every level must extend from. */
public class Level {
    String filePath;

    public Level(String file) {
        this.filePath = file;
    } 

    /**
     * @return config file path
     */
    public String handle () {
        return this.filePath;
    }
}