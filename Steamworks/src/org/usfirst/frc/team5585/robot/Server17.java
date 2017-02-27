package org.usfirst.frc.team5585.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.CameraServer;

/**
 * Dual USB camera server, designed around the updated WPILIB v2017.2.1
 * Date: 2/15/2017
 * @author Ian Bolin, FIRST Team 5585
 */
public class Server17 {
	private static CameraServer server;
	private static UsbCamera front, rear, current;
	private static VideoSink stream;

	/**
	 * inits server17
	 */
	public static void init() {
		server = CameraServer.getInstance();
		server.addServer("current"); //creates a mjpeg server
		stream = server.getServer("current"); //creates an easy access var for the mjpeg server
		System.out.println("created server");
		front = new UsbCamera("cam0", "/dev/video0"); // create camera one
		front.setResolution(640, 480);
		front.setFPS(25);
		
		rear = new UsbCamera("cam1", "/dev/video1"); // create camera two
		rear.setResolution(160 , 120);
		rear.setFPS(20);
		current = Server17.front; //sets current camera
		System.out.println("created cam0, cam1; set current cam to 0");
		start(); //starts server
		
		
	}
	
	/**
	 * starts server. Called by init()
	 */
	public static void start() {
		Server17.stream.setSource(current);
	}
	
	/**
	 * changes the current camera
	 * @param cam - the camera to change to ("front" or "rear").
	 */
	public static void changeCameraTo(String cam) {
		if (cam == "front") {
			current = Server17.front;
		}
		if (cam == "rear") {
			current = Server17.rear;
		}
		start();
	}

}
