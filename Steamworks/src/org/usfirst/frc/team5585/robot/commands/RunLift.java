package org.usfirst.frc.team5585.robot.commands;

import org.usfirst.frc.team5585.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunLift extends Command {

    public RunLift() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.Lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.Lift.active = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.Lift.opControl();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
       	return false; // command should not quit automatically
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.Lift.stop();
    	Robot.Lift.active = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
