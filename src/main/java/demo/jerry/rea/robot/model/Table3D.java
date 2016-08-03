package demo.jerry.rea.robot.model;


public class Table3D extends Table {
    private final int dimenstionZ;

    public Table3D(final int dimensionX, final int dimensionY, final int dimensionZ) {
        super(dimensionX, dimensionY);
        this.dimenstionZ = dimensionZ;
    }


    public int getDimenstionZ() {
        return dimenstionZ;
    }

    public boolean onTable(final Point3D point) {
        return point != null && onTable(point.getPoint()) && point.getPosZ() < this.dimenstionZ;
    }

}
