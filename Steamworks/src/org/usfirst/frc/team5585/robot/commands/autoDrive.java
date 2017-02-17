package org.usfirst.frc.team5585.robot.commands;

import org.usfirst.frc.team5585.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class autoDrive extends Command {

    public autoDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.Drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.setTimeout(4);
    	Robot.autoVars.setStartTime();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.Drivetrain.manual(0, 1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Robot.autoVars.getTimeRemaining(1) <= 0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.Drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
