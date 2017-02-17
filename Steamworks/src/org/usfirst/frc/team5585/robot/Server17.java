package org.usfirst.frc.team5585.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.cscore.UsbCamera;

public class Server17 {
	private static CameraServer server;
	private static UsbCamera front, rear, current;
	/**
	 * Dual USB camera server, designed around the updated WPILIB v2017.2.1
	 * @author Ian Bolin, FIRST Team 5585
	 * @since 2/15/2017
	 */
	
	public static void init() {
		Server17.server = CameraServer.getInstance();
		System.out.println("created server");
		Server17.front = new UsbCamera("cam0", "/dev/video0");
		Server17.rear = new UsbCamera("cam1", "/dev/video1");
		Server17.current = Server17.front;
		System.out.println("created cam0, cam1; set current cam to 0");
		Server17.server.addCamera(front);
		Server17.server.addCamera(rear);
		System.out.println("added cameras to server");
		
		
	}
	
	public static void start() {
		Server17.server.startAutomaticCapture(current);
	}
	
	public static void changeCameraTo(String cam) {
		if (cam == "front") {
			Server17.rear.free();
			Server17.rear = new UsbCamera("cam1", "/dev/video1");
			Server17.front = new UsbCamera("cam0", "/dev/video0");
			Server17.current = Server17.front;
		}
		if (cam == "rear") {
			Server17.front.free();
			Server17.front = new UsbCamera("cam1", "/dev/video0");
			Server17.rear = new UsbCamera("cam0", "/dev/video1");
			Server17.current = Server17.rear;
		}
		start();
	}

}
