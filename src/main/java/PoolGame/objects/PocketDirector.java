package PoolGame.objects;

/** Builds pool pockets. */
public class PocketDirector {
    private PocketBuilder builder;

    public PocketDirector(PocketBuilder builder) {
        this.builder = builder;
    }

    /**
     * Returns the created Pocket object with
     * the given parameters
     * @param positionX
     * @param positionY
     * @param radius
     * @return Pocket
     */
    public Pocket build(double positionX, double positionY, double radius) {
        this.builder.setxPos(positionX);
        this.builder.setyPos(positionY);
        this.builder.setRadius(radius);
        Pocket p = this.builder.build();
        return p;
    }
}