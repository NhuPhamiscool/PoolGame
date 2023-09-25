package PoolGame;

/** Hold score logic of the game */
public class Score implements GameManagerObserver {
    int score = 0;
    Subject s;

    public Score(int score, Subject s) {
        this.s = s;
        this.score = score;
        this.s.attach(this);
    }

    /**
     * @return the current score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * set score to specific number
     * @param s the specific score to be set to  
     */
    public void setScore(int s) {
        this.score = s;
    }

    /**
     * increment the score by 1  
     */
    public void increaseScore() {
        this.score ++;
    }

    /**
     * set the score to 0  
     */
    public void reset() {
        this.score = 0;
    }

    /**
     * reset the score  
     */
    public void update () {
        reset();
    }
}