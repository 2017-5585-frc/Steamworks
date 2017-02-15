package org.usfirst.frc.team5585.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.cscore.UsbCamera;

public class Server17 {
	private static CameraServer server;
	private static UsbCamera front, rear;
	/**
	 * Dual USB camera server, designed around the updated WPILIB v2017.2.1
	 * @author Ian Bolin, FIRST Team 5585
	 * @since 2/15/2017
	 */
	
	public void init() {
		Server17.server = CameraServer.getInstance();
		Server17.front = new UsbCamera("cam0", 0);
		Server17.rear = new UsbCamera("cam1", 1);
		Server17.server.addCamera(front);
		Server17.server.addCamera(rear);
		
	}
	
	public static void start() {
		Server17.server.startAutomaticCapture(front);
	}
	
	public static void changeCameraTo(String cam) {
		if (cam == "front") {
			Server17.server.startAutomaticCapture(front);
		}
		if (cam == "rear") {
			Server17.server.startAutomaticCapture(rear);
		}
	}

}
