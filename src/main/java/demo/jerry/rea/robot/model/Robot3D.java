package demo.jerry.rea.robot.model;


public class Robot3D extends Robot {
    private Direction3D direction3d;
    private Point3D position3d;

    public Point3D getPosition3D() {
        return position3d;
    }


    public void setPosition3D(final Point3D position3d) {
        this.position3d = position3d;
    }


    public void setDirection3D(final Direction3D direction3d) {
        this.direction3d = direction3d;
    }

    @Override
    public void setPosition(final Point position) {
        this.position3d = new Point3D(position.getPosX(), position.getPosY(), this.position3d.getPosZ());
    }

    @Override
    public Point getPosition() {
        return this.position3d.getPoint();
    }

    @Override
    public Direction getDirection() {
        return this.direction3d.getDirection();
    }

    @Override
    public void setDirection(final Direction direction) {
        this.direction3d = new Direction3D(direction, this.direction3d.getDirectionVertical());
    }
}
