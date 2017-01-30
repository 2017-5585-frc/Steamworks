
package org.usfirst.frc.team5585.robot;

import org.usfirst.frc.team5585.robot.from2839.BetterCameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import org.usfirst.frc.team5585.robot.commands.*;
import org.usfirst.frc.team5585.robot.subsystems.*;
import org.usfirst.frc.team5585.robot.triggers.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static DriveTrain Drivetrain;
	public static Lift Lift;
	public static CameraGimble Gimble;
	public static OI oi;
	public static LiftActive LiftActive;
	
	public Command ArcadeDrive;
	public Command PreciseDrive;
	public Command DisableDrive;
	public Command RunLift;
	public Command aimCamera;
	public Command changeCameraDirection;
	public Command switchCamera;
	
    SendableChooser chooser;
    
    public static BetterCameraServer server;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		RobotMap.init();
		
	    Drivetrain = new DriveTrain();
	    Lift = new Lift();
	    Gimble = new CameraGimble();
	    LiftActive = new LiftActive();
	    BetterCameraServer.init("cam0", "cam1");
        BetterCameraServer.start();
//        chooser = new SendableChooser();
//        chooser.addDefault("run Whacker", new RunWhacker());
//        chooser.addObject("alt", new RunWhacker());
//        SmartDashboard.putData("Auto mode", chooser);
        oi = new OI();
        oi.preciseDriveButton.toggleWhenActive(new PreciseDrive());
        oi.liftButton.toggleWhenActive(new RunLift());
        oi.cameraButton.whenReleased(new switchCamera());
        oi.stopButton.whenPressed(new DisableDrive());
        LiftActive.whileActive(new DisableDrive());
        
        
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
//    	boolean disabled = true;
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        //autonomousCommand = (Command) chooser.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new RunWhacker();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        //if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        //if (autonomousCommand != null) {
        	//autonomousCommand.cancel();
        //}
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        

    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}