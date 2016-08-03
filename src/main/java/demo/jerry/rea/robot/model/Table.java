package demo.jerry.rea.robot.model;

/**
 * Represents a table with specific dimension.
 * @author jzhang
 *
 */
public class Table {
    private final int dimensionX;
    private final int dimensionY;

    public Table(final int dimensionX, final int dimensionY) {
        if (dimensionX <=0 || dimensionY <= 0) {
            throw new IllegalArgumentException("Dimension must be greater than 0.");
        }
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
    }

    /**
     * To test whether the give {@link Point} is on table.
     * @param point point to be tested.
     * @return true if point is with table's boundary.
     */
    public boolean onTable(final Point point) {
        return (point != null) && (point.getPosX() < dimensionX) && (point.getPosY() < dimensionY);
    }



}

