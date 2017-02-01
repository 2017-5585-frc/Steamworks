package org.usfirst.frc.team5585.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//joysticks
	public static int joystickPort = 0;
	public static int xboxport =1;
	//lift
	public static SpeedController liftMotor;
	public static DigitalInput liftSW;
	//drivetrain
	public static SpeedController frontLeftDriveMotor, frontRightDriveMotor, rearLeftDriveMotor, rearRightDriveMotor;
	public static RobotDrive drivetrain;
	//CameraGimble
	public static Servo Xservo, Yservo;
	
	public static void init() {
		//lift
        liftSW = new DigitalInput(1);
//        LiveWindow.addSensor("Lift", "liftSW", liftSW);
        
        liftMotor = new VictorSP(4);
        liftMotor.setInverted(false);
//        LiveWindow.addActuator("lift", "Lift Speed Controller / Motor", (VictorSP) liftMotor);
        
        //drivetrain
        frontLeftDriveMotor = new Victor(3);
//        LiveWindow.addActuator("drivetrain", "front left drive motor", (Victor) frontLeftDriveMotor);
        
        frontRightDriveMotor = new Victor(1);
//        LiveWindow.addActuator("drivetrain", "front right drive motor", (Victor) frontRightDriveMotor);
        
        rearLeftDriveMotor = new Victor(2);
//        LiveWindow.addActuator("drivetrain", "rear left drive motor", (Victor) rearLeftDriveMotor);
        
        rearRightDriveMotor = new Victor(0);
//        LiveWindow.addActuator("drivetrain", "rear right drive motor", (Victor) rearRightDriveMotor);
        
        drivetrain = new RobotDrive(frontLeftDriveMotor, rearLeftDriveMotor, frontRightDriveMotor, rearRightDriveMotor);
        
        //CameraGimble
        Xservo = new Servo(5);
        LiveWindow.addActuator("Camera servo", "X", Xservo);
        
        Yservo = new Servo(6);
        LiveWindow.addActuator("Camera servo", "Y", Yservo);
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
