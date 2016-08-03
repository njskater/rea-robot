package demo.jerry.rea.robot.model;

/**
 * Basic two dimension coordination.
 * @author jzhang
 */
public class Point {

    private int posX = -1;
    private int posY = -1;

    /**
     * Construct a point by given x and y position.
     * @param posX x position.
     * @param posY y position.
     */
    public Point(final int posX, final int posY) {
        if (posX < 0 || posY < 0) {
            throw new IllegalArgumentException("Position must be positive numbers");
        }

        this.posX = posX;
        this.posY = posY;
    }

    /**
     * Get x position of current point.
     * @return
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Get y position of current point.
     * @return
     */
    public int getPosY() {
        return posY;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("[").append(posX).append(", ").append(posY).append("]").toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + posX;
        result = prime * result + posY;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final Point other = (Point) obj;
        if (posX != other.posX) return false;
        if (posY != other.posY) return false;
        return true;
    }



}

