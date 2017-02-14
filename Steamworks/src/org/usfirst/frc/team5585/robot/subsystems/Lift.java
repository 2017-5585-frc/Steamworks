package org.usfirst.frc.team5585.robot.subsystems;

import org.usfirst.frc.team5585.robot.OI;
import org.usfirst.frc.team5585.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * lift subsystem, used to provide a command based subsystem to operate the rotary rope lift
 *  @since 2/7/2017
 * @author Ian Bolin
 * @category subsystem
 */
public class Lift extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public SpeedController liftMotor = RobotMap.liftMotor;
	public DigitalInput liftSW = RobotMap.liftSW;
	public boolean active = false;
	
	public void opControl() {
		double speed = OI.xbox.getY() * 0.5;
		liftMotor.set(speed-0.5);
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

