package PoolGame.objects;

/** Builds pool pockets. */
public class PoolPocketBuilder implements PocketBuilder {
    // Required Parameters
    
    private double xPosition;
    private double yPosition;
    private double radius;

    @Override
    public void setRadius(double radius) {
        this.radius = radius;
    };

    @Override
    public void setxPos(double xPosition) {
        this.xPosition = xPosition;
    };

    @Override
    public void setyPos(double yPosition) {
        this.yPosition = yPosition;
    };

    

    /**
     * Builds the pocket.
     * 
     * @return pocket
     */
    public Pocket build() {
        Pocket p = new Pocket(xPosition, yPosition);
        p.setRadius(this.radius);
        return p;
    }
}
