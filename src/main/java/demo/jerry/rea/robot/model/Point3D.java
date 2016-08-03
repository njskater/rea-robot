package demo.jerry.rea.robot.model;

/**
 * A 3 dimension point.
 * @author jzhang
 *
 */
public class Point3D {
    private final Point point;
    private final int z;

    public Point3D(final int x, final int y, final int z) {
        point = new Point(x, y);
        this.z = z;
    }


    public Point getPoint() {
        return point;
    }

    public int getPosX() {
        return this.point.getPosX();
    }

    public int getPosY() {
        return this.point.getPosY();
    }

    public int getPosZ() {
        return z;
    }



}
