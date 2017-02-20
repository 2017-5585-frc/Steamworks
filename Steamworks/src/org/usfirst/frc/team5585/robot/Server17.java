package org.usfirst.frc.team5585.robot;

import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.CameraServer;

public class Server17 {
	private static CameraServer server;
	private static UsbCamera front, rear, current;
	private static VideoSink stream;
	/**
	 * Dual USB camera server, designed around the updated WPILIB v2017.2.1
	 * @author Ian Bolin, FIRST Team 5585
	 * @since 2/15/2017
	 */

	public static void init() {
		server = CameraServer.getInstance();
		server.addServer("current");
		stream = server.getServer("current");
		System.out.println("created server");
		front = new UsbCamera("cam0", "/dev/video0");
		front.setResolution(640, 480);
		front.setFPS(25);
		
		rear = new UsbCamera("cam1", "/dev/video1");
		rear.setResolution(160 , 120);
		rear.setFPS(20);
		current = Server17.front;
		System.out.println("created cam0, cam1; set current cam to 0");
		start();
		
		
	}
	
	public static void start() {
		Server17.stream.setSource(current);
	}
	
	public static void changeCameraTo(String cam) {
		if (cam == "front") {
//			Server17.rear.free();
//			Server17.rear = new UsbCamera("cam1", "/dev/video1");
//			Server17.front = new UsbCamera("cam0", "/dev/video0");
			current = Server17.front;
		}
		if (cam == "rear") {
//			Server17.front.free();
//			Server17.front = new UsbCamera("cam1", "/dev/video0");
//			Server17.rear = new UsbCamera("cam0", "/dev/video1");
			current = Server17.rear;
		}
		start();
	}

}
