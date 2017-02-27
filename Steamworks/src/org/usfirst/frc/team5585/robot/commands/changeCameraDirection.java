package org.usfirst.frc.team5585.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5585.robot.Robot;

/**
 *
 */
public class changeCameraDirection extends Command {

    public changeCameraDirection() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.Gimble);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.Gimble.setDirection();
    	Robot.camera();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
