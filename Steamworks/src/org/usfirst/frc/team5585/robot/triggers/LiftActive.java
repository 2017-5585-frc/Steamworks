package org.usfirst.frc.team5585.robot.triggers;

import edu.wpi.first.wpilibj.buttons.Trigger;

import org.usfirst.frc.team5585.robot.Robot;

/**
 * trigger to determine whether lift system is active. Unused. kept for illustration purposes. <br>
 * Written on 2/7/2017
 * @author Ian Bolin
 * @category Trigger
 */
public class LiftActive extends Trigger {
    
	/**
	 * gets the state of the lift.
	 * @return The state of the lift.
	 */
    public boolean get() {
        if(Robot.Lift.active) {
        	return true;
        }
        else{
        	return false;
        }
    }
}
