package org.usfirst.frc.team5585.robot.subsystems;

import org.usfirst.frc.team5585.robot.OI;
import org.usfirst.frc.team5585.robot.RobotMap;
import org.usfirst.frc.team5585.robot.commands.aimCamera;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *subsystem for controlling experimental camera gimble. due for removal.
 * @since 2/7/2017
 * @author Ian Bolin 
 * @category subsytem
 * @category Unused
 */
public class CameraGimble extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Servo xservo = RobotMap.Xservo;
	private Servo yservo = RobotMap.Yservo;
	private String direction = "Forward";
	
	public void set() {
		double x = OI.xbox.getX()*-0.1;
		double y = OI.xbox.getY()*0.2;
		if (direction == "Forward") {
			xservo.set(x+0.1);
		}
		else {
			xservo.set(x+0.9);
		}
		yservo.set(y+0.5);
	}
	
	public void setDirection() {
		if (direction == "Forward") {
			direction = "Reverse";
		}
		else {
			direction = "Forward";
		}
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new aimCamera());
    }
}

