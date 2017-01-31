package org.usfirst.frc.team5585.robot.triggers;

import edu.wpi.first.wpilibj.buttons.Trigger;

import org.usfirst.frc.team5585.robot.Robot;

/**
 *
 */
public class LiftActive extends Trigger {
    
    public boolean get() {
        if(Robot.Lift.active) {
        	return true;
        }
        else{
        	return false;
        }
    }
}
