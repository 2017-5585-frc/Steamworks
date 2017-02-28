package org.usfirst.frc.team5585.robot.subsystems;

import org.usfirst.frc.team5585.robot.OI;
import org.usfirst.frc.team5585.robot.RobotMap;
import org.usfirst.frc.team5585.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Drivetrain subsystem. Controls a 6 wheeled, quad cim drivetrain. <br>
 * written 2/7/2017
 * @author Ian Bolin
 * @category subsystem
 * @see #arcadeDrive()
 * @see #manual(double, double)
 * @see #preciseDrive()
 */
public class DriveTrain extends Subsystem {
    private RobotDrive drivetrain = RobotMap.drivetrain;
    
    /**
     * Default arcade drive method.
     * Uses joystick throttle to scale sensitivity and max output.
     */
    public void arcadeDrive() {
    	double speed = OI.joystick.getThrottle() * -0.1 + 0.9; //scaling var
    	double x = OI.joystick.getX() * -speed; //scale and set x and y
    	double y = OI.joystick.getY() * -speed;
    	drivetrain.arcadeDrive(y, x, true); // pass x and y to drivetrain
    }
    
    /**
     * Operates drive at half power.
     */
    public void preciseDrive() {
    	//drive at 50% power
    	double x = OI.joystick.getX() / -2;
    	double y = OI.joystick.getY() / -2;
    	drivetrain.arcadeDrive(y, x, true);
    }
    
    /**
     * Manually operates the drivetrain.
     * @param x - x axis factor, ie. turn
     * @param y - y axis factor, ie. drive
     */
    public void manual(double x, double y) {
    	drivetrain.drive(y,x);
    }
    
    /**
     * Stops the drivetrain.
     */
    public void stop() {
    	drivetrain.stopMotor();
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ArcadeDrive()); //automatically run arcade drive when nothing else is using the drivetrain.
    }
}

