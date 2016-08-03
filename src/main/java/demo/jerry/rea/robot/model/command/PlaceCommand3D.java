package demo.jerry.rea.robot.model.command;

import demo.jerry.rea.robot.model.Direction3D;
import demo.jerry.rea.robot.model.Point3D;
import demo.jerry.rea.robot.model.Robot3D;
import demo.jerry.rea.robot.model.Table3D;


public class PlaceCommand3D implements RobotCommand {
    private final Table3D table3D;
    private final Robot3D robot3D;
    private final Point3D point3D;
    private final Direction3D direction3D;


    public PlaceCommand3D(final Table3D table3d, final Robot3D robot3d, final Point3D point3d, final Direction3D direction3d) {
        table3D = table3d;
        robot3D = robot3d;
        point3D = point3d;
        direction3D = direction3d;
    }




    @Override
    public void execute() {
        if (!table3D.onTable(point3D)) {
            throw new IllegalStateException("Point not on 3D table");
        }
        robot3D.setDirection3D(this.direction3D);
        robot3D.setPosition3D(this.point3D);
    }

}
