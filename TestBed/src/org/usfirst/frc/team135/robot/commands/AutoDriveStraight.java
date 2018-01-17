package org.usfirst.frc.team135.robot.commands;

import org.usfirst.frc.team135.robot.*;
import org.usfirst.frc.team135.robot.Robot;
import org.usfirst.frc.team135.robot.RobotMap; 

//import java.awt.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team135.robot.commands.AutoLeftStationAutoLine;
/**
 *
 */
public class AutoDriveStraight extends Command {
	
	private Timer timer;
	private int distance;

	public AutoDriveStraight(int x) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.sonar);
    	distance = x;
    	timer = new Timer();
    
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

		//set motors equal to .5 speed
    	//set timer value (How does this become generalized if the value differs for each path?) 
    	if (distance == RobotMap.autoLine) {
    		
    		timer.start();
    		while (Robot.sonar.GetSonarValue() <RobotMap.autoLine && timer.get() < 3 && DriverStation.getInstance().isAutonomous()) //change value when we know that we need for each path
    		{
    			Robot.drivetrain.MecanumDrive(.5, -.5); //Does this get changed to MecanumDrive? 
    		}
    		timer.stop();
    		timer.reset();
    		timer.start();
    		while (Robot.sonar.GetSonarValue() >= RobotMap.autoLine && timer.get() < 3 && DriverStation.getInstance().isAutonomous())
    		{
    			Robot.drivetrain.MecanumDrive(0,0);
    		}
    	}
    	
    	else if (distance == RobotMap.autoScale)
		{
			while (Robot.sonar.GetSonarValue() < RobotMap.autoScale && timer.get() < 3 && DriverStation.getInstance().isAutonomous()) //change value when we know that we need for each path
    		{
    			Robot.drivetrain.MecanumDrive(.5, -.5); 
    		}
    		
    		while (Robot.sonar.GetSonarValue() >= RobotMap.autoScale && timer.get() < 3 && DriverStation.getInstance().isAutonomous())
    		{
    			Robot.drivetrain.MecanumDrive(0,0); //will this get caught in a scary loop?
    		}
		}
		
    	else if (distance == 168)
		{
			while (Robot.sonar.GetSonarValue() < 160  && timer.get() < 3 && DriverStation.getInstance().isAutonomous()) //change value when we know that we need for each path
    		{
    			Robot.drivetrain.MecanumDrive(.5, -.5); //Does this get changed to MecanumDrive? 
    		}
    		while (Robot.sonar.GetSonarValue() >=160 && Robot.sonar.GetSonarValue()< 168 )
    		{
    			Robot.drivetrain.MecanumDrive(.25, -.25);
    		}
    		while (Robot.sonar.GetSonarValue() >= 168  && timer.get() < 3 && DriverStation.getInstance().isAutonomous())
    		{
    			Robot.drivetrain.MecanumDrive(0,0);
    		}
		}
		
    	else if (distance == 168)
		{
			while (Robot.sonar.GetSonarValue() < 160 ) //change value when we know that we need for each path
    		{
    			Robot.drivetrain.MecanumDrive(.5, -.5); //Does this get changed to MecanumDrive? 
    		}
    		while (Robot.sonar.GetSonarValue() >=160 && Robot.sonar.GetSonarValue()< 168 )
    		{
    			Robot.drivetrain.MecanumDrive(.25, -.25);
    		}
    		while (Robot.sonar.GetSonarValue() >= 168 )
    		{
    			Robot.drivetrain.MecanumDrive(0,0);
    		}
		}

		else 
		{
			Robot.drivetrain.MecanumDrive(0,0);
		}
    }
    	

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
