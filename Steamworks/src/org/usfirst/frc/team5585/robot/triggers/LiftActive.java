package org.usfirst.frc.team5585.robot.triggers;

import edu.wpi.first.wpilibj.buttons.Trigger;

import org.usfirst.frc.team5585.robot.Robot;

/**
 * trigger to determine whether lift system is active. Unused. due for removal.
 * @since 2/7/2017
 * @author Ian Bolin
 * @category Trigger
 * @category Unused
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
