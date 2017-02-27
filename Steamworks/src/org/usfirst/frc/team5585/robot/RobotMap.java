package org.usfirst.frc.team5585.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * for simplicity, all devices are created as objects in this class, and imported to subsystems as necessary.
 * all REAL non sensor objects are Static, eliminating multiple instances of the same actuator.
 */
public class RobotMap {
	
	//joysticks
	public static final int joystickPort = 0;
	public static final int xboxport =1;
	//lift
	public static SpeedController liftMotor;
	public static DigitalInput liftSW;
	//drivetrain
	public static SpeedController frontLeftDriveMotor, frontRightDriveMotor, rearLeftDriveMotor, rearRightDriveMotor;
	public static RobotDrive drivetrain;
	//CameraGimble
	public static Servo Xservo, Yservo;
	
	public static AnalogInput rangeFinder;
	
	/**
	 * inits objects, should be called FIRST, to avoid initing subsystems before components.
	 */
	public static void init() {
		//lift
        liftSW = new DigitalInput(1);
        
        liftMotor = new VictorSP(4);
        LiveWindow.addActuator("LiftSystem", "motor", (LiveWindowSendable) liftMotor); // groups separately from drive motors. avoids accidental operation.
        liftMotor.setInverted(false);
        
        //drivetrain
        frontLeftDriveMotor = new Victor(3);
        frontRightDriveMotor = new Victor(1);
        rearLeftDriveMotor = new Victor(2);
        rearRightDriveMotor = new Victor(0);
        
        drivetrain = new RobotDrive(frontLeftDriveMotor, rearLeftDriveMotor, frontRightDriveMotor, rearRightDriveMotor);
        
        //CameraGimble
        Xservo = new Servo(5);
        LiveWindow.addActuator("Camera servo", "X", Xservo);
        
        Yservo = new Servo(6);
        LiveWindow.addActuator("Camera servo", "Y", Yservo);
        
        rangeFinder = new AnalogInput(0);
        
	}
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
