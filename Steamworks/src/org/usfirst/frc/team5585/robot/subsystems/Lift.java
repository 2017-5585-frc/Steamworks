package org.usfirst.frc.team5585.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.DigitalInput;

import org.usfirst.frc.team5585.robot.OI;
//import org.usfirst.frc.team5585.robot.Robot;
//import org.usfirst.frc.team5585.robot.OI;
import org.usfirst.frc.team5585.robot.RobotMap;


/**
 *
 */
public class Lift extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public SpeedController liftMotor = RobotMap.liftMotor;
	public DigitalInput liftSW = RobotMap.liftSW;
	public boolean active = false;
	
	public void opControl() {
		double speed = OI.xbox.getX();
		liftMotor.set(speed);
	}
	
	public void stop() {
		liftMotor.stopMotor();
	}
	
//	public void lock() {
//		
//	}
	
//	public void unlock() {
//		
//	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

