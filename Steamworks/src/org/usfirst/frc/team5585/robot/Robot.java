
package org.usfirst.frc.team5585.robot;


import org.usfirst.frc.team5585.robot.commands.CenterAuto;
import org.usfirst.frc.team5585.robot.commands.DisableDrive;
import org.usfirst.frc.team5585.robot.commands.PreciseDrive;
import org.usfirst.frc.team5585.robot.commands.RunLift;
import org.usfirst.frc.team5585.robot.commands.baselineAuto;
import org.usfirst.frc.team5585.robot.commands.leftAuto;
import org.usfirst.frc.team5585.robot.commands.rightAuto;
import org.usfirst.frc.team5585.robot.commands.switchCameraToFront;
import org.usfirst.frc.team5585.robot.Server17;
import org.usfirst.frc.team5585.robot.subsystems.CameraGimble;
import org.usfirst.frc.team5585.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5585.robot.subsystems.Lift;
import org.usfirst.frc.team5585.robot.triggers.LiftActive;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	
	public static PowerDistributionPanel pdp;
	
	public static Dashboard dashboard;
	public static AutonomousVars autoVars;
	
	public Command ArcadeDrive;
	public Command PreciseDrive;
	public Command DisableDrive;
	public Command RunLift;
	public Command aimCamera;
	public Command changeCameraDirection;
	public Command switchCamera;
	public Command leftAuto;
	public Command CenterAuto;
	public Command rightAuto;
	public Command baselineAuto;
	public Command autoCommand;
	
    SendableChooser auto;
    
    public static Server17 server;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		RobotMap.init();
		autoVars = new AutonomousVars();
	    Drivetrain = new DriveTrain();
	    Lift = new Lift();
	    Gimble = new CameraGimble();
	    LiftActive = new LiftActive();
	    
	    pdp = new PowerDistributionPanel();
	    server.init();
        server.start();
        auto = new SendableChooser();
        auto.addDefault("left", new leftAuto());
        auto.addObject("right", new rightAuto());
        auto.addObject("center", new CenterAuto());
        auto.addObject("baseline", new baselineAuto());
        SmartDashboard.putData("Autonomous program", auto);
        oi = new OI();
        oi.preciseDriveButton.toggleWhenActive(new PreciseDrive());
        oi.liftOnButton.toggleWhenActive(new RunLift());
        oi.cameraButton.whenReleased(new switchCameraToFront());
        oi.stopButton.whenPressed(new DisableDrive());
        SmartDashboard.putData(Scheduler.getInstance());
		SmartDashboard.putData(Robot.Drivetrain);
		SmartDashboard.putData(Robot.Lift);
		SmartDashboard.putString("Camera Direction:", "Forward");
		dashboard();
//        LiftActive.whileActive(new DisableDrive());
        
        
    }
	
    public void dashboard() {
    	SmartDashboard.putNumber("range:", autoVars.getRange());
		SmartDashboard.putNumber("Voltage:", Robot.pdp.getVoltage());
		SmartDashboard.putNumber("Current:", Robot.pdp.getTotalCurrent());
    }
    
    public static void camera() {
		String Direction = SmartDashboard.getString("Camera Direction", "Forward");
		if (Direction == "Forward") {
			SmartDashboard.putString("Camera Direction:", "Reverse");
		}
		else {
			SmartDashboard.putString("Camera Direction:", "Forward");
		}
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
        autoCommand = (Command) auto.getSelected();
//        autoCommand.start();
//		 String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
//		switch(autoSelected) {
//		case "My Auto":
//			autonomousCommand = new MyAutoCommand();
//			break;
//		case "Default Auto":
//		default:
//			break;
//		} 
    	
    	// schedule the autonomous command (example)
        if (autoCommand != null) autoCommand.start();
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
        dashboard();
        

    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
