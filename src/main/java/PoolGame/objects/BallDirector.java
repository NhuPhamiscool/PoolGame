package PoolGame.objects;

/** Builds pool balls. */
public class BallDirector {
    private BallBuilder builder;

    public BallDirector(BallBuilder builder) {
        this.builder = builder;
    }

    /**
     * Returns the created Ball object with
     * the given parameters
     * @param colour
     * @param positionX
     * @param positionY
     * @param velocityX
     * @param velocityY
     * @param mass
     * @return Ball
     */
    public Ball build(String colour, double positionX, double positionY, double velocityX, double velocityY, double mass) {
        this.builder.setColour(colour);
        this.builder.setxPos(positionX);
        this.builder.setyPos(positionY);
        this.builder.setxVel(velocityX);
        this.builder.setyVel(velocityY);
        this.builder.setMass(mass);
        Ball b = this.builder.build();
        return b;
    }
}