package PoolGame;

/** Holds time logic to display on game screen. */
public class Clock implements GameManagerObserver {
    int min = 0;
    int second = 0;
    int count = 0;
    Subject s;

    public Clock(int min, int second, Subject s) {
        this.s = s;
        this.min = min;
        this.second = second;
        this.s.attach(this);
    }

    /**
     * @return the sec part of the time 
     */
    public int getSecond() {
        return this.second;
    }

    /**
     * @return min part of the time 
     */
    public int getMinute() {
        return this.min;
    }

    /**
     * set min and sec to 0  
     */
    public void reset() {
        this.min = 0;
        this.second = 0;
    }

    /**
     * time logic which increment the min and sec part 
     */
    public void tick() {
        if (count % 60 == 0) {
            if (second == 59) {
                min +=1;
                second = 0;
            } else {
                second += 1;
            }
            count = 0;
        }
        count += 1;
    }

    /**
     * format the time
     * @return the formatted time  
     */
    public String display () {
        String formatted = "";
        if (second < 10) {
            formatted = String.format("%02d", second);

        } else {
            formatted = String.valueOf(second);
        }

        return String.valueOf(min) + ":" + formatted;
    }

    /**
     * reset the time  
     */
    public void update () {
        reset();
    }
}