package org.usfirst.frc.team5585.robot.subsystems;

import org.usfirst.frc.team5585.robot.OI;
import org.usfirst.frc.team5585.robot.RobotMap;
import org.usfirst.frc.team5585.robot.commands.*;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {
    private RobotDrive drivetrain = RobotMap.drivetrain;
    
    public void init() {
    	
    }
    
    public void arcadeDrive() {
    	drivetrain.arcadeDrive(OI.joystick);
    }
    
    public void preciseDrive() {
    	//drive at 50% power
    	double x = OI.joystick.getX() / 2;
    	double y = OI.joystick.getY() / 2;
    	drivetrain.arcadeDrive(x, y);
    }
    
    public void stop() {
    	drivetrain.stopMotor();
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ArcadeDrive());
    }
}

