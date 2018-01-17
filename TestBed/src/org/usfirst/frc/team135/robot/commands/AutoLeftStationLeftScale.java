package org.usfirst.frc.team135.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
 import org.usfirst.frc.team135.robot.RobotMap;
/**
 *
 */
public class AutoLeftStationLeftScale extends CommandGroup {

    public AutoLeftStationLeftScale() {
    	addSequential(new AutoDriveStraight(RobotMap.autoScaleVert));
    	addSequential(new AutoTurnRight());
    	addSequential(new AutoDriveStraight());
    	addSequential(new AutoLift());
    	addSequential(new AutoCubeRelease());
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
