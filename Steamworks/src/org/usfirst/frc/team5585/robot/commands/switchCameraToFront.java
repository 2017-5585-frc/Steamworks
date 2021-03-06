package org.usfirst.frc.team5585.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5585.robot.Robot;
import org.usfirst.frc.team5585.robot.Server17;

/**
 * switches the camera to the front camera (as defined by server 17)
 */
public class switchCameraToFront extends Command {

    public switchCameraToFront() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Server17.changeCameraTo("front");
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
    	Robot.camera();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
