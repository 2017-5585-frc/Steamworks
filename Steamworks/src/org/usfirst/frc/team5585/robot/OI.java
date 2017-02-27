package org.usfirst.frc.team5585.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * Contains joystick objects, and joystickbutton objects.
 */
public class OI {
	public static Joystick joystick, xbox;
	
    public Button liftOnButton, liftOffButton, preciseDriveButton, frontCameraButton, rearCameraButton, stopButton;
    
    /**
     * This method initializes the OI class.
     */
    public OI() {
        joystick = new Joystick(RobotMap.joystickPort); //joysticks
        xbox = new Joystick(RobotMap.xboxport); //possibly use new wpilib.getIsXbox() to make this dynamic next year.
        
    	liftOnButton = new JoystickButton(xbox, 5); //joystick buttons
    	liftOffButton = new JoystickButton(xbox, 6);
    	preciseDriveButton = new JoystickButton(joystick,1);
    	frontCameraButton = new JoystickButton(joystick,5);
    	rearCameraButton = new JoystickButton(joystick,3);
    	stopButton = new JoystickButton(joystick,2);
    	
    	
    }
}
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.

    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.

    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.


