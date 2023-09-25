package PoolGame;

/** Defines method that the concrete subject must implement */
public interface Subject {
    /**
     * add the GameManager observers  
     */
    public void attach (GameManagerObserver o);

    /**
     * remove the GameManager observers  
     */
    public void detach (GameManagerObserver o);
    
    /**
     * notify GameManager observers when there are any changes
     */
    public void notifi(); 
    
}