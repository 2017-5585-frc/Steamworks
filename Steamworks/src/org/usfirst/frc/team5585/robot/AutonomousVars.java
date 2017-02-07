package org.usfirst.frc.team5585.robot;

import org.usfirst.frc.team5585.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;

public class AutonomousVars {
	private int loopsRun;
	
	private double startTime;
	private double timeElapsed;
	
	private boolean gearPlaced;
	private boolean turned;
	
	private double range;
	private double distanceTraveled;
	
	public void init() {
		loopsRun = 0;
		distanceTraveled = 0;
		timeElapsed = 0;
		startTime = 0;
		gearPlaced = false;
	}
	
	public int getLoopsRun() {
		return loopsRun;
	}
	
	public void incrementLoopCount() {
		loopsRun += 1;
	}
	
	//distance vars
	public double getDistanceTraveled() {
		return distanceTraveled;
	}
	
	public void setDistanceTraveled(double distance) {
		distanceTraveled += distance;
	}
	
	public void calculateDistanceTraveled(double time, double speed) {
		distanceTraveled += time * speed;
	}
	
	public void resetDistanceTraveled() {
		distanceTraveled = 0;
	}
	
	// time vars
	public void setStartTime() {
		startTime = Timer.getFPGATimestamp(); //in seconds
	}
	
	public double getElapsedTime() {
		double currentTime = Timer.getFPGATimestamp();
		if (startTime != 0) {
			timeElapsed = currentTime - startTime;
			return timeElapsed;
		}
		else {
			return 0.0;
		}
	}
	
	public double getTimeRemaining(double endTime) {
		return endTime - getElapsedTime();
	}
	
	//top level vars
	public void setTurned(boolean isTurned) {
		turned = isTurned;
	}
	
	public boolean getIsTurned() {
		return turned;
	}
	
	public void setGearPlaced(boolean placed) {
		gearPlaced = placed;
	}
	
	public boolean isGearPlaced() {
		return gearPlaced;
	}
	
	public double getRange() {
		range = RobotMap.rangeFinder.getValue() / 120;
		return range;
	}
	

	}
