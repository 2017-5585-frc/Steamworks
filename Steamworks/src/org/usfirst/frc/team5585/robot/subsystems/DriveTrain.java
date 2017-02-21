package org.usfirst.frc.team5585.robot.subsystems;

import org.usfirst.frc.team5585.robot.OI;
import org.usfirst.frc.team5585.robot.RobotMap;
import org.usfirst.frc.team5585.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *Drivetrain subsystem
 * @since 2/7/2017
 * @author Ian Bolin
 * @category subsystem
 * @see #arcadeDrive()
 * @see #manual(double, double)
 * @see 
 */
public class DriveTrain extends Subsystem {
    private RobotDrive drivetrain = RobotMap.drivetrain;
    
    public void init() {
    	
    }
    
    public void arcadeDrive() {
    /*
     * default arcade drive method
     */
    	double speed = OI.joystick.getThrottle() * -0.1 + 0.9;
    	double x = OI.joystick.getX() * -speed;
    	double y = OI.joystick.getY() * -speed;
    	drivetrain.arcadeDrive(y, x, true);
    }
    
    public void preciseDrive() {
    	//drive at 50% power
    	double x = OI.joystick.getX() / -2;
    	double y = OI.joystick.getY() / -2;
    	drivetrain.arcadeDrive(y, x, true);
    }
    
    public void manual(double x, double y) {
    	drivetrain.drive(y,x);
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

