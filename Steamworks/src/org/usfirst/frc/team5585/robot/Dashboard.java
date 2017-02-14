package org.usfirst.frc.team5585.robot;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Dashboard {
	public void run() {
		SmartDashboard.putData(Scheduler.getInstance());
		SmartDashboard.putData(Robot.Drivetrain);
		SmartDashboard.putData(Robot.Lift);
		SmartDashboard.putString("Camera Direction:", "Forward");
		SmartDashboard.putDouble("range:", RobotMap.rangeFinder.getAverageVoltage() * 512 * 0.39);
		SmartDashboard.putNumber("Voltage:", Robot.pdp.getVoltage());
		SmartDashboard.putNumber("Current:", Robot.pdp.getTotalCurrent());

	}
	
	public void camera() {
		String Direction = SmartDashboard.getString("Camera Direction", "Forward");
		if (Direction == "Forward") {
			SmartDashboard.putString("Camera Direction:", "Reverse");
		}
		else {
			SmartDashboard.putString("Camera Direction:", "Forward");
		}
	}

}
